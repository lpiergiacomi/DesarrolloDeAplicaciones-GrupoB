package ar.edu.unq.desapp.grupob.repositories;

import ar.edu.unq.desapp.grupob.model.Vehicle;

public class VehicleRepository extends GenericRepository<Vehicle>{

    @Override
    protected Class<Vehicle> getDomainClass() {
        return Vehicle.class;
    }
}
