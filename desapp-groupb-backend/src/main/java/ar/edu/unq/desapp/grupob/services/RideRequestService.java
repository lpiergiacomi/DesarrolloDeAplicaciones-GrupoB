package ar.edu.unq.desapp.grupob.services;

import ar.edu.unq.desapp.grupob.model.DayOfWeekRideDate;
import ar.edu.unq.desapp.grupob.model.Ride;
import ar.edu.unq.desapp.grupob.model.RideRequest;
import ar.edu.unq.desapp.grupob.model.User;
import ar.edu.unq.desapp.grupob.repositories.RideRepository;
import ar.edu.unq.desapp.grupob.repositories.UserRepository;
import org.joda.time.DateTimeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/rideRequests")
public class RideRequestService extends GenericService<RideRequest> {

    @Autowired
    private RideRepository rideRepository;
    @Autowired
    private UserRepository userRepository;

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

}

