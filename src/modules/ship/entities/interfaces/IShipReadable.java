package modules.ship.entities.interfaces;

import java.util.UUID;

public interface IShipReadable {

    UUID getId();

    String getName();

    double getSpeed();

    double getAutonomy();

    double getCostPerMile();

}
