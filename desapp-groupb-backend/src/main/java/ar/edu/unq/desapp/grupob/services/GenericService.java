package ar.edu.unq.desapp.grupob.services;

import java.io.Serializable;
import java.util.List;

import ar.edu.unq.desapp.grupob.repositories.GenericRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;

@Service
public class GenericService<T> implements Serializable {

  private GenericRepository<T> repository;

  public GenericRepository<T> getRepository() {
    return this.repository;
  }

  public void setRepository(final GenericRepository<T> repository) {
    this.repository = repository;
  }

  @DELETE
  @Path("/delete/{id}")
  @Transactional
  public void delete(@PathParam("id") Integer id) {
    this.getRepository().delete(id);
  }

  @GET
  @Path("/all")
  @Produces("application/json")
  @Transactional(readOnly = true)
  public List<T> getAll() {
    return this.getRepository().getAll();
  }

  @GET
  @Path("/{id}")
  @Produces("application/json")
  @Transactional(readOnly = true)
  public T get(@PathParam("id") Integer id) {
    return this.getRepository().find(id);
  }

  @POST
  @Path("/")
  @Consumes("application/json")
  @Transactional
  public void save(final T object) {
    this.getRepository().save(object);
  }

  @PUT
  @Path("/")
  @Consumes("application/json")
  @Transactional
  public void update(final T object) {
    this.getRepository().update(object);
  }

}
