package modules.ship.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import modules.ship.entities.Ship;
import modules.ship.entities.interfaces.IShipReadable;
import modules.ship.repositories.interfaces.IShipRepository;

public class InMemoryShipRepository implements IShipRepository {

    private TreeSet<Ship> shipList;
    private static InMemoryShipRepository instance = null;

    public static synchronized InMemoryShipRepository instanceOf() {
        if (instance == null) {
            instance = new InMemoryShipRepository();
        }
        return instance;
    }

    private InMemoryShipRepository() {
        this.shipList = new TreeSet<Ship>();
    }

    @Override
    public IShipReadable create(String name, double speed, double autonomy, double costPerMile) {
        Ship ship = new Ship(name, speed, autonomy, costPerMile);
        this.shipList.add(ship);

        return ship;
    }

    @Override
    public IShipReadable updateAvailability(String id, boolean isAvailable) {
        for (Ship ship : this.shipList) {
            if (ship.getId().equals(id)) {
                ship.setIsAvailable(isAvailable);
                return ship;
            }
        }
        return null;
    }

    @Override
    public List<IShipReadable> findAll() {
        List<IShipReadable> shipSet = new ArrayList<>();
        for (Ship ship : this.shipList) {
            shipSet.add(ship);
        }
        return shipSet;
    }

    @Override
    public IShipReadable findByName(String name) {
        for (Ship ship : this.shipList) {
            if (ship.getName().equals(name)) {
                return ship;
            }
        }
        return null;
    }

}
