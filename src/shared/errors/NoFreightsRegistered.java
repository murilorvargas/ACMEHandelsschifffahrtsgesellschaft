package shared.errors;

public class NoFreightsRegistered extends BaseRunTimeException {
    public NoFreightsRegistered() {
        super("Nenhum frete pendente, atualize a fila de cargas pendentes",
                "No pending freight, refresh pending cargo queue",
                "No pending freight", "HUSM0028");
    }
}
