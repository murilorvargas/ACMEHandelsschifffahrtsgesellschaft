package modules.cargo.dtos;

import java.util.UUID;

public class CreateCargoDTO {
    private double weight;
    private double declaredValue;
    private int maxTime;
    private UUID cargoTypeId;

    public CreateCargoDTO(double weight, double declaredValue, int maxTime, UUID cargoTypeId) {
        this.weight = weight;
        this.declaredValue = declaredValue;
        this.maxTime = maxTime;
        this.cargoTypeId = cargoTypeId;
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

    public UUID getCargoTypeId() {
        return cargoTypeId;
    }
}
