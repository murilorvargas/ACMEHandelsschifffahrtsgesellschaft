package modules.cargo.repositories.interfaces;

import java.util.List;

import modules.cargo.entities.interfaces.ICargoReadable;
import modules.cargo.enums.CargoPriority;
import modules.cargo.enums.CargoStatus;
import modules.cargoType.entities.interfaces.ICargoTypeReadable;
import modules.harbor.entities.interfaces.IHarborReadable;

public interface ICargoRepository {
    ICargoReadable create(int id, double weight, double declaredValue, int maxTime, CargoPriority priority,
            ICargoTypeReadable cargoType,
            IHarborReadable originHarbor, IHarborReadable destinationHarbor);

    ICargoReadable updateStatus(int id, CargoStatus cargoStatus);

    List<ICargoReadable> findAll();

    List<ICargoReadable> findByStatus(CargoStatus cargoStatus);

    ICargoReadable findById(int id);
}