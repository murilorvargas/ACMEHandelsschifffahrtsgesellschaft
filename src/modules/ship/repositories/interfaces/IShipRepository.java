package modules.ship.repositories.interfaces;

import java.util.List;
import modules.ship.entities.interfaces.IShipReadable;

public interface IShipRepository {
    IShipReadable create(String name, double speed, double autonomy, double costPerMile);

    IShipReadable updateAvailability(String id, boolean isAvailable);

    List<IShipReadable> findAll();

    IShipReadable findByName(String name);
}
