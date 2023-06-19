package modules.client.entities;

import modules.client.entities.interfaces.IClientReadable;

public class Client implements Comparable<Client>, IClientReadable {

    private int code;
    private String name;
    private String email;

    public Client(int code, String name, String email) {
        this.code = code;
        this.name = name;
        this.email = email;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public int compareTo(Client other) {
        return this.name.compareTo(other.name);
    }

}
