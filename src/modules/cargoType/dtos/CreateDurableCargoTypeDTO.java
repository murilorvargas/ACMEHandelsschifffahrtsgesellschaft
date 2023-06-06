package modules.cargoType.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class CreateDurableCargoTypeDTO {
    private String description;

    @NotBlank(message = "The sector cannot be blank")
    private String sector;

    @NotBlank(message = "The main material cannot be blank")
    private String mainMaterial;

    @Positive(message = "The IPI percentage must be a positive value")
    private double ipiPercentage;

    public CreateDurableCargoTypeDTO(String description, String sector, String mainMaterial,
            double ipiPercentage) {
        this.description = description;
        this.sector = sector;
        this.mainMaterial = mainMaterial;
        this.ipiPercentage = ipiPercentage;

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
