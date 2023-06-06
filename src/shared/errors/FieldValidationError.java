package shared.errors;

public class FieldValidationError extends BaseRunTimeException {
    public FieldValidationError(String errors) {
        super("Um ou mais erros ocorreram durante a validação dos campos: " + errors,
                "One or more errors occurred during field validation: " + errors,
                "Field validation error", "HUSM0001");
    }
}
