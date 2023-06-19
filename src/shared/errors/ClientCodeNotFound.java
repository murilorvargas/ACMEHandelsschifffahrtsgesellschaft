package shared.errors;

public class ClientCodeNotFound extends BaseRunTimeException {

    public ClientCodeNotFound(int code) {
        super("Cliente não encontrado para o seguinte código: " + code,
                "Client not found for following code: " + code,
                "Client code not found", "HUSM0018");
    }

}
