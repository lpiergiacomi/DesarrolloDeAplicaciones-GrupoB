package ar.edu.unq.desapp.grupob.services;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("/products")
public class ProductsService {

  @GET
  @Path("/test")
  @Produces("application/json")
  public List<Integer> thisIsATest() {
    List<Integer> l = new ArrayList<>();
    l.add(1);l.add(1);
    return l;
  }
}
