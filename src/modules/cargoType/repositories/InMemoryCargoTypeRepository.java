package modules.cargoType.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import modules.cargoType.entities.CargoType;
import modules.cargoType.entities.DurableCargoType;
import modules.cargoType.entities.PerishableCargoType;
import modules.cargoType.entities.interfaces.ICargoTypeReadable;
import modules.cargoType.entities.interfaces.IDurableCargoTypeReadable;
import modules.cargoType.entities.interfaces.IPerishableCargoTypeReadable;
import modules.cargoType.repositories.interfaces.ICargoTypeRepository;

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
    public IPerishableCargoTypeReadable createPerishableCargoType(int number, String description, String origin,
            int maxValidityTime) {
        PerishableCargoType perishableCargoType = new PerishableCargoType(
                number,
                description, origin,
                maxValidityTime);

        this.cargoTypeList.add(perishableCargoType);

        return perishableCargoType;
    }

    @Override
    public IDurableCargoTypeReadable createDurableCargoType(int number, String description, String sector,
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
    public ICargoTypeReadable findByNumber(int number) {
        for (CargoType cargoType : cargoTypeList) {
            if (cargoType.getNumber() == number) {
                return cargoType;
            }
        }
        return null;
    }

    @Override
    public List<ICargoTypeReadable> findAll() {
        List<ICargoTypeReadable> cargoTypes = new ArrayList<>();

        for (CargoType cargoType : cargoTypeList) {
            cargoTypeList.add(cargoType);
        }

        return cargoTypes;
    }
}
