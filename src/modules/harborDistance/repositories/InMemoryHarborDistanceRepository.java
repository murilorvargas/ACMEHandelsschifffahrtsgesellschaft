package modules.harborDistance.repositories;

import java.util.ArrayList;
import java.util.List;

import modules.harborDistance.entities.HarborDistance;
import modules.harborDistance.entities.interfaces.IHarborDistanceReadable;
import modules.harborDistance.repositories.interfaces.IHarborDistanceRepository;
import modules.harbor.entities.interfaces.IHarborReadable;

public class InMemoryHarborDistanceRepository implements IHarborDistanceRepository {
    private ArrayList<HarborDistance> harborDistanceList;
    private static InMemoryHarborDistanceRepository instance = null;

    public static synchronized InMemoryHarborDistanceRepository instanceOf() {
        if (instance == null) {
            instance = new InMemoryHarborDistanceRepository();
        }
        return instance;
    }

    private InMemoryHarborDistanceRepository() {
        this.harborDistanceList = new ArrayList<>();
    }

    @Override
    public IHarborDistanceReadable create(double value, IHarborReadable firstHarbor, IHarborReadable secondHarbor) {
        HarborDistance harborDistance = new HarborDistance(value, firstHarbor, secondHarbor);
        this.harborDistanceList.add(harborDistance);
        return harborDistance;
    }

    @Override
    public IHarborDistanceReadable update(String id, double value) {
        for (HarborDistance harborDistance : harborDistanceList) {
            if (harborDistance.getId().equals(id)) {
                harborDistance.setValue(value);
                return harborDistance;
            }
        }
        return null;
    }

    @Override
    public IHarborDistanceReadable findByHarbors(int firstHarborId, int secondHarborId) {
        for (HarborDistance harborDistance : harborDistanceList) {
            if ((harborDistance.getFirstHarbor().getId() == firstHarborId
                    && harborDistance.getSecondHarbor().getId() == secondHarborId)
                    || (harborDistance.getFirstHarbor().getId() == secondHarborId
                            && harborDistance.getSecondHarbor().getId() == firstHarborId)) {
                return harborDistance;
            }
        }
        return null;
    }

    @Override
    public List<IHarborDistanceReadable> findAll() {
        List<IHarborDistanceReadable> harborDistances = new ArrayList<>();
        for (HarborDistance harborDistance : harborDistanceList) {
            harborDistances.add(harborDistance);
        }
        return harborDistances;
    }

}
