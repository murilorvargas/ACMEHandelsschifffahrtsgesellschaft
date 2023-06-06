package modules.cargo.entities;

import modules.cargo.enums.CargoStatus;
import modules.cargoType.entities.ICargoTypeReadable;

public interface ICargoReadable {
    int getId();

    double getWeight();

    double getDeclaredValue();

    int getMaxTime();

    CargoStatus getStatus();

    ICargoTypeReadable getCargoType();
}
