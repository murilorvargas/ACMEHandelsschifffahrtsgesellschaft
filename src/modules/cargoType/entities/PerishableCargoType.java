package modules.cargoType.entities;

import modules.cargoType.entities.interfaces.IPerishableCargoTypeReadable;

public class PerishableCargoType extends CargoType implements IPerishableCargoTypeReadable {
    private String origin;
    private int maxValidityTime;

    public PerishableCargoType(int number, String description, String origin, int maxValidityTime) {
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
