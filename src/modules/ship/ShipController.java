package modules.ship;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import modules.ship.dtos.CreateShipDTO;
import modules.ship.dtos.FindShipByNameDTO;
import modules.ship.entities.interfaces.IShipReadable;
import shared.errors.FieldValidationError;

public class ShipController {

    private ShipService shipService;

    public ShipController() {
        this.shipService = new ShipService();
    }

    public IShipReadable onCreateShip(String name, double speed, double autonomy, double costPerMile) {

        CreateShipDTO createShipDTO = new CreateShipDTO(name, speed, autonomy, costPerMile);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<CreateShipDTO>> violations = validator.validate(createShipDTO);

        if (!violations.isEmpty()) {
            String errors = "";
            for (ConstraintViolation<CreateShipDTO> violation : violations) {
                errors += violation.getMessage() + "\n";
            }
            throw new FieldValidationError(errors);
        } else {
            return shipService.createShip(createShipDTO);
        }

    }

    public List<IShipReadable> onFindAllShips() {
        return shipService.findAllShips();
    }

    public IShipReadable onFindShipByName(String name) {
        FindShipByNameDTO findShipByNameDTO = new FindShipByNameDTO(name);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<FindShipByNameDTO>> violations = validator.validate(findShipByNameDTO);

        if (!violations.isEmpty()) {
            String errors = "";
            for (ConstraintViolation<FindShipByNameDTO> violation : violations) {
                errors += violation.getMessage() + "\n";
            }
            throw new FieldValidationError(errors);
        } else {
            return shipService.findShipByName(findShipByNameDTO);
        }
    }
}
