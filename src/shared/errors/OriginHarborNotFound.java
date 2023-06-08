package shared.errors;

public class OriginHarborNotFound extends BaseRunTimeException {

    public OriginHarborNotFound(String originHarborId) {
        super("Porto de origem não encontrado para o seguinte id: " + originHarborId,
                "Origin harbor not found for following id: " + originHarborId,
                "Origin harbor not found", "HUSM0010");
    }
}
