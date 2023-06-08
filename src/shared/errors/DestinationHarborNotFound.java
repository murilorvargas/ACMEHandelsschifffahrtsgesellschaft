package shared.errors;

public class DestinationHarborNotFound extends BaseRunTimeException {

    public DestinationHarborNotFound(String destinationHarborId) {
        super("Porto de destino não encontrado para o seguinte id: " + destinationHarborId,
                "Destination harbor not found for following id: " + destinationHarborId,
                "Destination harbor not found", "HUSM0011");
    }
}
