package modules.cargo.repositories.in_memory;

import java.util.Comparator;
import java.util.TreeSet;

import modules.cargo.entities.Cargo;
import modules.cargo.entities.ICargoReadable;
import modules.cargo.enums.CargoStatus;
import modules.cargo.repositories.ICargoRepository;
import modules.cargoType.entities.ICargoTypeReadable;

public class InMemoryCargoRepository implements ICargoRepository {
    private TreeSet<Cargo> cargoList;
    private static InMemoryCargoRepository instance = null;

    public static synchronized InMemoryCargoRepository instanceOf() {
        if (instance == null) {
            instance = new InMemoryCargoRepository();
        }
        return instance;
    }

    private InMemoryCargoRepository() {
        this.cargoList = new TreeSet<Cargo>();
    }

    @Override
    public ICargoReadable create(int id, double weight, double declaredValue, int maxTime,
            ICargoTypeReadable cargoType) {
        Cargo cargo = new Cargo(id, weight, declaredValue,
                maxTime, cargoType);
        this.cargoList.add(cargo);

        return cargo;
    }

    @Override
    public ICargoReadable updateStatus(int id, CargoStatus cargoStatus) {
        for (Cargo cargo : this.cargoList) {
            if (cargo.getId() == id) {
                cargo.setStatus(cargoStatus);
                return cargo;
            }
        }

        return null;
    }

    @Override
    public TreeSet<ICargoReadable> findAll() {
        TreeSet<ICargoReadable> cargoSet = new TreeSet<>(Comparator.comparing(ICargoReadable::getId));
        for (Cargo cargo : this.cargoList) {
            cargoSet.add(cargo);
        }
        return cargoSet;
    }

    @Override
    public ICargoReadable findById(int id) {
        for (Cargo cargo : this.cargoList) {
            if (cargo.getId() == id) {
                return cargo;
            }
        }

        return null;
    }
}
