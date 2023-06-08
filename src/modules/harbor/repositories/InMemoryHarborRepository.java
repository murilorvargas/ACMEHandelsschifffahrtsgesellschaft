package modules.harbor.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import modules.harbor.entities.Harbor;
import modules.harbor.entities.interfaces.IHarborReadable;
import modules.harbor.repositories.interfaces.IHarborRepository;

public class InMemoryHarborRepository implements IHarborRepository {
    private TreeSet<Harbor> harborList;
    private static InMemoryHarborRepository instance = null;

    public static synchronized InMemoryHarborRepository instanceOf() {
        if (instance == null) {
            instance = new InMemoryHarborRepository();
        }
        return instance;
    }

    private InMemoryHarborRepository() {
        this.harborList = new TreeSet<>();
    }

    @Override
    public IHarborReadable create(int id, String name, String country) {
        Harbor harbor = new Harbor(id, name, country);
        this.harborList.add(harbor);
        return harbor;
    }

    @Override
    public List<IHarborReadable> findAll() {
        List<IHarborReadable> harborSet = new ArrayList<>();
        for (Harbor harbor : this.harborList) {
            harborSet.add(harbor);
        }
        return harborSet;
    }

    @Override
    public IHarborReadable findById(int id) {
        for (Harbor harbor : this.harborList) {
            if (harbor.getId() == id) {
                return harbor;
            }
        }

        return null;
    }
}
