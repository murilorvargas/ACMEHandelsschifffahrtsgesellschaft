package modules.cargoType;

import modules.cargoType.dtos.CreateDurableCargoTypeDTO;
import modules.cargoType.dtos.CreatePerishableCargoTypeDTO;
import modules.cargoType.entities.CargoType;
import modules.cargoType.entities.DurableCargoType;
import modules.cargoType.entities.PerishableCargoType;
import modules.cargoType.repositories.ICargoTypeRepository;
import modules.cargoType.repositories.in_memory.InMemoryCargoTypeRepository;
import shared.errors.CargoTypeAlreadyExists;

public class CargoTypeService {
    private ICargoTypeRepository cargoTypeRepository;

    public CargoTypeService() {
        this.cargoTypeRepository = InMemoryCargoTypeRepository.instanceOf();
    }

    public PerishableCargoType createPerishableCargoType(CreatePerishableCargoTypeDTO createPerishableCargoTypeDTO) {
        CargoType cargoType = this.cargoTypeRepository.findById(createPerishableCargoTypeDTO.getNumber());
        if (cargoType != null) {
            throw new CargoTypeAlreadyExists(createPerishableCargoTypeDTO.getNumber());
        }
        return this.cargoTypeRepository.createPerishableCargoType(
                createPerishableCargoTypeDTO.getNumber(),
                createPerishableCargoTypeDTO.getDescription(), createPerishableCargoTypeDTO.getOrigin(),
                createPerishableCargoTypeDTO.getMaxValidityTime());

    }

    public DurableCargoType createDurableCargoType(CreateDurableCargoTypeDTO createDurableCargoTypeDTO) {
        CargoType cargoType = this.cargoTypeRepository.findById(createDurableCargoTypeDTO.getNumber());
        if (cargoType != null) {
            throw new CargoTypeAlreadyExists(createDurableCargoTypeDTO.getNumber());
        }
        return this.cargoTypeRepository.createDurableCargoType(
                createDurableCargoTypeDTO.getNumber(),
                createDurableCargoTypeDTO.getDescription(), createDurableCargoTypeDTO.getSector(),
                createDurableCargoTypeDTO.getMainMaterial(), createDurableCargoTypeDTO.getIpiPercentage());
    }
}
