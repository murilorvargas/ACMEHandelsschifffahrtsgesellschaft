package modules.cargoType.dtos;

public class CreateDurableCargoTypeDTO {
    private String number;
    private String description;
    private String sector;
    private String mainMaterial;
    private double ipiPercentage;

    public CreateDurableCargoTypeDTO(String number, String description, String sector, String mainMaterial,
            double ipiPercentage) {
        this.number = number;
        this.description = description;
        this.sector = sector;
        this.mainMaterial = mainMaterial;
        this.ipiPercentage = ipiPercentage;

    }

    public String getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public String getSector() {
        return sector;
    }

    public String getMainMaterial() {
        return mainMaterial;
    }

    public double getIpiPercentage() {
        return ipiPercentage;
    }
}
