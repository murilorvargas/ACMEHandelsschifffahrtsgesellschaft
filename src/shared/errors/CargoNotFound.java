package shared.errors;

public class CargoNotFound extends BaseRunTimeException {

    public CargoNotFound(String cargoId) {
        super("Carga não encontrado para o seguinte id: " + cargoId,
                "Cargo not found for following id: " + cargoId,
                "Cargo not found", "HUSM0005");
    }
}