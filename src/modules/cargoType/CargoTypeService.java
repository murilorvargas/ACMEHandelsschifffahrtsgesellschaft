package modules.cargoType;

import modules.cargoType.dtos.CreateDurableCargoTypeDTO;
import modules.cargoType.dtos.CreatePerishableCargoTypeDTO;
import modules.cargoType.entities.ICargoTypeReadable;
import modules.cargoType.entities.IDurableCargoTypeReadable;
import modules.cargoType.entities.IPerishableCargoTypeReadable;
import modules.cargoType.repositories.ICargoTypeRepository;
import modules.cargoType.repositories.in_memory.InMemoryCargoTypeRepository;
import shared.errors.CargoTypeAlreadyExists;

public class CargoTypeService {
    private ICargoTypeRepository cargoTypeRepository;

    public CargoTypeService() {
        this.cargoTypeRepository = InMemoryCargoTypeRepository.instanceOf();
    }

    public IPerishableCargoTypeReadable createPerishableCargoType(
            CreatePerishableCargoTypeDTO createPerishableCargoTypeDTO) {
        ICargoTypeReadable cargoType = this.cargoTypeRepository.findByNumber(createPerishableCargoTypeDTO.getNumber());
        if (cargoType != null) {
            throw new CargoTypeAlreadyExists(String.valueOf(createPerishableCargoTypeDTO.getNumber()));
        }
        return this.cargoTypeRepository.createPerishableCargoType(
                createPerishableCargoTypeDTO.getNumber(),
                createPerishableCargoTypeDTO.getDescription(), createPerishableCargoTypeDTO.getOrigin(),
                createPerishableCargoTypeDTO.getMaxValidityTime());

    }

    public IDurableCargoTypeReadable createDurableCargoType(CreateDurableCargoTypeDTO createDurableCargoTypeDTO) {
        ICargoTypeReadable cargoType = this.cargoTypeRepository.findByNumber(createDurableCargoTypeDTO.getNumber());
        if (cargoType != null) {
            throw new CargoTypeAlreadyExists(String.valueOf(createDurableCargoTypeDTO.getNumber()));
        }
        return this.cargoTypeRepository.createDurableCargoType(
                createDurableCargoTypeDTO.getNumber(),
                createDurableCargoTypeDTO.getDescription(), createDurableCargoTypeDTO.getSector(),
                createDurableCargoTypeDTO.getMainMaterial(), createDurableCargoTypeDTO.getIpiPercentage());
    }
}
