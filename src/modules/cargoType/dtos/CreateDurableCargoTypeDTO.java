package modules.cargoType.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class CreateDurableCargoTypeDTO {
    @NotBlank(message = "The number cannot be blank.")
    @PositiveOrZero(message = "The number must be a positive value.")
    private int number;

    private String description;

    @NotBlank(message = "The sector cannot be blank.")
    private String sector;

    @NotBlank(message = "The main material cannot be blank.")
    private String mainMaterial;

    @PositiveOrZero(message = "The IPI percentage must be a positive value.")
    private double ipiPercentage;

    public CreateDurableCargoTypeDTO(int number, String description, String sector, String mainMaterial,
            double ipiPercentage) {
        this.number = number;
        this.description = description;
        this.sector = sector;
        this.mainMaterial = mainMaterial;
        this.ipiPercentage = ipiPercentage;

    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public String getSector() {
        return sector;
    }

    public String getMainMaterial() {
        return mainMaterial;
    }

    public double getIpiPercentage() {
        return ipiPercentage;
    }
}
