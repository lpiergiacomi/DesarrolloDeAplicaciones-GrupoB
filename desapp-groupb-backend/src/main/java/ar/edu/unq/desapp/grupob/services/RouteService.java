package ar.edu.unq.desapp.grupob.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupob.model.Coordinate;
import ar.edu.unq.desapp.grupob.model.Route;
import ar.edu.unq.desapp.grupob.repositories.CoordinateRepository;

@Path("/routes")
public class RouteService extends GenericService<Route> {

    CoordinateRepository coordinateRepository;

    @POST
    @Path("/")
    @Consumes("application/x-www-form-urlencoded")
    @Transactional
    //public void save(@FormParam("begin") Coordinate begin, @FormParam("end") Coordinate end) {
        public void save(Coordinate begin, Coordinate end) {
        System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
        //coordinateRepository.save(begin);
        //coordinateRepository.save(end);
        //Route route = new Route(coordinateRepository.find(begin.getId()),
        //      coordinateRepository.find(end.getId()));
        //this.getRepository().save(route);
    }
}
