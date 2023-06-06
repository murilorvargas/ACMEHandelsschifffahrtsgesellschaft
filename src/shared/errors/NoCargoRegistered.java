package shared.errors;

public class NoCargoRegistered extends BaseRunTimeException {
    public NoCargoRegistered() {
        super("Nenhuma carga cadastrada, realize a criação de alguma carga",
                "No cargo registered, create some cargo",
                "No cargo registered", "HUSM0004");
    }
}
