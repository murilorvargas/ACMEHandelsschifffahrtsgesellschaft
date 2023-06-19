package modules.harborDistance.dtos;

import javax.validation.constraints.PositiveOrZero;

public class CreateDefaultHarborDistanceToAllHarborsDTO {
    @PositiveOrZero(message = "Harbor ID must be a positive number or zero")
    private int harborId;

    public CreateDefaultHarborDistanceToAllHarborsDTO(int harborId) {
        this.harborId = harborId;
    }

    public int getHarborId() {
        return harborId;
    }
}
