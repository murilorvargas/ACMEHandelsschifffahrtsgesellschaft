package modules.cargoType.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class CreatePerishableCargoTypeDTO {
    @NotBlank(message = "The number cannot be blank.")
    @PositiveOrZero(message = "The number must be a positive value.")
    private int number;

    private String description;

    @NotBlank(message = "The origin cannot be.")
    private String origin;

    @NotBlank(message = "The max validity time cannot be blank.")
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
