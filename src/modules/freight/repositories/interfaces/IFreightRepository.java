package modules.freight.repositories.interfaces;

import modules.freight.entities.interfaces.IFreightReadable;
import modules.freight.enums.FreightStatus;

public interface IFreightRepository {
    IFreightReadable createFreight(FreightStatus status, double value);

    void updateFreight(String id, FreightStatus status, double value);
}
