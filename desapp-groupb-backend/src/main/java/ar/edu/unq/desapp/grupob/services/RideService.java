package ar.edu.unq.desapp.grupob.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ar.edu.unq.desapp.grupob.model.Ride;
import ar.edu.unq.desapp.grupob.model.User;
import ar.edu.unq.desapp.grupob.repositories.RideRepository;
import ar.edu.unq.desapp.grupob.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Path("/rides")
public class RideService extends GenericService<Ride> {

  @Autowired
  private RideRepository repository;

  @GET
  @Path("/{id}/driverRides")
  @Produces("application/json")
  @Transactional
  public List<Ride> getDriverRides(@PathParam("id") Integer id){
    return getRepository().findByDriverId(id);
  }

  public RideRepository getRepository() {
    return repository;
  }

  public void setRepository(RideRepository repository) {
    this.repository = repository;
  }
}
