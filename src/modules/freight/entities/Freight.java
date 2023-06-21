package modules.freight.entities;

import java.util.UUID;

import modules.cargo.entities.interfaces.ICargoReadable;
import modules.freight.entities.interfaces.IFreightReadable;
import modules.freight.enums.FreightStatus;
import modules.ship.entities.interfaces.IShipReadable;

public class Freight implements IFreightReadable, Comparable<Freight> {
    private String id;
    private double value;
    private FreightStatus status;
    private IShipReadable ship;
    private ICargoReadable cargo;

    public Freight(double value, FreightStatus status, IShipReadable ship, ICargoReadable cargo) {
        this.id = UUID.randomUUID().toString();
        this.value = value;
        this.status = status;
        this.ship = ship;
        this.cargo = cargo;
    }

    public String getId() {
        return id;
    }

    public FreightStatus getStatus() {
        return status;
    }

    public double getValue() {
        return value;
    }

    public void setStatus(FreightStatus status) {
        this.status = status;
    }

    public IShipReadable getShip() {
        return ship;
    }

    public ICargoReadable getCargo() {
        return cargo;
    }

    @Override
    public int compareTo(Freight o) {
        return this.id.compareTo(o.id);
    }
}
