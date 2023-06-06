package modules.cargo.repositories;

import java.util.TreeSet;

import modules.cargo.entities.ICargoReadable;
import modules.cargo.enums.CargoStatus;
import modules.cargoType.entities.ICargoTypeReadable;

public interface ICargoRepository {
    ICargoReadable create(String id, double weight, double declaredValue, int maxTime, ICargoTypeReadable cargoType);

    ICargoReadable updateStatus(String id, CargoStatus cargoStatus);

    TreeSet<ICargoReadable> findAll();

    ICargoReadable findById(String id);
}