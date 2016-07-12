package ar.edu.unq.desapp.grupob.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupob.model.Message;
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

    @GET
    @Path("/{id}/publicMessages")
    @Produces("application/json")
    @Transactional
    public List<Message> getPublicMessages(@PathParam("id") Integer id) {
        User user = getRepository().find(id);
        List<Message> messages = new ArrayList<>();
        user.getMessages().stream().filter(m -> !m.isPrivate())
                .forEach(m -> messages.add(m));
        return messages;
    }

    @GET
    @Path("/{id}/privateMessages/{otherUserId}")
    @Produces("application/json")
    @Transactional
    public List<Message> getPrivateMessages(@PathParam("id") Integer id,
            @PathParam("otherUserId") Integer otherUserId) {
        User user = getRepository().find(id);
        List<Message> messages = new ArrayList<>();
        user.getMessages().stream()
                .filter(m -> m.isPrivate()
                        && (m.getSender().getId().equals(otherUserId)
                                || m.getReceiver().getId().equals(otherUserId)))
                .forEach(m -> messages.add(m));
        return messages;
    }

    @POST
    @Path("/{id}/giveDriverGoodRate")
    @Transactional
    public User giveDriverGoodRate(@PathParam("id") Integer id) {
        User user = getRepository().find(id);
        user.receiveDriverGoodRate();
        getRepository().update(user);
        return user;
    }

    @POST
    @Path("/{id}/giveDriverBadRate")
    @Transactional
    public User giveDriverBadRate(@PathParam("id") Integer id) {
        User user = getRepository().find(id);
        user.receiveDriverBadRate();
        getRepository().update(user);
        return user;
    }

    @POST
    @Path("/{id}/givePassengerGoodRate")
    @Transactional
    public User givePassengerGoodRate(@PathParam("id") Integer id) {
        User user = getRepository().find(id);
        user.receivePassengerGoodRate();
        getRepository().update(user);
        return user;
    }

    @POST
    @Path("/{id}/givePassengerBadRate")
    @Transactional
    public User givePassengerBadRate(@PathParam("id") Integer id) {
        User user = getRepository().find(id);
        user.receivePassengerBadRate();
        getRepository().update(user);
        return user;
    }

    @POST
    @Path("/{id}/sendPublicMessage/{receiverId}")
    @Transactional
    public void sendPublicMessage(@PathParam("id") Integer id,
            @PathParam("receiverId") Integer receiverId, String message) {
        User sender = getRepository().find(id);
        User receiver = getRepository().find(receiverId);
        sender.sendPublicMessageTo(receiver, message);
        getRepository().update(receiver);
    }

    @POST
    @Path("/{id}/sendPrivateMessage/{receiverId}")
    @Transactional
    public void sendPrivateMessage(@PathParam("id") Integer id,
            @PathParam("receiverId") Integer receiverId, String message) {
        User sender = getRepository().find(id);
        User receiver = getRepository().find(receiverId);
        sender.sendPrivateMessageTo(receiver, message);
        getRepository().update(sender);
        getRepository().update(receiver);
    }

    public UserRepository getRepository() {
        return repository;
    }

    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }
}
