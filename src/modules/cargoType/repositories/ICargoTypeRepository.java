package modules.cargoType.repositories;

import modules.cargoType.entities.CargoType;
import modules.cargoType.entities.DurableCargoType;
import modules.cargoType.entities.PerishableCargoType;

public interface ICargoTypeRepository {
        PerishableCargoType createPerishableCargoType(String number, String description, String origin,
                        int maxValidityTime);

        DurableCargoType createDurableCargoType(String number, String description, String sector, String mainMaterial,
                        double ipiPercentage);

        CargoType findById(String id);
}
