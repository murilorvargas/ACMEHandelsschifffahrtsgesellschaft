package modules.cargoType.repositories;

import modules.cargoType.entities.ICargoTypeReadable;
import modules.cargoType.entities.IDurableCargoTypeReadable;
import modules.cargoType.entities.IPerishableCargoTypeReadable;

public interface ICargoTypeRepository {
        IPerishableCargoTypeReadable createPerishableCargoType(String number, String description, String origin,
                        int maxValidityTime);

        IDurableCargoTypeReadable createDurableCargoType(String number, String description, String sector,
                        String mainMaterial,
                        double ipiPercentage);

        ICargoTypeReadable findById(String id);
}
