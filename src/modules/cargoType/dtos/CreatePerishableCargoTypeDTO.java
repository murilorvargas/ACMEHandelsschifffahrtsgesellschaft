package modules.cargoType.dtos;

import javax.validation.constraints.NotBlank;

public class CreatePerishableCargoTypeDTO {
    @NotBlank(message = "The id cannot be blank.")
    private String id;

    private String description;

    @NotBlank(message = "The origin cannot be.")
    private String origin;

    @NotBlank(message = "The max validity time cannot be blank.")
    private int maxValidityTime;

    public CreatePerishableCargoTypeDTO(String id, String description, String origin,
            int maxValidityTime) {
        this.id = id;
        this.description = description;
        this.origin = origin;
        this.maxValidityTime = maxValidityTime;
    }

    public String getId() {
        return id;
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
