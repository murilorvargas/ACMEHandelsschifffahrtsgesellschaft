package modules.cargo.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import modules.cargo.enums.CargoStatus;

public class UpdateCargoStatusDTO {
    @NotBlank(message = "The id cannot be blank.")
    private String id;

    @NotNull(message = "The cargo status cannot be null.")
    private CargoStatus cargoStatus;

    public UpdateCargoStatusDTO(String id, CargoStatus cargoStatus) {
        this.id = id;
        this.cargoStatus = cargoStatus;
    }

    public String getId() {
        return this.id;
    }

    public CargoStatus getCargoStatus() {
        return this.cargoStatus;
    }
}
