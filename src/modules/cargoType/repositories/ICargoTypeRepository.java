package modules.cargoType.repositories;

import modules.cargoType.entities.CargoType;

public interface ICargoTypeRepository {
        void createPerishableCargoType(String number, String description, String origin,
                        int maxValidityTime);

        void createDurableCargoType(String number, String description, String sector, String mainMaterial,
                        double ipiPercentage);

        CargoType findById(String id);
}
