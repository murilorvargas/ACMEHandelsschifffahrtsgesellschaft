package modules.cargo.entities;

import modules.cargo.entities.interfaces.ICargoReadable;
import modules.cargo.enums.CargoStatus;
import modules.cargoType.entities.interfaces.ICargoTypeReadable;

public class Cargo implements Comparable<Cargo>, ICargoReadable {
    private int id;
    private double weight;
    private double declaredValue;
    private int maxTime;
    private CargoStatus status;
    private ICargoTypeReadable cargoType;

    public Cargo(int id, double weight, double declaredValue, int maxTime, ICargoTypeReadable cargoType) {
        this.id = id;
        this.weight = weight;
        this.declaredValue = declaredValue;
        this.maxTime = maxTime;
        this.status = CargoStatus.PENDING;
        this.cargoType = cargoType;
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

    public CargoStatus getStatus() {
        return status;
    }

    public ICargoTypeReadable getCargoType() {
        return cargoType;
    }

    public void setStatus(CargoStatus status) {
        this.status = status;
    }

    @Override
    public int compareTo(Cargo other) {
        return this.id - other.id;
    }
}
