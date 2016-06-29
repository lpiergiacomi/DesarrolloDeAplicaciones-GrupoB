package ar.edu.unq.desapp.grupob.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupob.model.Coordinate;
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
}
