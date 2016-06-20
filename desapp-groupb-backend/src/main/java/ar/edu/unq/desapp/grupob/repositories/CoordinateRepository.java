package ar.edu.unq.desapp.grupob.repositories;

import ar.edu.unq.desapp.grupob.model.Coordinate;

public class CoordinateRepository extends GenericRepository<Coordinate>{

    @Override
    protected Class<Coordinate> getDomainClass() {
        return Coordinate.class;
    }
}
