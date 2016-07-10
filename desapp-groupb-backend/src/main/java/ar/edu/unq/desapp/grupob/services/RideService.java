package ar.edu.unq.desapp.grupob.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ar.edu.unq.desapp.grupob.model.DayOfWeekRideDate;
import ar.edu.unq.desapp.grupob.model.Ride;
import ar.edu.unq.desapp.grupob.model.RideDate;
import ar.edu.unq.desapp.grupob.model.Route;
import ar.edu.unq.desapp.grupob.model.User;
import ar.edu.unq.desapp.grupob.repositories.RideDateRepository;
import ar.edu.unq.desapp.grupob.repositories.RideRepository;
import ar.edu.unq.desapp.grupob.repositories.RouteRepository;
import ar.edu.unq.desapp.grupob.repositories.UserRepository;

import org.joda.time.DateTimeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Path("/rides")
public class RideService extends GenericService<Ride> {

    @Autowired
    RideRepository repository;

    @Autowired
    RouteRepository routeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RideDateRepository rideDateRepository;

    @GET
    @Path("/{id}/driverRides")
    @Produces("application/json")
    @Transactional
    public List<Ride> getDriverRides(@PathParam("id") Integer id) {
        return getRepository().findByDriverId(id);
    }

    @POST
    @Path("/{id}/saveRide")
    @Consumes("application/json")
    @Transactional
    public void save(@PathParam("id") Integer id, Route route) {
        User driver = userRepository.find(id);
        RideDate date = new DayOfWeekRideDate(DateTimeConstants.TUESDAY);
        rideDateRepository.save(date);
        routeRepository.save(route);
        Ride ride = new Ride(driver, route, date);
        repository.save(ride);
    }

    @POST
    @Path("/searchSimilarRide")
    @Consumes("application/json")
    @Produces("application/json")
    @Transactional
    public List<Ride> searchSimilarRoute(Route route) {
        return this.getRepository().findSimilarRide(route);
    }

    public RideRepository getRepository() {
        return repository;
    }

    public void setRepository(RideRepository repository) {
        this.repository = repository;
    }

    public RouteRepository getRouteRepository() {
        return routeRepository;
    }

    public void setRouteRepository(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RideDateRepository getRideDateRepository() {
        return rideDateRepository;
    }

    public void setRideDateRepository(RideDateRepository rideDateRepository) {
        this.rideDateRepository = rideDateRepository;
    }
}
