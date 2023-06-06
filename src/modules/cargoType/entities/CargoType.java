package modules.cargoType.entities;

import java.util.UUID;

public class CargoType {
    private String id;
    private String description;

    public CargoType(String description) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
