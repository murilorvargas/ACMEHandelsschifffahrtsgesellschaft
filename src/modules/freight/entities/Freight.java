package modules.freight.entities;

import java.util.UUID;

import modules.freight.entities.interfaces.IFreightReadable;
import modules.freight.enums.FreightStatus;

public class Freight implements IFreightReadable {
    private String id;
    private FreightStatus status;
    private double value;

    public Freight(FreightStatus status, double value) {
        this.id = UUID.randomUUID().toString();
        this.status = status;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public FreightStatus getStatus() {
        return status;
    }

    public void setStatus(FreightStatus status) {
        this.status = status;
    }

    public double getValue() {
        return value;
    }
}
