package modules.cargo.entities.interfaces;

import modules.cargo.enums.CargoStatus;
import modules.cargoType.entities.interfaces.ICargoTypeReadable;

public interface ICargoReadable {
    int getId();

    double getWeight();

    double getDeclaredValue();

    int getMaxTime();

    CargoStatus getStatus();

    ICargoTypeReadable getCargoType();
}
