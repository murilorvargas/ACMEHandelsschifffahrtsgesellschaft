package modules.ship.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class CreateShipDTO {
    @NotBlank(message = "The name cannot be blank.")
    private String name;

    @NotBlank(message = "The speed cannot be blank.")
    @PositiveOrZero(message = "The speed must be a positive value.")
    private double speed;

    @NotBlank(message = "The autonomy cannot be blank.")
    @PositiveOrZero(message = "The autonomy must be a positive value.")
    private double autonomy;

    @NotBlank(message = "The cost per mile cannot be blank.")
    @PositiveOrZero(message = "The cost per mile must be a positive value.")
    private double costPerMile;

    public CreateShipDTO(String name, double speed, double autonomy, double costPerMile) {
        this.name = name;
        this.speed = speed;
        this.autonomy = autonomy;
        this.costPerMile = costPerMile;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getAutonomy() {
        return autonomy;
    }

    public double getCostPerMile() {
        return costPerMile;
    }

}
