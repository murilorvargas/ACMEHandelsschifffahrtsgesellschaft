package modules.harbor;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import modules.harbor.dtos.CreateHarborDTO;
import modules.harbor.dtos.FindHarborByIdDTO;
import modules.harbor.entities.interfaces.IHarborReadable;
import shared.errors.FieldValidationError;

public class HarborController {
    private HarborService harborService;

    public HarborController(HarborService harborService) {
        this.harborService = harborService;
    }

    public IHarborReadable onCreateHarbor(int id, String name, String country) {
        CreateHarborDTO createHarborDTO = new CreateHarborDTO(id, name, country);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<CreateHarborDTO>> violations = validator.validate(createHarborDTO);

        if (!violations.isEmpty()) {
            String errors = "";
            for (ConstraintViolation<CreateHarborDTO> violation : violations) {
                errors += violation.getMessage() + "\n";
            }
            throw new FieldValidationError(errors);
        } else {
            return harborService.createHarbor(createHarborDTO);
        }
    }

    public List<IHarborReadable> onFindAllHarbors() {
        return harborService.findAllHarbors();
    }

    public IHarborReadable findHarborById(int id) {
        FindHarborByIdDTO findHarborByIdDTO = new FindHarborByIdDTO(id);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<FindHarborByIdDTO>> violations = validator.validate(findHarborByIdDTO);

        if (!violations.isEmpty()) {
            String errors = "";
            for (ConstraintViolation<FindHarborByIdDTO> violation : violations) {
                errors += violation.getMessage() + "\n";
            }
            throw new FieldValidationError(errors);
        } else {
            return harborService.findHarborById(findHarborByIdDTO);
        }
    }
}
