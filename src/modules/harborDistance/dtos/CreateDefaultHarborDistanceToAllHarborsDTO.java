package modules.harborDistance.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class CreateDefaultHarborDistanceToAllHarborsDTO {
    @NotBlank(message = "Harbor ID is required")
    @PositiveOrZero(message = "Harbor ID must be a positive number or zero")
    private int harborId;

    public CreateDefaultHarborDistanceToAllHarborsDTO(int harborId) {
        this.harborId = harborId;
    }

    public int getHarborId() {
        return harborId;
    }
}
