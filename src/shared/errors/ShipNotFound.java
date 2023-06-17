package shared.errors;

public class ShipNotFound extends BaseRunTimeException {

    public ShipNotFound(String shipName) {
        super("Barco não encontrado para o seguinte nome: " + shipName,
                "Ship not found for following name: " + shipName,
                "Ship not found", "HUSM0015");
    }

}
