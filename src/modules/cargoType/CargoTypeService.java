package modules.cargoType;

import java.util.List;

import modules.cargoType.dtos.CreateDurableCargoTypeDTO;
import modules.cargoType.dtos.CreatePerishableCargoTypeDTO;
import modules.cargoType.entities.interfaces.ICargoTypeReadable;
import modules.cargoType.entities.interfaces.IDurableCargoTypeReadable;
import modules.cargoType.entities.interfaces.IPerishableCargoTypeReadable;
import modules.cargoType.repositories.InMemoryCargoTypeRepository;
import modules.cargoType.repositories.interfaces.ICargoTypeRepository;
import shared.errors.CargoTypeAlreadyExists;
import shared.errors.NoCargoTypeRegistered;

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

    public List<ICargoTypeReadable> findAllCargoTypes() {
        List<ICargoTypeReadable> cargoType = this.cargoTypeRepository.findAll();

        if (cargoType.isEmpty()) {
            throw new NoCargoTypeRegistered();
        }

        return cargoType;
    }
}
