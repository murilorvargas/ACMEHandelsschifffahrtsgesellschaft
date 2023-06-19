package modules.client.dtos;

import javax.validation.constraints.PositiveOrZero;

public class FindClientByCodeDTO {

    @PositiveOrZero(message = "The code must be a positive value.")
    private int code;

    public FindClientByCodeDTO(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
