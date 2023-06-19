package modules.harborDistance.dtos;

import javax.validation.constraints.PositiveOrZero;

public class CreateHarborDistanceDTO {
    @PositiveOrZero(message = "Value must be a positive number or zero")
    private double value;

    @PositiveOrZero(message = "First harbor ID must be a positive number or zero")
    private int firstHarborId;

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
