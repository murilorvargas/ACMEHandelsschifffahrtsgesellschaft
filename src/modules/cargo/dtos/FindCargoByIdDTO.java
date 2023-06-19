package modules.cargo.dtos;

import javax.validation.constraints.PositiveOrZero;

public class FindCargoByIdDTO {
    @PositiveOrZero(message = "The id must be a positive value.")
    private int id;

    public FindCargoByIdDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
