package modules.freight.entities.interfaces;

import modules.cargo.entities.interfaces.ICargoReadable;
import modules.freight.enums.FreightStatus;
import modules.ship.entities.interfaces.IShipReadable;

public interface IFreightReadable {
    int getId();

    double getValue();

    FreightStatus getStatus();

    IShipReadable getShip();

    ICargoReadable getCargo();
}