package ar.edu.unq.desapp.grupob.services;

import ar.edu.unq.desapp.grupob.model.DayOfWeekRideDate;
import ar.edu.unq.desapp.grupob.model.Ride;
import ar.edu.unq.desapp.grupob.model.RideRequest;
import ar.edu.unq.desapp.grupob.model.User;
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



    @POST
    @Path("/joinRide")
    @Consumes("application/json")
    @Transactional
    public RideRequest joinRide(Ride ride, User user){
        RideRequest rideRequest = new RideRequest(user, rideRepository.find(ride.getId()), new DayOfWeekRideDate(DateTimeConstants.TUESDAY));
        getRepository().save(rideRequest);
        user.addRideRequest(rideRequest);
        userRepository.update(user);
        return rideRequest;
    }

    @GET
    @Path("/{id}/passengerRideRequests")
    @Produces("application/json")
    @Transactional
    public List<RideRequest> getPassengerRidesRequest(@PathParam("id") Integer id){
      return getRepository().findByPassengerId(id);
    }

    @GET
    @Path("/{id}/driverRideRequests")
    @Produces("application/json")
    @Transactional
    public List<RideRequest> getDriverRidesRequest(@PathParam("id") Integer id){
      return getRepository().findByDriverId(id);
    }

    public RideRequestRepository getRepository() {
      return repository;
    }

    public void setRepository(RideRequestRepository repository) {
      this.repository = repository;
    }

}

