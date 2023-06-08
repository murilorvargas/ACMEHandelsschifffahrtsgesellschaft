package shared.errors;

public class CargoAlreadyExists extends BaseRunTimeException {
    public CargoAlreadyExists(String number) {
        super("Carga já existe com o id " + number + " já existe",
                "Cargo with id " + number + " already exists",
                "Cargo already exists", "HUSM0003");
    }
}
