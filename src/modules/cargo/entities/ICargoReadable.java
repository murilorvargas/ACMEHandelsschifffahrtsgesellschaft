package modules.cargo.entities;

import modules.cargo.enums.CargoStatus;
import modules.cargoType.entities.CargoType;

public interface ICargoReadable {
    String getId();

    double getWeight();

    double getDeclaredValue();

    int getMaxTime();

    CargoStatus getStatus();

    CargoType getCargoType();
}
