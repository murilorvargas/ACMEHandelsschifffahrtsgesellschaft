package modules.cargo.repositories.interfaces;

import java.util.TreeSet;

import modules.cargo.entities.interfaces.ICargoReadable;
import modules.cargo.enums.CargoStatus;
import modules.cargoType.entities.interfaces.ICargoTypeReadable;

public interface ICargoRepository {
    ICargoReadable create(int id, double weight, double declaredValue, int maxTime, ICargoTypeReadable cargoType);

    ICargoReadable updateStatus(int id, CargoStatus cargoStatus);

    TreeSet<ICargoReadable> findAll();

    ICargoReadable findById(int id);
}