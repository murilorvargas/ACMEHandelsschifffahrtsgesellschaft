package modules.cargo;

import java.util.TreeSet;

import modules.cargo.dtos.CreateCargoDTO;
import modules.cargo.dtos.FindCargoByIdDTO;
import modules.cargo.dtos.UpdateCargoStatusDTO;
import modules.cargo.entities.ICargoReadable;
import modules.cargo.enums.CargoStatus;
import modules.cargo.repositories.ICargoRepository;
import modules.cargo.repositories.in_memory.InMemoryCargoRepository;
import modules.cargoType.entities.ICargoTypeReadable;
import modules.cargoType.repositories.ICargoTypeRepository;
import modules.cargoType.repositories.in_memory.InMemoryCargoTypeRepository;
import shared.errors.CargoNotFound;
import shared.errors.CargoTypeNotFound;
import shared.errors.NoCargoRegistered;
import shared.errors.StatusChangeNotAllowed;

public class CargoService {
    private ICargoTypeRepository cargoTypeRepository;
    private ICargoRepository cargoRepository;

    public CargoService() {
        this.cargoTypeRepository = InMemoryCargoTypeRepository.instanceOf();
        this.cargoRepository = InMemoryCargoRepository.instanceOf();
    }

    public ICargoReadable createCargo(CreateCargoDTO createCargoDTO) {
        ICargoTypeReadable cargoType = this.cargoTypeRepository.findByNumber(createCargoDTO.getCargoTypeNumber());

        if (cargoType == null) {
            throw new CargoTypeNotFound(String.valueOf(createCargoDTO.getCargoTypeNumber()));
        }

        return this.cargoRepository.create(createCargoDTO.getId(), createCargoDTO.getWeight(),
                createCargoDTO.getDeclaredValue(),
                createCargoDTO.getMaxTime(), cargoType);
    }

    public ICargoReadable updateCargoStatus(UpdateCargoStatusDTO updateCargoStatusDTO) {
        ICargoReadable cargo = this.cargoRepository.findById(updateCargoStatusDTO.getId());
        if (cargo == null) {
            throw new CargoNotFound(String.valueOf(updateCargoStatusDTO.getId()));
        }

        if (cargo.getStatus() == CargoStatus.COMPLETED) {
            throw new StatusChangeNotAllowed();
        }

        if (cargo.getStatus() == updateCargoStatusDTO.getCargoStatus()) {
            return cargo;
        }

        return this.cargoRepository.updateStatus(updateCargoStatusDTO.getId(), updateCargoStatusDTO.getCargoStatus());
    }

    public TreeSet<ICargoReadable> findAllCargos() {
        TreeSet<ICargoReadable> cargos = this.cargoRepository.findAll();
        if (cargos.isEmpty()) {
            throw new NoCargoRegistered();
        }

        return cargos;
    }

    public ICargoReadable findCargoById(FindCargoByIdDTO findCargoByIdDTO) {
        ICargoReadable cargo = this.cargoRepository.findById(findCargoByIdDTO.getId());
        if (cargo == null) {
            throw new CargoNotFound(String.valueOf(findCargoByIdDTO.getId()));
        }

        return cargo;
    }
}
