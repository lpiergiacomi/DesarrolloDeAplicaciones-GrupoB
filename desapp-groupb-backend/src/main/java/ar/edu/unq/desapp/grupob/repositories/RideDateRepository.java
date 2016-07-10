package ar.edu.unq.desapp.grupob.repositories;

import ar.edu.unq.desapp.grupob.model.RideDate;

public class RideDateRepository extends GenericRepository<RideDate> {

    @Override
    protected Class<RideDate> getDomainClass() {
        return RideDate.class;
    }

}