package shared.errors;

public class FreightAlreadyCompleted extends BaseRunTimeException {
    public FreightAlreadyCompleted(String id) {
        super("Frete com id " + id + " já foi finalizado",
                "Freight with id " + id + " already completed",
                "Freight already completed", "HUSM0032");
    }
}
