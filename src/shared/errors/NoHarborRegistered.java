package shared.errors;

public class NoHarborRegistered extends BaseRunTimeException {
    public NoHarborRegistered() {
        super("Nenhum porto cadastrado, realize a criação de algum porto",
                "No harbor registered, create some harbor",
                "No harbor registered", "HUSM0008");
    }
}
