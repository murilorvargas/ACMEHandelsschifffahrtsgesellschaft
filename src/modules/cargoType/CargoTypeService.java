package modules.cargoType;

import modules.cargoType.dtos.CreateDurableCargoTypeDTO;
import modules.cargoType.dtos.CreatePerishableCargoTypeDTO;
import modules.cargoType.entities.CargoType;
import modules.cargoType.repositories.ICargoTypeRepository;
import modules.cargoType.repositories.in_memory.InMemoryCargoTypeRepository;
import shared.errors.CargoTypeAlreadyExists;

public class CargoTypeService {
    private ICargoTypeRepository cargoTypeRepository;

    public CargoTypeService() {
        this.cargoTypeRepository = InMemoryCargoTypeRepository.instanceOf();
    }

    public void createPerishableCargoType(CreatePerishableCargoTypeDTO createPerishableCargoTypeDTO) {
        CargoType cargoType = this.cargoTypeRepository.findById(createPerishableCargoTypeDTO.getId());
        if (cargoType != null) {
            throw new CargoTypeAlreadyExists(createPerishableCargoTypeDTO.getId());
        }
        this.cargoTypeRepository.createPerishableCargoType(createPerishableCargoTypeDTO.getId(),
                createPerishableCargoTypeDTO.getDescription(), createPerishableCargoTypeDTO.getOrigin(),
                createPerishableCargoTypeDTO.getMaxValidityTime());
    }

    public void createDurableCargoType(CreateDurableCargoTypeDTO createDurableCargoTypeDTO) {
        CargoType cargoType = this.cargoTypeRepository.findById(createDurableCargoTypeDTO.getId());
        if (cargoType != null) {
            throw new CargoTypeAlreadyExists(createDurableCargoTypeDTO.getId());
        }
        this.cargoTypeRepository.createDurableCargoType(createDurableCargoTypeDTO.getId(),
                createDurableCargoTypeDTO.getDescription(), createDurableCargoTypeDTO.getSector(),
                createDurableCargoTypeDTO.getMainMaterial(), createDurableCargoTypeDTO.getIpiPercentage());
    }
}
