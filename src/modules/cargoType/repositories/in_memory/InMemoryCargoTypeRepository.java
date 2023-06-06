package modules.cargoType.repositories.in_memory;

import java.util.TreeSet;

import modules.cargoType.entities.CargoType;
import modules.cargoType.entities.DurableCargoType;
import modules.cargoType.entities.PerishableCargoType;
import modules.cargoType.repositories.ICargoTypeRepository;

public class InMemoryCargoTypeRepository implements ICargoTypeRepository {
    private TreeSet<CargoType> cargoTypeList;
    private static InMemoryCargoTypeRepository instance = null;

    public static synchronized InMemoryCargoTypeRepository instanceOf() {
        if (instance == null) {
            instance = new InMemoryCargoTypeRepository();
        }
        return instance;
    }

    private InMemoryCargoTypeRepository() {
        this.cargoTypeList = new TreeSet<CargoType>();
    }

    @Override
    public void createPerishableCargoType(String id, String description, String origin,
            int maxValidityTime) {
        PerishableCargoType perishableCargoType = new PerishableCargoType(
                id,
                description, origin,
                maxValidityTime);

        this.cargoTypeList.add(perishableCargoType);
    }

    @Override
    public void createDurableCargoType(String id, String description, String sector, String mainMaterial,
            double ipiPercentage) {
        DurableCargoType durableCargoType = new DurableCargoType(
                id,
                description, sector, mainMaterial,
                ipiPercentage);

        this.cargoTypeList.add(durableCargoType);
    }

    @Override
    public CargoType findById(String id) {
        for (CargoType cargoType : cargoTypeList) {
            if (cargoType.getId().equals(id)) {
                return cargoType;
            }
        }
        return null;
    }
}
