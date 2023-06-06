package modules.cargoType.repositories;

import modules.cargoType.entities.ICargoTypeReadable;
import modules.cargoType.entities.IDurableCargoTypeReadable;
import modules.cargoType.entities.IPerishableCargoTypeReadable;

public interface ICargoTypeRepository {
        IPerishableCargoTypeReadable createPerishableCargoType(int number, String description, String origin,
                        int maxValidityTime);

        IDurableCargoTypeReadable createDurableCargoType(int number, String description, String sector,
                        String mainMaterial,
                        double ipiPercentage);

        ICargoTypeReadable findByNumber(int number);
}
