package modules.cargoType.dtos;

import javax.validation.constraints.NotBlank;

public class CreatePerishableCargoTypeDTO {
    private String description;

    @NotBlank(message = "The origin cannot be blank")
    private String origin;

    @NotBlank(message = "The max validity time cannot be blank")
    private int maxValidityTime;

    public CreatePerishableCargoTypeDTO(String description, String origin,
            int maxValidityTime) {
        this.description = description;
        this.origin = origin;
        this.maxValidityTime = maxValidityTime;
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
