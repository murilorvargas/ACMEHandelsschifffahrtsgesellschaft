package modules.harborDistance.entities;

import java.util.UUID;

import modules.harbor.entities.interfaces.IHarborReadable;
import modules.harborDistance.entities.interfaces.IHarborDistanceReadable;

public class HarborDistance implements IHarborDistanceReadable {
    private String id;
    private IHarborReadable firstHarbor;
    private IHarborReadable secondHarbor;
    private double value;

    public HarborDistance(double value, IHarborReadable firstHarbor, IHarborReadable secondHarbor) {
        this.id = UUID.randomUUID().toString();
        this.value = value;
        this.firstHarbor = firstHarbor;
        this.secondHarbor = secondHarbor;
    }

    public String getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public IHarborReadable getFirstHarbor() {
        return firstHarbor;
    }

    public IHarborReadable getSecondHarbor() {
        return secondHarbor;
    }
}
