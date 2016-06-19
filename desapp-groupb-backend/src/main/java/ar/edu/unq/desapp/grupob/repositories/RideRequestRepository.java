package ar.edu.unq.desapp.grupob.repositories;

import ar.edu.unq.desapp.grupob.model.RideRequest;

public class RideRequestRepository extends GenericRepository<RideRequest>{

    @Override
    protected Class<RideRequest> getDomainClass() {
        return RideRequest.class;
    }
}
