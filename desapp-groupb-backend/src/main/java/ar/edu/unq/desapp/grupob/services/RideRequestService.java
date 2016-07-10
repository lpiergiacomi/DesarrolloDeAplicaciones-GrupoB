package ar.edu.unq.desapp.grupob.services;

import ar.edu.unq.desapp.grupob.model.*;
import ar.edu.unq.desapp.grupob.repositories.RideDateRepository;
import ar.edu.unq.desapp.grupob.repositories.RideRepository;
import ar.edu.unq.desapp.grupob.repositories.RideRequestRepository;
import ar.edu.unq.desapp.grupob.repositories.UserRepository;
import org.joda.time.DateTimeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import java.util.List;

@Path("/rideRequests")
public class RideRequestService extends GenericService<RideRequest> {

    @Autowired
    private RideRepository rideRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RideRequestRepository repository;
    @Autowired
    private RideDateRepository rideDateRepository;

    @POST
    @Path("/{rideId}/{userId}/joinRide")
    @Consumes("application/json")
    @Transactional
    public RideRequest joinRide(@PathParam("rideId") Integer rideId,
            @PathParam("userId") Integer userId) {
        Ride ride = rideRepository.find(rideId);
        User user = userRepository.find(userId);
        RideDate rideDate = new DayOfWeekRideDate(DateTimeConstants.TUESDAY);
        rideDateRepository.save(rideDate);
        RideRequest rideRequest = new RideRequest(user, ride, rideDate);
        getRepository().save(rideRequest);
        return rideRequest;
    }

    @POST
    @Path("/{rideRequestId}/acceptRideRequest")
    @Consumes("application/json")
    @Produces("application/json")
    @Transactional
    public RideRequest acceptRideRequest(
            @PathParam("rideRequestId") Integer rideRequestId) {
        RideRequest rideRequest = repository.find(rideRequestId);
        rideRequest.accept();
        repository.update(rideRequest);
        return rideRequest;
    }

    @GET
    @Path("/{id}/passengerRideRequests")
    @Produces("application/json")
    @Transactional
    public List<RideRequest> getPassengerRidesRequest(
            @PathParam("id") Integer id) {
        return getRepository().findByPassengerId(id);
    }

    @GET
    @Path("/{id}/driverRideRequests")
    @Produces("application/json")
    @Transactional
    public List<RideRequest> getDriverRidesRequest(
            @PathParam("id") Integer id) {
        return getRepository().findByDriverId(id);
    }

    public RideRequestRepository getRepository() {
        return repository;
    }

    public void setRepository(RideRequestRepository repository) {
        this.repository = repository;
    }

    public RideRepository getRideRepository() {
        return rideRepository;
    }

    public void setRideRepository(RideRepository repository) {
        this.rideRepository = repository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository repository) {
        this.userRepository = repository;
    }

    public RideDateRepository getRideDateRepository() {
        return rideDateRepository;
    }

    public void setRideDateRepository(RideDateRepository repository) {
        this.rideDateRepository = repository;
    }
}
