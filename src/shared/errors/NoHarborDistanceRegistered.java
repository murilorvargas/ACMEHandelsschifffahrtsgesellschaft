package shared.errors;

public class NoHarborDistanceRegistered extends BaseRunTimeException {

    public NoHarborDistanceRegistered() {
        super("Nenhuma distância entre portos cadastrada, realize a criação de alguma distância entre portos",
                "No harbor distance registered, create some harbor distance", "No harbor distance registered",
                "HUSM0030");
    }
}
