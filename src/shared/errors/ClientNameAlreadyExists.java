package shared.errors;

public class ClientNameAlreadyExists extends BaseRunTimeException {

    public ClientNameAlreadyExists(String name) {
        super("Cliente já existe com o nome " + name + " já existe",
                "Client with name " + name + " already exists",
                "Client name already exists", "HUSM0016");
    }
}
