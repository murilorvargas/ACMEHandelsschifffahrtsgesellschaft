package shared.errors;

public class StatusChangeNotAllowed extends BaseRunTimeException {
    public StatusChangeNotAllowed() {
        super("A carga está no status finalizada e a mudança não é permitida",
                "The payload is in completed status and change is not allowed",
                "Status change not allowed", "HUSM0006");
    }
}
