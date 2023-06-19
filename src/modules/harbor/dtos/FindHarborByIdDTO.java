package modules.harbor.dtos;

import javax.validation.constraints.PositiveOrZero;

public class FindHarborByIdDTO {
    @PositiveOrZero(message = "The id must be a positive value.")
    private int id;

    public FindHarborByIdDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
