package ar.edu.unq.desapp.grupob.services;

import ar.edu.unq.desapp.grupob.model.User;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;

@Path("/users")
public class UserService extends GenericService<User> {

    @GET
    @Path("/register/{email}/{password}")
    @Produces("application/json")
    @Transactional
    public User forRegistration(@PathParam("email") String email, @PathParam("password") String password){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        getRepository().save(user);
        return user;
    }

//    @GET
//    @Path("/{email}")
//    @Produces("application/json")
//    @Transactional
//    public User forRegistration(@PathParam("email") String email) {
//    }

}
