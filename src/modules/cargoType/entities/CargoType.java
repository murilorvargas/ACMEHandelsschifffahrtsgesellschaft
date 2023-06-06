package modules.cargoType.entities;

public class CargoType implements Comparable<CargoType> {
    private String id;
    private String description;

    public CargoType(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(CargoType other) {
        return this.id.compareTo(other.id);
    }
}
