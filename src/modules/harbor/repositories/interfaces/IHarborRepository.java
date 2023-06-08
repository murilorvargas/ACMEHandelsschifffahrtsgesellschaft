package modules.harbor.repositories.interfaces;

import java.util.List;

import modules.harbor.entities.interfaces.IHarborReadable;

public interface IHarborRepository {
    IHarborReadable create(int id, String name, String country);

    List<IHarborReadable> findAll();

    IHarborReadable findById(int id);
}
