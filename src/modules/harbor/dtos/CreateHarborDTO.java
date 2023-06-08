package modules.harbor.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class CreateHarborDTO {
    @NotBlank(message = "The id cannot be blank")
    @PositiveOrZero(message = "The id must be a positive value")
    private int id;

    @NotBlank(message = "The name cannot be blank")
    private String name;

    @NotBlank(message = "The country cannot be blank")
    private String country;

    public CreateHarborDTO(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
