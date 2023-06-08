package modules.ship.repositories.interfaces;

import java.util.List;
import java.util.TreeSet;
import modules.ship.entities.interfaces.IShipReadable;

public interface IShipRepository {
    IShipReadable create(String name, double speed, double autonomy, double costPerMile);

    List<IShipReadable> findAll();

    IShipReadable findByName(String name);
}
