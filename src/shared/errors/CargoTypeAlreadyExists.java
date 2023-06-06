package shared.errors;

public class CargoTypeAlreadyExists extends BaseRunTimeException {
    public CargoTypeAlreadyExists(String number) {
        super("Tipo de carga já existe com o id " + number + " já existe",
                "Cargo type with id " + number + " already exists",
                "Cargo type already exists", "HUSM0003");
    }
}
