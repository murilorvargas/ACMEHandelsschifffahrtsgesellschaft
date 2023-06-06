package modules.cargoType.entities.interfaces;

public interface IDurableCargoTypeReadable extends ICargoTypeReadable {
    String getSector();

    public String getMainMaterial();

    public double getIpiPercentage();
}