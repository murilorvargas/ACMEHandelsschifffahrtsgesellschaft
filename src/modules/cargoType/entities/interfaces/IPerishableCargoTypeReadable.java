package modules.cargoType.entities.interfaces;

public interface IPerishableCargoTypeReadable extends ICargoTypeReadable {
    String getOrigin();

    int getMaxValidityTime();
}
