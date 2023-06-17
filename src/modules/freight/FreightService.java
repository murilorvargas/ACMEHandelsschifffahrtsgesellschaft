package modules.freight;

import java.util.List;

import modules.cargo.entities.interfaces.ICargoReadable;
import modules.cargo.enums.CargoStatus;
import modules.cargo.repositories.InMemoryCargoRepository;
import modules.cargo.repositories.interfaces.ICargoRepository;
import modules.cargoType.repositories.InMemoryCargoTypeRepository;
import modules.cargoType.repositories.interfaces.ICargoTypeRepository;
import modules.harbor.repositories.InMemoryHarborRepository;
import modules.harbor.repositories.interfaces.IHarborRepository;

public class FreightService {
    private IHarborRepository harborRepository;
    private ICargoTypeRepository cargoTypeRepository;
    private ICargoRepository cargoRepository;

    public FreightService() {
        this.harborRepository = InMemoryHarborRepository.instanceOf();
        this.cargoTypeRepository = InMemoryCargoTypeRepository.instanceOf();
        this.cargoRepository = InMemoryCargoRepository.instanceOf();
    }

    public void createFreights() {
        List<ICargoReadable> pendingCargos = this.cargoRepository.findByStatus(CargoStatus.PENDING);
    }
}
