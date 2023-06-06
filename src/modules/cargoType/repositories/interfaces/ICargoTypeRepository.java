package modules.cargoType.repositories.interfaces;

import modules.cargoType.entities.interfaces.ICargoTypeReadable;
import modules.cargoType.entities.interfaces.IDurableCargoTypeReadable;
import modules.cargoType.entities.interfaces.IPerishableCargoTypeReadable;

public interface ICargoTypeRepository {
        IPerishableCargoTypeReadable createPerishableCargoType(int number, String description, String origin,
                        int maxValidityTime);

        IDurableCargoTypeReadable createDurableCargoType(int number, String description, String sector,
                        String mainMaterial,
                        double ipiPercentage);

        ICargoTypeReadable findByNumber(int number);
}
