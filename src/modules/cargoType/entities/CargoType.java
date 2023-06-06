package modules.cargoType.entities;

import modules.cargoType.entities.interfaces.ICargoTypeReadable;

public class CargoType implements Comparable<CargoType>, ICargoTypeReadable {
    private int number;
    private String description;

    public CargoType(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(CargoType other) {
        return this.number - other.number;
    }
}
