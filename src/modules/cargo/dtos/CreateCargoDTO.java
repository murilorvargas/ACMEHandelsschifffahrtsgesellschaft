package modules.cargo.dtos;

public class CreateCargoDTO {
    private double weight;
    private double declaredValue;
    private int maxTime;
    private String cargoTypeId;

    public CreateCargoDTO(double weight, double declaredValue, int maxTime, String cargoTypeId) {
        this.weight = weight;
        this.declaredValue = declaredValue;
        this.maxTime = maxTime;
        this.cargoTypeId = cargoTypeId;
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

    public String getCargoTypeId() {
        return cargoTypeId;
    }
}
