package modules.cargo.repositories;

import modules.cargoType.entities.CargoType;

public interface ICargoRepository {
    void create(double weight, double declaredValue, int maxTime, CargoType cargoType);
}