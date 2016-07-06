package ar.edu.unq.desapp.grupob.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupob.model.Route;
import ar.edu.unq.desapp.grupob.repositories.CoordinateRepository;

@Path("/routes")
public class RouteService extends GenericService<Route> {

    CoordinateRepository coordinateRepository;

    @POST
    @Path("/saveRoute")
    @Consumes("application/json")
    @Transactional
    public void save(Route route) {
        this.getRepository().save(route);
    }

    @GET
    @Path("/searchEqualRoute")
    @Produces("application/json")
    @Transactional(readOnly = true)
    public List<Route> searchEqualRoute(Route route) {
        //return this.getRepository().searchEqualRoute();
    }
}
