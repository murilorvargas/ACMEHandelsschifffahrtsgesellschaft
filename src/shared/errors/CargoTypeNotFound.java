package shared.errors;

public class CargoTypeNotFound extends BaseRunTimeException {

        public CargoTypeNotFound(String cargoTypeId) {
                super("Tipo de carga não encontrado para o seguinde id: " + cargoTypeId,
                                "Cargo type not found for following id: " + cargoTypeId,
                                "Cargo type not found", "HUSM0002");
        }
}