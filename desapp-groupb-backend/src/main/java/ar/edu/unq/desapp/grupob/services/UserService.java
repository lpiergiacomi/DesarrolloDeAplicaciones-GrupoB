package ar.edu.unq.desapp.grupob.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupob.model.Ride;
import ar.edu.unq.desapp.grupob.model.RideRequest;
import ar.edu.unq.desapp.grupob.model.User;
import ar.edu.unq.desapp.grupob.repositories.UserRepository;

@Path("/users")
public class UserService extends GenericService<User> {

    @Autowired
    private UserRepository repository;

    @POST
    @Path("/register")
    @Produces("application/json")
    @Consumes("application/json")
    @Transactional
    public User forRegistration(User user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        getRepository().save(newUser);
        return newUser;
    }

    @GET
    @Path("/login/{email}")
    @Produces("application/json")
    @Transactional
    public User loginUser(@PathParam("email") String email) {
        return getRepository().findByEmail(email);
    }

    @GET
    @Path("/{id}/driverRides")
    @Produces("application/json")
    @Transactional
    public List<Ride> getDriverRides(@PathParam("id") Integer id) {
        User user = getRepository().find(id);
        return user.getDriverRides();
    }

    @GET
    @Path("/{id}/passengerRides")
    @Produces("application/json")
    @Transactional
    public List<Ride> getPassengerRides(@PathParam("id") Integer id) {
        User user = getRepository().find(id);
        return user.getPassengerRides();
    }

    @GET
    @Path("/{id}/driverRideRequests")
    @Produces("application/json")
    @Transactional
    public List<RideRequest> getDriverRideRequests(
            @PathParam("id") Integer id) {
        User user = getRepository().find(id);
        return user.getDriverRideRequests();
    }

    @GET
    @Path("/{id}/passengerRideRequests")
    @Produces("application/json")
    @Transactional
    public List<RideRequest> getPassengerRideRequests(
            @PathParam("id") Integer id) {
        User user = getRepository().find(id);
        return user.getPassengerRideRequests();
    }

    public UserRepository getRepository() {
        return repository;
    }

    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }
}
