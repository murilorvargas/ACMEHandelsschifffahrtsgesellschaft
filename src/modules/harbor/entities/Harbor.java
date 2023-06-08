package modules.harbor.entities;

import modules.harbor.entities.interfaces.IHarborReadable;

public class Harbor implements Comparable<Harbor>, IHarborReadable {
    private int id;
    private String name;
    private String country;

    public Harbor(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public int compareTo(Harbor other) {
        return this.id - other.id;
    }
}
