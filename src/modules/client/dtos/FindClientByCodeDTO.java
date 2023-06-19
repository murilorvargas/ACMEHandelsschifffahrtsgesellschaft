package modules.client.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class FindClientByCodeDTO {

    @NotBlank(message = "The code cannot be blank.")
    @PositiveOrZero(message = "The code must be a positive value.")
    private int code;

    public FindClientByCodeDTO(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
