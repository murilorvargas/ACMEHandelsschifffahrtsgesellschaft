package shared.errors;

public class CargoQueueIsEmpty extends BaseRunTimeException {
    public CargoQueueIsEmpty() {
        super("A fila de cargas está vazia, adicione nova cargas",
                "Cargo queue is empty, add new cargos, add new cargos",
                "Cargo queue is empty", "HUSM00033");
    }

}
