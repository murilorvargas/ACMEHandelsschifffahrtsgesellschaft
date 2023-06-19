package modules.cargo.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import modules.cargo.enums.CargoStatus;

public class UpdateCargoStatusDTO {
    @PositiveOrZero(message = "The id must be a positive value.")
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
