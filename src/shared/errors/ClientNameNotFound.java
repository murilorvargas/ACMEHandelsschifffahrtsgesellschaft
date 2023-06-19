package shared.errors;

public class ClientNameNotFound extends BaseRunTimeException {

    public ClientNameNotFound(String name) {
        super("Cliente não encontrado para o seguinte nome: " + name,
                "Client not found for following name: " + name,
                "Client name not found", "HUSM0019");
    }

}
