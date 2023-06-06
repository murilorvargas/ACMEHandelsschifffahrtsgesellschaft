package modules.cargoType;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import modules.cargoType.dtos.CreateDurableCargoTypeDTO;
import shared.errors.FieldValidationError;

public class CargoTypeController {
    private CargoTypeService cargoTypeService;

    public CargoTypeController() {
        this.cargoTypeService = new CargoTypeService();
    }

    public void createDurableCargoType(String description, String sector, String mainMaterial,
            double ipiPercentage) {
        CreateDurableCargoTypeDTO cargoTypeDTO = new CreateDurableCargoTypeDTO(description, sector,
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
