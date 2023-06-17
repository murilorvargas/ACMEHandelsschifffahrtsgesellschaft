package modules.ship;

import java.util.List;

import modules.ship.dtos.CreateShipDTO;
import modules.ship.dtos.FindShipByNameDTO;
import modules.ship.entities.interfaces.IShipReadable;
import modules.ship.repositories.interfaces.IShipRepository;

import shared.errors.NoShipRegistered;
import shared.errors.ShipNameAlreadyExists;
import shared.errors.ShipNotFound;

public class ShipService {

    private IShipRepository shipRepository;

    public ShipService(IShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public IShipReadable createShip(CreateShipDTO createShipDTO) {
        IShipReadable ship = this.shipRepository.findByName(createShipDTO.getName());

        if (ship == null) {
            return this.shipRepository.create(createShipDTO.getName(), createShipDTO.getSpeed(),
                    createShipDTO.getAutonomy(), createShipDTO.getCostPerMile());
        } else {
            throw new ShipNameAlreadyExists(String.valueOf(createShipDTO.getName()));
        }
    }

    public List<IShipReadable> findAllShips() {
        List<IShipReadable> ship = this.shipRepository.findAll();
        if (ship.isEmpty()) {
            throw new NoShipRegistered();
        }

        return ship;
    }

    public IShipReadable findShipByName(FindShipByNameDTO findShipByNameDTO) {
        IShipReadable ship = this.shipRepository.findByName(findShipByNameDTO.getName());

        if (ship == null) {
            throw new ShipNotFound(String.valueOf(findShipByNameDTO.getName()));
        }

        return ship;
    }

}
