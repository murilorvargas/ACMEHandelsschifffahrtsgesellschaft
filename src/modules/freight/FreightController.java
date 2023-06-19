package modules.freight;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import modules.freight.dtos.FinishFreightDTO;
import shared.errors.FieldValidationError;

public class FreightController {

    private FreightService freightService;

    public FreightController() {
        this.freightService = new FreightService();
    }

    public void onCreateFreights() {
        freightService.createFreights();
    }

    public void onFinishFreight(String freightId) {
        FinishFreightDTO finishFreightDTO = new FinishFreightDTO(freightId);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<FinishFreightDTO>> violations = validator.validate(finishFreightDTO);

        if (!violations.isEmpty()) {
            String errors = "";
            for (ConstraintViolation<FinishFreightDTO> violation : violations) {
                errors += violation.getMessage() + "\n";
            }
            throw new FieldValidationError(errors);
        } else {
            freightService.finishFreight(finishFreightDTO);
        }
    }

}
