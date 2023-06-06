package modules.cargoType.dtos;

public class CreatePerishableCargoTypeDTO {
    private String description;
    private String origin;
    private int maxValidityTime;

    public CreatePerishableCargoTypeDTO(String description, String origin,
            int maxValidityTime) {
        this.description = description;
        this.origin = origin;
        this.maxValidityTime = maxValidityTime;
    }

    public String getDescription() {
        return description;
    }

    public String getOrigin() {
        return origin;
    }

    public int getMaxValidityTime() {
        return maxValidityTime;
    }
}
