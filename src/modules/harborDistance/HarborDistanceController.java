package modules.harborDistance;

import modules.harborDistance.dtos.CreateHarborDistanceDTO;
import modules.harborDistance.entities.interfaces.IHarborDistanceReadable;
import shared.errors.FieldValidationError;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class HarborDistanceController {
    private HarborDistanceService harborDistanceService;

    public HarborDistanceController(HarborDistanceService harborDistanceService) {
        this.harborDistanceService = harborDistanceService;
    }

    public IHarborDistanceReadable onCreateHarborDistance(double value, int firstHarborId, int secondHarborId) {
        CreateHarborDistanceDTO createHarborDistanceDTO = new CreateHarborDistanceDTO(value, firstHarborId,
                secondHarborId);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<CreateHarborDistanceDTO>> violations = validator.validate(createHarborDistanceDTO);

        if (!violations.isEmpty()) {
            String errors = "";
            for (ConstraintViolation<CreateHarborDistanceDTO> violation : violations) {
                errors += violation.getMessage() + "\n";
            }
            throw new FieldValidationError(errors);
        } else {
            return harborDistanceService.createHarborDistance(createHarborDistanceDTO);
        }
    }
}
