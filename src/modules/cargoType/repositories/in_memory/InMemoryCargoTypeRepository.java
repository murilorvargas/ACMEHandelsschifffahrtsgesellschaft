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
    public PerishableCargoType createPerishableCargoType(String number, String description, String origin,
            int maxValidityTime) {
        PerishableCargoType perishableCargoType = new PerishableCargoType(
                number,
                description, origin,
                maxValidityTime);

        this.cargoTypeList.add(perishableCargoType);

        return perishableCargoType;
    }

    @Override
    public DurableCargoType createDurableCargoType(String number, String description, String sector,
            String mainMaterial,
            double ipiPercentage) {
        DurableCargoType durableCargoType = new DurableCargoType(
                number,
                description, sector, mainMaterial,
                ipiPercentage);

        this.cargoTypeList.add(durableCargoType);

        return durableCargoType;
    }

    @Override
    public CargoType findById(String number) {
        for (CargoType cargoType : cargoTypeList) {
            if (cargoType.getNumber().equals(number)) {
                return cargoType;
            }
        }
        return null;
    }
}
