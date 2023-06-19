package shared.errors;

public class FreightNotFound extends BaseRunTimeException{

    public FreightNotFound(String freightId) {
        super("Frete não encontrado para o seguinte id: " + freightId,
                "Freght not found for following id: " + freightId,
                "Freight not found", "HUSM0027");
    }
}