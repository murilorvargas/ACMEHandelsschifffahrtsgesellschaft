package modules.client.repositories.interfaces;

import java.util.List;

import modules.client.entities.interfaces.IClientReadable;

public interface IClientRepository {

    IClientReadable create(int code, String name, String email);

    List<IClientReadable> findAll();

    IClientReadable findByCode(int code);

    IClientReadable findByName(String name);

    IClientReadable findByEmail(String email);

}
