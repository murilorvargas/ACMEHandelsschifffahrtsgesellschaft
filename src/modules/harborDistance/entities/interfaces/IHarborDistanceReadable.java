package modules.harborDistance.entities.interfaces;

import modules.harbor.entities.interfaces.IHarborReadable;

public interface IHarborDistanceReadable {
    String getId();

    IHarborReadable getFirstHarbor();

    IHarborReadable getSecondHarbor();

    double getValue();
}
