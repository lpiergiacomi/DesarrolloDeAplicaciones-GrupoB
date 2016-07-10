package ar.edu.unq.desapp.grupob.repositories;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupob.model.Coordinate;
import ar.edu.unq.desapp.grupob.model.RideRequest;
import ar.edu.unq.desapp.grupob.model.Route;

public class RouteRepository extends GenericRepository<Route>{

    @Override
    protected Class<Route> getDomainClass() {
        return Route.class;
    }
}
