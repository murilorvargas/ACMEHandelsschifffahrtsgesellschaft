package shared.errors;

public class ClientEmailNotFound extends BaseRunTimeException {

    public ClientEmailNotFound(String email) {
        super("Cliente não encontrado para o seguinte email: " + email,
                "Client not found for following email: " + email,
                "Client email not found", "HUSM0020");
    }

}
