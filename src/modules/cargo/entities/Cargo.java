package modules.cargo.entities;

import modules.cargo.enums.CargoStatus;
import modules.cargoType.entities.CargoType;

public class Cargo implements Comparable<Cargo> {
    private String id;
    private double weight;
    private double declaredValue;
    private int maxTime;
    private CargoStatus status;
    private CargoType cargoType;

    public Cargo(String id, double weight, double declaredValue, int maxTime, CargoType cargoType) {
        this.id = id;
        this.weight = weight;
        this.declaredValue = declaredValue;
        this.maxTime = maxTime;
        this.status = CargoStatus.PENDING;
        this.cargoType = cargoType;
    }

    public String getId() {
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

    public CargoType getCargoType() {
        return cargoType;
    }

    @Override
    public int compareTo(Cargo other) {
        return this.id.compareTo(other.id);
    }
}
