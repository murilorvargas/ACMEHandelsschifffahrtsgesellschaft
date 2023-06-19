package modules.cargo.dtos;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

public class CreateCargoDTO {
    @PositiveOrZero(message = "The id must be a positive value.")
    private int id;

    @PositiveOrZero(message = "The weight must be a positive value.")
    private double weight;

    @PositiveOrZero(message = "The declared value must be a positive value.")
    private double declaredValue;

    @PositiveOrZero(message = "The max time must be a positive value.")
    private int maxTime;

    @Pattern(regexp = "^(quick|cheap)$", message = "The cargo type must be 'quick' or 'cheap'.")
    private String priority;

    @PositiveOrZero(message = "The cargo type must be a positive value.")
    private int cargoTypeNumber;

    @PositiveOrZero(message = "The origin harbor id must be a positive value.")
    private int originHarborId;

    @PositiveOrZero(message = "The destination harbor id be a positive value.")
    private int destinationHarbor;

    @PositiveOrZero(message = "The destination harbor id be a positive value.")
    private int clientId;

    public CreateCargoDTO(int id, double weight, double declaredValue, int maxTime, String priority,
            int cargoTypeNumber,
            int originHarborId, int destinationHarbor, int clientId) {
        this.id = id;
        this.weight = weight;
        this.declaredValue = declaredValue;
        this.maxTime = maxTime;
        this.priority = priority;
        this.cargoTypeNumber = cargoTypeNumber;
        this.originHarborId = originHarborId;
        this.destinationHarbor = destinationHarbor;
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public double getDeclaredValue() {
        return declaredValue;
    }

    public int getMaxTime() {
        return maxTime;
    }

    public String getPriority() {
        return priority;
    }

    public int getCargoTypeNumber() {
        return cargoTypeNumber;
    }

    public int getOriginHarborId() {
        return originHarborId;
    }

    public int getDestinationHarborId() {
        return destinationHarbor;
    }

    public int getClientId() {
        return clientId;
    }
}
