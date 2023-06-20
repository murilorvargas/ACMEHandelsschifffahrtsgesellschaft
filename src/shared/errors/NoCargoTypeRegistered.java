package shared.errors;

public class NoCargoTypeRegistered extends BaseRunTimeException {

    public NoCargoTypeRegistered() {
        super("Nenhum tipo de carga cadastrado, realize a criação de algum tipo de carga",
                "No cargo type registered, create some cargo type", "No cargo type registered", "HUSM0029");
    }

}
