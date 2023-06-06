package modules.cargo.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class CreateCargoDTO {
    @NotBlank(message = "The id cannot be blank.")
    private String id;

    @NotBlank(message = "The weight cannot be blank.")
    @Positive(message = "The weight must be a positive value.")
    private double weight;

    @NotBlank(message = "The declared value cannot be blank.")
    @Positive(message = "The declared value must be a positive value.")
    private double declaredValue;

    @NotBlank(message = "The max time cannot be blank.")
    @Positive(message = "The max time must be a positive value.")
    private int maxTime;

    @NotBlank(message = "The cargo type id cannot be blank.")
    private String cargoTypeId;

    public CreateCargoDTO(String id, double weight, double declaredValue, int maxTime, String cargoTypeId) {
        this.id = id;
        this.weight = weight;
        this.declaredValue = declaredValue;
        this.maxTime = maxTime;
        this.cargoTypeId = cargoTypeId;
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

    public String getCargoTypeId() {
        return cargoTypeId;
    }
}
