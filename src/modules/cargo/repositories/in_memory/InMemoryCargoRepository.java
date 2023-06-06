package modules.cargo.repositories.in_memory;

import java.util.ArrayList;

import modules.cargo.entities.Cargo;
import modules.cargo.repositories.ICargoRepository;
import modules.cargoType.entities.CargoType;

public class InMemoryCargoRepository implements ICargoRepository {
    private ArrayList<Cargo> cargoList;
    private static InMemoryCargoRepository instance = null;

    public static synchronized InMemoryCargoRepository instanceOf() {
        if (instance == null) {
            instance = new InMemoryCargoRepository();
        }
        return instance;
    }

    private InMemoryCargoRepository() {
        this.cargoList = new ArrayList<Cargo>();
    }

    @Override
    public void create(String id, double weight, double declaredValue, int maxTime, CargoType cargoType) {

        Cargo cargo = new Cargo(id, weight, declaredValue,
                maxTime, cargoType);
        this.cargoList.add(cargo);
    }
}
