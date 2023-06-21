package modules.freight.repositories.interfaces;

import java.util.List;

import modules.cargo.entities.interfaces.ICargoReadable;
import modules.freight.entities.interfaces.IFreightReadable;
import modules.freight.enums.FreightStatus;
import modules.ship.entities.interfaces.IShipReadable;

public interface IFreightRepository {
    IFreightReadable createFreight(double value, FreightStatus status, IShipReadable ship, ICargoReadable cargo);

    void updateFreight(String id, FreightStatus status);

    List<IFreightReadable> findAllInProgress();

    IFreightReadable findById(String id);

    List<IFreightReadable> findAll();
}
