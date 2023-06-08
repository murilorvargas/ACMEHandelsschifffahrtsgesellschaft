package shared.errors;

public class NoShipRegistered extends BaseRunTimeException {

    public NoShipRegistered() {
        super("Nenhum navio cadastrado, realize a criação de algum navio",
                "No ship registered, create some ship",
                "No ship registered", "HUSM0008");
    }

}
