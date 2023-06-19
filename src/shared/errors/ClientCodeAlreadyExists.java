package shared.errors;

public class ClientCodeAlreadyExists extends BaseRunTimeException {

    public ClientCodeAlreadyExists(String code) {
        super("Cliente já existe com o código " + code + " já existe",
                "Client with code " + code + " already exists",
                "Client Code already exists", "HUSM0015");
    }
}
