package modules.cargo.repositories;

import java.util.TreeSet;

import modules.cargo.entities.Cargo;
import modules.cargoType.entities.CargoType;

public interface ICargoRepository {
    Cargo create(String id, double weight, double declaredValue, int maxTime, CargoType cargoType);

    TreeSet<Cargo> findAllCargos();
}