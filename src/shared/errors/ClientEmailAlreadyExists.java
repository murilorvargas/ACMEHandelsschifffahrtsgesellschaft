package shared.errors;

public class ClientEmailAlreadyExists extends BaseRunTimeException {

    public ClientEmailAlreadyExists(String email) {
        super("Cliente já existe com o email " + email + " já existe",
                "Client with email " + email + " already exists",
                "Client email already exists", "HUSM0017");
    }

}
