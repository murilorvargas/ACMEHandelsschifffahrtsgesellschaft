package modules.freight.dtos;

import javax.validation.constraints.NotBlank;

public class FinishFreightDTO {
    @NotBlank(message = "The id cannot be blank")
    private String freightId;

    public FinishFreightDTO(String freightId) {
        this.freightId = freightId;
    }

    public String getFreightId() {
        return freightId;
    }
}
