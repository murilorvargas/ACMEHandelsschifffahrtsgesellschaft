package modules.cargo.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import modules.cargo.enums.CargoStatus;

public class UpdateCargoStatusDTO {
    @NotBlank(message = "The id cannot be blank.")
    private int id;

    @NotNull(message = "The cargo status cannot be null.")
    private CargoStatus cargoStatus;

    public UpdateCargoStatusDTO(int id, CargoStatus cargoStatus) {
        this.id = id;
        this.cargoStatus = cargoStatus;
    }

    public int getId() {
        return this.id;
    }

    public CargoStatus getCargoStatus() {
        return this.cargoStatus;
    }
}
