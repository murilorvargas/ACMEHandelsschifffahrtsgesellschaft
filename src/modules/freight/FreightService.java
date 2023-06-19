package modules.freight;

import java.util.ArrayList;
import java.util.List;

import modules.cargo.entities.interfaces.ICargoReadable;
import modules.cargo.enums.CargoPriority;
import modules.cargo.enums.CargoStatus;
import modules.cargo.repositories.InMemoryCargoRepository;
import modules.cargo.repositories.interfaces.ICargoRepository;
import modules.cargoType.entities.DurableCargoType;
import modules.cargoType.entities.interfaces.IDurableCargoTypeReadable;
import modules.freight.dtos.FinishFreightDTO;
import modules.freight.entities.interfaces.IFreightReadable;
import modules.freight.enums.FreightStatus;
import modules.freight.repositories.InMemoryFreightRepository;
import modules.freight.repositories.interfaces.IFreightRepository;
import modules.harborDistance.entities.interfaces.IHarborDistanceReadable;
import modules.harborDistance.repositories.InMemoryHarborDistanceRepository;
import modules.harborDistance.repositories.interfaces.IHarborDistanceRepository;
import modules.ship.entities.interfaces.IShipReadable;
import modules.ship.repositories.InMemoryShipRepository;
import modules.ship.repositories.interfaces.IShipRepository;
import shared.errors.FreightNotFound;
import shared.errors.HarborDistanceNotFound;
import shared.errors.NoFreightsRegistered;

public class FreightService {
    private IFreightRepository freightRepository;
    private IShipRepository shipRepository;
    private ICargoRepository cargoRepository;
    private IHarborDistanceRepository harborDistanceRepository;

    public FreightService() {
        this.freightRepository = InMemoryFreightRepository.instanceOf();
        this.shipRepository = InMemoryShipRepository.instanceOf();
        this.cargoRepository = InMemoryCargoRepository.instanceOf();
        this.harborDistanceRepository = InMemoryHarborDistanceRepository.instanceOf();
    }

    public void createFreights() {
        List<IShipReadable> ships = this.shipRepository.findAll();
        List<ICargoReadable> pendingCargos = this.cargoRepository.findByStatus(CargoStatus.PENDING);

        for (ICargoReadable pendingCargo : pendingCargos) {
            IHarborDistanceReadable harborDistance = this.harborDistanceRepository.findByHarbors(
                    pendingCargo.getOriginHarbor().getId(), pendingCargo.getDestinationHarbor().getId());

            if (harborDistance == null) {
                throw new HarborDistanceNotFound(String.valueOf(pendingCargo.getOriginHarbor().getId()),
                        String.valueOf(pendingCargo.getDestinationHarbor().getId()));
            }

            List<IShipReadable> shipsWithAutonomy = new ArrayList<>();
            for (IShipReadable ship : ships) {
                if (ship.getAutonomy() > harborDistance.getValue()) {
                    shipsWithAutonomy.add(ship);
                }
            }

            if (shipsWithAutonomy.size() == 0) {
                this.cargoRepository.updateStatus(pendingCargo.getId(), CargoStatus.CANCELED);
                continue;
            }

            List<IShipReadable> shipsThatCanDeliver = new ArrayList<>();
            for (IShipReadable ship : shipsWithAutonomy) {
                if (this.canDeliver(ship.getSpeed(), harborDistance.getValue(), pendingCargo.getMaxTime())) {
                    shipsThatCanDeliver.add(ship);
                }
            }

            if (shipsThatCanDeliver.size() == 0) {
                this.cargoRepository.updateStatus(pendingCargo.getId(), CargoStatus.CANCELED);
                continue;
            }

            for (IShipReadable ship : shipsThatCanDeliver) {
                if (ship.getIsAvailable()) {
                    this.freightRepository.createFreight(this.freightCost(ship, pendingCargo, harborDistance),
                            FreightStatus.IN_PROGRESS, ship, pendingCargo);
                    this.cargoRepository.updateStatus(pendingCargo.getId(), CargoStatus.RENTED);
                    this.shipRepository.updateAvailability(ship.getId(), false);
                }
                break;
            }

        }
    }

    public void finishFreight(FinishFreightDTO finishFreightDTO) {
        IFreightReadable freight = this.freightRepository.findById(finishFreightDTO.getFreightId());
        if (freight == null) {
            throw new FreightNotFound(finishFreightDTO.getFreightId());
        }
        this.freightRepository.updateFreight(finishFreightDTO.getFreightId(), FreightStatus.COMPLETED);
        this.shipRepository.updateAvailability(freight.getShip().getId(), true);
        this.cargoRepository.updateStatus(freight.getCargo().getId(), CargoStatus.COMPLETED);
    }

    public List<IFreightReadable> findAllInProgressFreights() {
        List<IFreightReadable> freightsList =  this.freightRepository.findAllInProgress();
        if (freightsList.isEmpty()) {
            throw new NoFreightsRegistered();
        }

        return freightsList;
    }

    private boolean canDeliver(double shipSpeed, double distanceInNauticalMiles, int maxTimeInDays) {
        double estimatedTimeInHours = distanceInNauticalMiles / shipSpeed;
        double estimatedTimeInDays = estimatedTimeInHours / 24;

        return estimatedTimeInDays <= maxTimeInDays;
    }

    private double freightCost(IShipReadable ship, ICargoReadable cargo, IHarborDistanceReadable harborDistance) {
        double distanceCost = harborDistance.getValue()
                * (cargo.getPriority().equals(CargoPriority.CHEAP) ? ship.getCostPerMile() : ship.getCostPerMile() * 2);

        double weightCost;

        if (cargo.getCargoType() instanceof DurableCargoType) {
            IDurableCargoTypeReadable durableCargo = (IDurableCargoTypeReadable) cargo;
            weightCost = (cargo.getWeight() * 1.5)
                    + ((cargo.getDeclaredValue() / 100) * durableCargo.getIpiPercentage());
        } else {
            weightCost = cargo.getWeight() * 2;
        }

        double regionCost;

        if (cargo.getOriginHarbor().getCountry().equals("Brasil")
                && cargo.getOriginHarbor().getCountry().equals(cargo.getDestinationHarbor().getCountry())) {
            regionCost = 10000;
        } else {
            regionCost = 50000;
        }

        return distanceCost + weightCost + regionCost;
    }
}
