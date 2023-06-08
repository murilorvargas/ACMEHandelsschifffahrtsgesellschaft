package modules.harbor.dtos;

import javax.validation.constraints.NotBlank;

public class FindHarborByIdDTO {
    @NotBlank(message = "The id cannot be blank.")
    private int id;

    public FindHarborByIdDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
