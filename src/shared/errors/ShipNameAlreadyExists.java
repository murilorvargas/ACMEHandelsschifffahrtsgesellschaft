package shared.errors;

public class ShipNameAlreadyExists extends BaseRunTimeException {

    public ShipNameAlreadyExists(String shipName) {
        super("Nome do barco: " + shipName + "já encontrado",
                "Ship name: : " + shipName + "already registered",
                "Ship name already exists", "HUSM0007");
    }
}
