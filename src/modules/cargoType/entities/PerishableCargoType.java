package modules.cargoType.entities;

public class PerishableCargoType extends CargoType {
    private String origin;
    private int maxValidityTime;

    public PerishableCargoType(String id, String description, String origin, int maxValidityTime) {
        super(id, description);
        this.origin = origin;
        this.maxValidityTime = maxValidityTime;
    }

    public String getOrigin() {
        return origin;
    }

    public int getMaxValidityTime() {
        return maxValidityTime;
    }
}
