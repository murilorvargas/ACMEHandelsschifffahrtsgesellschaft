package modules.freight.dtos;

import javax.validation.constraints.PositiveOrZero;

public class FinishFreightDTO {
    @PositiveOrZero(message = "Id must be positive or zero")
    private int freightId;

    public FinishFreightDTO(int freightId) {
        this.freightId = freightId;
    }

    public int getFreightId() {
        return freightId;
    }
}
