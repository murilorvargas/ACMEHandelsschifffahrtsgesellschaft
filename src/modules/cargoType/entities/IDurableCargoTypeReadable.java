package modules.cargoType.entities;

public interface IDurableCargoTypeReadable extends ICargoTypeReadable {
    String getSector();

    public String getMainMaterial();

    public double getIpiPercentage();
}