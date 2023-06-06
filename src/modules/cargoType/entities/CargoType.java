package modules.cargoType.entities;

public class CargoType implements Comparable<CargoType> {
    private String number;
    private String description;

    public CargoType(String number, String description) {
        this.number = number;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(CargoType other) {
        return this.number.compareTo(other.number);
    }
}
