package modules.cargo;

import java.util.Set;
import java.util.TreeSet;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import modules.cargo.dtos.CreateCargoDTO;
import modules.cargo.dtos.FindCargoByIdDTO;
import modules.cargo.dtos.UpdateCargoStatusDTO;
import modules.cargo.entities.interfaces.ICargoReadable;
import modules.cargo.enums.CargoStatus;
import shared.errors.FieldValidationError;

public class CargoController {
    private CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    public ICargoReadable onCreateCargo(int id, double weight, double declaredValue, int maxTime,
            int cargoTypeNumber) {
        CreateCargoDTO createCargoDTO = new CreateCargoDTO(id, weight, declaredValue, maxTime, cargoTypeNumber);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<CreateCargoDTO>> violations = validator.validate(createCargoDTO);

        if (!violations.isEmpty()) {
            String errors = "";
            for (ConstraintViolation<CreateCargoDTO> violation : violations) {
                errors += violation.getMessage() + "\n";
            }
            throw new FieldValidationError(errors);
        } else {
            return cargoService.createCargo(createCargoDTO);
        }
    }

    public ICargoReadable onUpdateCargoStatus(int id, String cargoStatus) {
        CargoStatus cargoStatusEnum = null;
        try {
            cargoStatusEnum = CargoStatus.valueOf(cargoStatus.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new FieldValidationError("Status of the cargo that was sent is invalid");
        }

        UpdateCargoStatusDTO updateCargoStatusDTO = new UpdateCargoStatusDTO(id, cargoStatusEnum);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<UpdateCargoStatusDTO>> violations = validator.validate(updateCargoStatusDTO);

        if (!violations.isEmpty()) {
            String errors = "";
            for (ConstraintViolation<UpdateCargoStatusDTO> violation : violations) {
                errors += violation.getMessage() + "\n";
            }
            throw new FieldValidationError(errors);
        } else {
            return cargoService.updateCargoStatus(updateCargoStatusDTO);
        }
    }

    public TreeSet<ICargoReadable> onFindAllCargos() {
        return cargoService.findAllCargos();
    }

    public ICargoReadable onFindCargoById(int id) {
        FindCargoByIdDTO findCargoByIdDTO = new FindCargoByIdDTO(id);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<FindCargoByIdDTO>> violations = validator.validate(findCargoByIdDTO);

        if (!violations.isEmpty()) {
            String errors = "";
            for (ConstraintViolation<FindCargoByIdDTO> violation : violations) {
                errors += violation.getMessage() + "\n";
            }
            throw new FieldValidationError(errors);
        } else {
            return cargoService.findCargoById(findCargoByIdDTO);
        }
    }
}
