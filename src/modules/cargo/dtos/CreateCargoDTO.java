package modules.cargo.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class CreateCargoDTO {
    @NotBlank(message = "The id cannot be blank.")
    private int id;

    @NotBlank(message = "The weight cannot be blank.")
    @PositiveOrZero(message = "The weight must be a positive value.")
    private double weight;

    @NotBlank(message = "The declared value cannot be blank.")
    @PositiveOrZero(message = "The declared value must be a positive value.")
    private double declaredValue;

    @NotBlank(message = "The max time cannot be blank.")
    @PositiveOrZero(message = "The max time must be a positive value.")
    private int maxTime;

    @NotBlank(message = "The cargo type number cannot be blank.")
    @PositiveOrZero(message = "The max time must be a positive value.")
    private int cargoTypeNumber;

    public CreateCargoDTO(int id, double weight, double declaredValue, int maxTime, int cargoTypeNumber) {
        this.id = id;
        this.weight = weight;
        this.declaredValue = declaredValue;
        this.maxTime = maxTime;
        this.cargoTypeNumber = cargoTypeNumber;
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

    public int getCargoTypeNumber() {
        return cargoTypeNumber;
    }
}
