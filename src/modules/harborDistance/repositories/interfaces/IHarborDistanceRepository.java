package modules.harborDistance.repositories.interfaces;

import modules.harborDistance.entities.interfaces.IHarborDistanceReadable;

import java.util.List;

import modules.harbor.entities.interfaces.IHarborReadable;

public interface IHarborDistanceRepository {
    IHarborDistanceReadable create(double value, IHarborReadable firstHarbor, IHarborReadable secondHarbor);

    IHarborDistanceReadable update(String id, double value);

    IHarborDistanceReadable findByHarbors(int firstHarborId, int secondHarborId);

    List<IHarborDistanceReadable> findAll();
}
