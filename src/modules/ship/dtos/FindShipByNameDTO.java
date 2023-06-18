package modules.ship.dtos;

import javax.validation.constraints.NotBlank;

public class FindShipByNameDTO {

    @NotBlank(message = "The name cannot be blank.")
    private String name;

    public FindShipByNameDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
