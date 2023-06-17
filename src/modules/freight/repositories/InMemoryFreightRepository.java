package modules.freight.repositories;

import java.util.TreeSet;

import modules.freight.entities.Freight;
import modules.freight.entities.interfaces.IFreightReadable;
import modules.freight.enums.FreightStatus;
import modules.freight.repositories.interfaces.IFreightRepository;

public class InMemoryFreightRepository implements IFreightRepository {
    private TreeSet<Freight> freightSet;
    private static InMemoryFreightRepository instance = null;

    public static synchronized InMemoryFreightRepository instanceOf() {
        if (instance == null) {
            instance = new InMemoryFreightRepository();
        }
        return instance;
    }

    private InMemoryFreightRepository() {
        this.freightSet = new TreeSet<>();
    }

    @Override
    public IFreightReadable createFreight(FreightStatus status, double value) {
        Freight freight = new Freight(status, value);
        freightSet.add(freight);
        return freight;
    }

    @Override
    public void updateFreight(String id, FreightStatus status, double value) {
        for (Freight freight : freightSet) {
            if (freight.getId().equals(id)) {
                freight.setStatus(status);
                break;
            }
        }
    }
}
