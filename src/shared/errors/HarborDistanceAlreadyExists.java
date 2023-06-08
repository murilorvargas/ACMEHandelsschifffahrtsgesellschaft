package shared.errors;

public class HarborDistanceAlreadyExists extends BaseRunTimeException {
    public HarborDistanceAlreadyExists(String firstId, String secondId) {
        super("Distância entre os portos já existe com os ids " + firstId + " " + secondId + " já existe",
                "Distance between ports with ids " + firstId + " " + secondId + " already exists",
                "Harbor distance already exists", "HUSM0013");
    }
}
