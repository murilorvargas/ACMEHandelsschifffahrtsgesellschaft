package modules.client;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import modules.client.dtos.CreateClientDTO;
import modules.client.dtos.FindClientByCodeDTO;
import modules.client.dtos.FindClientByEmailDTO;
import modules.client.dtos.FindClientByNameDTO;
import modules.client.entities.interfaces.IClientReadable;
import shared.errors.FieldValidationError;

public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientRepository) {
        this.clientService = clientRepository;
    }

    public IClientReadable onCreateClient(int code, String name, String email) {

        CreateClientDTO createClientDTO = new CreateClientDTO(code, name, email);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<CreateClientDTO>> violations = validator.validate(createClientDTO);

        if (!violations.isEmpty()) {
            String errors = "";
            for (ConstraintViolation<CreateClientDTO> violation : violations) {
                errors += violation.getMessage() + "\n";
            }
            throw new FieldValidationError(errors);
        } else {
            return clientService.createClient(createClientDTO);
        }

    }

    public List<IClientReadable> onFindAllClients() {
        return clientService.findAllClients();
    }

    public IClientReadable onFindClientByCode(int code) {
        FindClientByCodeDTO findClientByCodeDTO = new FindClientByCodeDTO(code);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<FindClientByCodeDTO>> violations = validator.validate(findClientByCodeDTO);

        if (!violations.isEmpty()) {
            String errors = "";
            for (ConstraintViolation<FindClientByCodeDTO> violation : violations) {
                errors += violation.getMessage() + "\n";
            }
            throw new FieldValidationError(errors);
        } else {
            return clientService.findClientByCode(findClientByCodeDTO);
        }
    }

    public IClientReadable onFindClientByName(String name) {
        FindClientByNameDTO findClientByNameDTO = new FindClientByNameDTO(name);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<FindClientByNameDTO>> violations = validator.validate(findClientByNameDTO);

        if (!violations.isEmpty()) {
            String errors = "";
            for (ConstraintViolation<FindClientByNameDTO> violation : violations) {
                errors += violation.getMessage() + "\n";
            }
            throw new FieldValidationError(errors);
        } else {
            return clientService.findClientByName(findClientByNameDTO);
        }
    }

    public IClientReadable onFindClientByEmail(String email) {
        FindClientByEmailDTO findClientByEmailDTO = new FindClientByEmailDTO(email);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<FindClientByEmailDTO>> violations = validator.validate(findClientByEmailDTO);

        if (!violations.isEmpty()) {
            String errors = "";
            for (ConstraintViolation<FindClientByEmailDTO> violation : violations) {
                errors += violation.getMessage() + "\n";
            }
            throw new FieldValidationError(errors);
        } else {
            return clientService.findClientByEmail(findClientByEmailDTO);
        }
    }

}
