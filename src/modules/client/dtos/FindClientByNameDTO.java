package modules.client.dtos;

import javax.validation.constraints.NotBlank;

public class FindClientByNameDTO {

    @NotBlank(message = "The name cannot be blank.")
    private String name;

    public FindClientByNameDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
