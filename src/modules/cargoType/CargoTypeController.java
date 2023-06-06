package modules.cargoType;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import modules.cargoType.dtos.CreateDurableCargoTypeDTO;
import modules.cargoType.dtos.CreatePerishableCargoTypeDTO;
import shared.errors.FieldValidationError;

public class CargoTypeController {
    private CargoTypeService cargoTypeService;

    public CargoTypeController() {
        this.cargoTypeService = new CargoTypeService();
    }

    public void createPerishableCargoType(String id, String description, String origin, int maxValidityTime) {
        CreatePerishableCargoTypeDTO cargoTypeDTO = new CreatePerishableCargoTypeDTO(id, description, origin,
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
            cargoTypeService.createPerishableCargoType(cargoTypeDTO);
        }
    }

    public void createDurableCargoType(String id, String description, String sector, String mainMaterial,
            double ipiPercentage) {
        CreateDurableCargoTypeDTO cargoTypeDTO = new CreateDurableCargoTypeDTO(id, description, sector,
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
            cargoTypeService.createDurableCargoType(cargoTypeDTO);
        }
    }
}
