package modules.client.dtos;

import javax.validation.constraints.NotBlank;

public class FindClientByEmailDTO {

    @NotBlank(message = "The email cannot be blank.")
    private String email;

    public FindClientByEmailDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}
