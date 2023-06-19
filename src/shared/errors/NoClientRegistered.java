package shared.errors;

public class NoClientRegistered extends BaseRunTimeException {

    public NoClientRegistered() {
        super("Nenhum cliente cadastrado, realize o cadastro de algum cliente",
                "None clients registered, register some client",
                "No client registered", "HUSM0017");
    }

}
