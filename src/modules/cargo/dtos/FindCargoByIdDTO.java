package modules.cargo.dtos;

import javax.validation.constraints.NotBlank;

public class FindCargoByIdDTO {
    @NotBlank(message = "The id cannot be blank.")
    private int id;

    public FindCargoByIdDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
