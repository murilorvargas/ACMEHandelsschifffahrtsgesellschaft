package modules.freight.entities.interfaces;

import modules.freight.enums.FreightStatus;

public interface IFreightReadable {
    String getId();

    FreightStatus getStatus();

    double getValue();
}