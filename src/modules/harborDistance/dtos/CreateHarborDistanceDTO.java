package modules.harborDistance.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class CreateHarborDistanceDTO {
    @NotBlank(message = "Value is required")
    @PositiveOrZero(message = "Value must be a positive number or zero")
    private double value;

    @NotBlank(message = "First harbor ID is required")
    @PositiveOrZero(message = "First harbor ID must be a positive number or zero")
    private int firstHarborId;

    @NotBlank(message = "Second harbor ID is required")
    @PositiveOrZero(message = "Second harbor ID must be a positive number or zero")
    private int secondHarborId;

    public CreateHarborDistanceDTO(double value, int firstHarborId, int secondHarborId) {
        this.value = value;
        this.firstHarborId = firstHarborId;
        this.secondHarborId = secondHarborId;
    }

    public double getValue() {
        return value;
    }

    public int getFirstHarborId() {
        return firstHarborId;
    }

    public int getSecondHarborId() {
        return secondHarborId;
    }
}
