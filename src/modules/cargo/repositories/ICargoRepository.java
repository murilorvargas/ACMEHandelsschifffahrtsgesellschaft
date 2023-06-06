package modules.cargo.repositories;

import java.util.TreeSet;

import modules.cargo.entities.ICargoReadable;
import modules.cargo.enums.CargoStatus;
import modules.cargoType.entities.ICargoTypeReadable;

public interface ICargoRepository {
    ICargoReadable create(int id, double weight, double declaredValue, int maxTime, ICargoTypeReadable cargoType);

    ICargoReadable updateStatus(int id, CargoStatus cargoStatus);

    TreeSet<ICargoReadable> findAll();

    ICargoReadable findById(int id);
}