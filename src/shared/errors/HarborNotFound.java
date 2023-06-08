package shared.errors;

public class HarborNotFound extends BaseRunTimeException {

    public HarborNotFound(String harborId) {
        super("Porto não encontrado para o seguinte id: " + harborId,
                "Harbor not found for following id: " + harborId,
                "Harbor not found", "HUSM0009");
    }
}