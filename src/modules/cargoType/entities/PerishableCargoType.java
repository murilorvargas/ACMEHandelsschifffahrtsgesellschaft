package modules.cargoType.entities;

public class PerishableCargoType extends CargoType implements IPerishableCargoTypeReadable {
    private String origin;
    private int maxValidityTime;

    public PerishableCargoType(String number, String description, String origin, int maxValidityTime) {
        super(number, description);
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
