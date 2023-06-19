package shared.errors;

public class NoFreightsRegistered extends BaseRunTimeException {
    public NoFreightsRegistered() {
        super("Nenhum frete cadastrado, realize a criação de algum frete",
                "No freight registered, create some freight",
                "No freight registered", "HUSM0028");
    }
}
