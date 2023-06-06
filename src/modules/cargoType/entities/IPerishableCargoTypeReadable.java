package modules.cargoType.entities;

public interface IPerishableCargoTypeReadable extends ICargoTypeReadable {
    String getOrigin();

    int getMaxValidityTime();
}
