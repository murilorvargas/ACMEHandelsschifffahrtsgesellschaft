package modules.cargoType;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.List;
import java.util.Set;

import modules.cargoType.dtos.CreateDurableCargoTypeDTO;
import modules.cargoType.dtos.CreatePerishableCargoTypeDTO;
import modules.cargoType.entities.interfaces.ICargoTypeReadable;
import modules.cargoType.entities.interfaces.IDurableCargoTypeReadable;
import modules.cargoType.entities.interfaces.IPerishableCargoTypeReadable;
import shared.errors.FieldValidationError;

public class CargoTypeController {
    private CargoTypeService cargoTypeService;

    public CargoTypeController() {
        this.cargoTypeService = new CargoTypeService();
    }

    public IPerishableCargoTypeReadable onCreatePerishableCargoType(int number, String description, String origin,
            int maxValidityTime) {
        CreatePerishableCargoTypeDTO cargoTypeDTO = new CreatePerishableCargoTypeDTO(number, description, origin,
                maxValidityTime);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<CreatePerishableCargoTypeDTO>> violations = validator.validate(cargoTypeDTO);
        if (!violations.isEmpty()) {
            String errors = "";
            for (ConstraintViolation<CreatePerishableCargoTypeDTO> violation : violations) {
                errors += violation.getMessage() + "\n";
            }
            throw new FieldValidationError(errors);
        } else {
            return cargoTypeService.createPerishableCargoType(cargoTypeDTO);
        }
    }

    public IDurableCargoTypeReadable onCreateDurableCargoType(int number, String description, String sector,
            String mainMaterial,
            double ipiPercentage) {
        CreateDurableCargoTypeDTO cargoTypeDTO = new CreateDurableCargoTypeDTO(number, description, sector,
                mainMaterial, ipiPercentage);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<CreateDurableCargoTypeDTO>> violations = validator.validate(cargoTypeDTO);
        if (!violations.isEmpty()) {
            String errors = "";
            for (ConstraintViolation<CreateDurableCargoTypeDTO> violation : violations) {
                errors += violation.getMessage() + "\n";
            }
            throw new FieldValidationError(errors);
        } else {
            return cargoTypeService.createDurableCargoType(cargoTypeDTO);
        }
    }

    public List<ICargoTypeReadable> onFindAllCargoTypes() {
        return cargoTypeService.findAllCargoTypes();
    }
}
