
package shared.errors;

public class HarborDistanceNotFound extends BaseRunTimeException {

    public HarborDistanceNotFound(String firstHarborId, String secondHarborId) {
        super("Distancia para os portos " + firstHarborId + "e" + secondHarborId + "não encontrada",
                "Harbor distance for harbors " + firstHarborId + "e" + secondHarborId + "not found",
                "Harbor distance not found", "HUSM0026");
    }
}