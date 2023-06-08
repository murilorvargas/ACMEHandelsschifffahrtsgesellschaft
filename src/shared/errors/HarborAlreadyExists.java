package shared.errors;

public class HarborAlreadyExists extends BaseRunTimeException {
    public HarborAlreadyExists(String id) {
        super("Porto já existe com o id " + id + " já existe",
                "Harbor with id " + id + " already exists",
                "Harbor already exists", "HUSM0007");
    }
}
