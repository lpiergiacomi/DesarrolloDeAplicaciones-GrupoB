package ar.edu.unq.desapp.grupob.repositories;

import ar.edu.unq.desapp.grupob.model.Route;

public class RouteRepository extends GenericRepository<Route>{

    @Override
    protected Class<Route> getDomainClass() {
        return Route.class;
    }
}
