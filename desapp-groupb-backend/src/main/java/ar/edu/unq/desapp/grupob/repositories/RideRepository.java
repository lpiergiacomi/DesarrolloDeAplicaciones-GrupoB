package ar.edu.unq.desapp.grupob.repositories;

import ar.edu.unq.desapp.grupob.model.Ride;

public class RideRepository extends GenericRepository<Ride>{

    @Override
    protected Class<Ride> getDomainClass() {
            return Ride.class;
    }
}
