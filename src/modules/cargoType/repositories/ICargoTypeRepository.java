package modules.cargoType.repositories;

import modules.cargoType.entities.CargoType;

public interface ICargoTypeRepository {
        void createPerishableCargoType(String id, String description, String origin,
                        int maxValidityTime);

        void createDurableCargoType(String id, String description, String sector, String mainMaterial,
                        double ipiPercentage);

        CargoType findById(String id);
}
