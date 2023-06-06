package modules.cargo.dtos;

import javax.validation.constraints.NotBlank;

public class FindCargoByIdDTO {
    @NotBlank(message = "The id cannot be blank.")
    private String id;

    public FindCargoByIdDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
