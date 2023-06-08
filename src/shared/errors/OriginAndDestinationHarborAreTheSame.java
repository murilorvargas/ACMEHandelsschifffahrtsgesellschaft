package shared.errors;

public class OriginAndDestinationHarborAreTheSame extends BaseRunTimeException {

    public OriginAndDestinationHarborAreTheSame() {
        super("Porto de origem e de destino enviados são os mesmos",
                "Origin and destination port sent are the same",
                "Origin and destination harbor are the same", "HUSM0012");
    }
}
