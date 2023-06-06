package modules.cargoType.repositories.in_memory;

import java.util.ArrayList;
import java.util.UUID;

import modules.cargoType.entities.CargoType;
import modules.cargoType.entities.DurableCargoType;
import modules.cargoType.entities.PerishableCargoType;
import modules.cargoType.repositories.ICargoTypeRepository;

public class InMemoryCargoTypeRepository implements ICargoTypeRepository {
    private ArrayList<CargoType> cargoTypeList;
    private static InMemoryCargoTypeRepository instance = null;

    public static synchronized InMemoryCargoTypeRepository instanceOf() {
        if (instance == null) {
            instance = new InMemoryCargoTypeRepository();
        }
        return instance;
    }

    private InMemoryCargoTypeRepository() {
        this.cargoTypeList = new ArrayList<CargoType>();
    }

    @Override
    public void createPerishableCargoType(String number, String description, String origin,
            int maxValidityTime) {
        PerishableCargoType perishableCargoType = new PerishableCargoType(number,
                description, origin,
                maxValidityTime);

        this.cargoTypeList.add(perishableCargoType);
    }

    @Override
    public void createDurableCargoType(String number, String description, String sector, String mainMaterial,
            double ipiPercentage) {
        DurableCargoType durableCargoType = new DurableCargoType(number,
                description, sector, mainMaterial,
                ipiPercentage);

        this.cargoTypeList.add(durableCargoType);
    }

    @Override
    public CargoType findById(UUID id) {
        for (CargoType cargoType : cargoTypeList) {
            if (cargoType.getId().equals(id)) {
                return cargoType;
            }
        }
        return null;
    }
}
