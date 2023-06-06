package modules.cargoType.entities;

import java.util.UUID;

public class CargoType {
    private String id;
    private String number;
    private String description;

    public CargoType(String number, String description) {
        this.id = UUID.randomUUID().toString();
        this.number = number;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }
}
