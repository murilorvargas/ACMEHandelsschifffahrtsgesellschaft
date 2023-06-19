package modules.client.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import modules.client.entities.Client;
import modules.client.entities.interfaces.IClientReadable;
import modules.client.repositories.interfaces.IClientRepository;

public class InMemoryClientRepository implements IClientRepository {

    private TreeSet<Client> clientList;
    private static InMemoryClientRepository instance = null;

    public static synchronized InMemoryClientRepository instanceOf() {
        if (instance == null) {
            instance = new InMemoryClientRepository();
        }
        return instance;
    }

    private InMemoryClientRepository() {
        this.clientList = new TreeSet<Client>();
    }

    @Override
    public Client create(int code, String name, String email) {
        Client client = new Client(code, name, email);
        this.clientList.add(client);

        return client;
    }

    @Override
    public List<IClientReadable> findAll() {
        List<IClientReadable> clientSet = new ArrayList<>();
        for (Client client : this.clientList) {
            clientSet.add(client);
        }
        return clientSet;
    }

    @Override
    public IClientReadable findByCode(int code) {
        for (Client client : this.clientList) {
            if (client.getCode() == code) {
                return client;
            }
        }
        return null;
    }

    public IClientReadable findByName(String name) {
        for (Client client : this.clientList) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }

    public IClientReadable findByEmail(String email) {
        for (Client client : this.clientList) {
            if (client.getEmail().equals(email)) {
                return client;
            }
        }
        return null;
    }

}
