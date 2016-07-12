package ar.edu.unq.desapp.grupob.repositories;

import ar.edu.unq.desapp.grupob.model.Coordinate;
import ar.edu.unq.desapp.grupob.model.Ride;
import ar.edu.unq.desapp.grupob.model.Route;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

public class RideRepository extends GenericRepository<Ride> {

    @Override
    protected Class<Ride> getDomainClass() {
        return Ride.class;
    }

    @Transactional
    public List<Ride> findByDriverId(int id) {
        return this.getHibernateTemplate()
                .findByCriteria(DetachedCriteria.forClass(Ride.class)
                        .createAlias("driver", "d")
                        .add(Restrictions.eq("d.id", id)));
    }

    @Transactional
    public List<Ride> findSimilarRide(Route route) {
        List<Ride> allRides = this.getHibernateTemplate()
                .findByCriteria(DetachedCriteria.forClass(Ride.class));
        List<Ride> filteredRides = new LinkedList<Ride>();

        for (Ride ride : allRides) {
            double distanceBetweenBegin = Coordinate.calculateDistanceBetween(
                    route.getBegin(), ride.getRoute().getBegin());
            double distanceBetweenEnd = Coordinate.calculateDistanceBetween(
                    route.getEnd(), ride.getRoute().getEnd());
            if (distanceBetweenBegin < 0.02 && distanceBetweenEnd < 0.02) {
                filteredRides.add(ride);
            }
        }
        return filteredRides;
    }
}
