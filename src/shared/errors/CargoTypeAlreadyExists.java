package shared.errors;

public class CargoTypeAlreadyExists extends BaseRunTimeException {
    public CargoTypeAlreadyExists(String id) {
        super("Tipo de carga já existe com o id " + id + " já existe", "Cargo type with id " + id + " already exists",
                "Cargo type already exists", "HUSM0003");
    }
}
