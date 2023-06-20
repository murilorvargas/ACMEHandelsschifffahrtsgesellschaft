package modules.cargoType.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class CreatePerishableCargoTypeDTO {
    @PositiveOrZero(message = "The number must be a positive value.")
    private int number;

    private String description;

    @NotBlank(message = "The origin cannot be.")
    private String origin;

    @PositiveOrZero(message = "The max validity time must be a positive value.")
    private int maxValidityTime;

    public CreatePerishableCargoTypeDTO(int number, String description, String origin,
            int maxValidityTime) {
        this.number = number;
        this.description = description;
        this.origin = origin;
        this.maxValidityTime = maxValidityTime;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public String getOrigin() {
        return origin;
    }

    public int getMaxValidityTime() {
        return maxValidityTime;
    }
}
