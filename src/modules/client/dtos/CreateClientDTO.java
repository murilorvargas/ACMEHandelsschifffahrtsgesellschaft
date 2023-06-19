package modules.client.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class CreateClientDTO {

    @PositiveOrZero(message = "The name must be a positive value.")
    private int code;

    @NotBlank(message = "The name cannot be blank.")
    private String name;

    @NotBlank(message = "The name cannot be blank.")
    private String email;

    public CreateClientDTO(int code, String name, String email) {
        this.code = code;
        this.name = name;
        this.email = email;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}