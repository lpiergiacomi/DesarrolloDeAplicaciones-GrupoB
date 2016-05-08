package ar.edu.unq.desapp.grupob.repositories;

public class RideRequestRepository extends GenericRepository<RideRequestRepository>{

    @Override
    protected Class<RideRequestRepository> getDomainClass() {
        return RideRequestRepository.class;
    }
}
