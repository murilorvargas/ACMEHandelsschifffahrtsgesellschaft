package modules.cargo.entities;

import modules.cargo.entities.interfaces.ICargoReadable;
import modules.cargo.enums.CargoPriority;
import modules.cargo.enums.CargoStatus;
import modules.cargoType.entities.interfaces.ICargoTypeReadable;
import modules.client.entities.interfaces.IClientReadable;
import modules.harbor.entities.interfaces.IHarborReadable;
import modules.ship.entities.interfaces.IShipReadable;

public class Cargo implements Comparable<Cargo>, ICargoReadable {
    private int id;
    private double weight;
    private double declaredValue;
    private int maxTime;
    private CargoPriority priority;
    private CargoStatus status;
    private ICargoTypeReadable cargoType;
    private IHarborReadable originHarbor;
    private IHarborReadable destinationHarbor;
    private IClientReadable client;
    private IShipReadable destinedShip;

    public Cargo(int id, double weight, double declaredValue, int maxTime, CargoPriority priority,
            ICargoTypeReadable cargoType,
            IHarborReadable originHarbor, IHarborReadable destinationHarbor, IClientReadable client) {
        this.id = id;
        this.weight = weight;
        this.declaredValue = declaredValue;
        this.maxTime = maxTime;
        this.priority = priority;
        this.status = CargoStatus.PENDING;
        this.cargoType = cargoType;
        this.originHarbor = originHarbor;
        this.destinationHarbor = destinationHarbor;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public double getDeclaredValue() {
        return declaredValue;
    }

    public int getMaxTime() {
        return maxTime;
    }

    public CargoPriority getPriority() {
        return priority;
    }

    public CargoStatus getStatus() {
        return status;
    }

    public ICargoTypeReadable getCargoType() {
        return cargoType;
    }

    public IHarborReadable getOriginHarbor() {
        return originHarbor;
    }

    public IHarborReadable getDestinationHarbor() {
        return destinationHarbor;
    }

    public IClientReadable getClient() {
        return client;
    }

    public IShipReadable getDestinedShip() {
        return destinedShip;
    }

    public void setDestinedShip(IShipReadable destinedShip) {
        this.destinedShip = destinedShip;
    }

    public void setStatus(CargoStatus status) {
        this.status = status;
    }

    @Override
    public int compareTo(Cargo other) {
        return this.id - other.id;
    }
}
