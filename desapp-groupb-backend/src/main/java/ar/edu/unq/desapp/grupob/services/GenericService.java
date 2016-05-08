package ar.edu.unq.desapp.grupob.services;

import java.io.Serializable;
import java.util.List;
//import ar.edu.unq.desapp.grupob.repositories.GenericRepository;
//import org.springframework.transaction.annotation.Transactional;

public class GenericService<T> implements Serializable {

  private static final long serialVersionUID = -6540963495078524186L;

//  private GenericRepository<T> repository;

//  public GenericRepository<T> getRepository() {
//    return this.repository;
//  }

//  public void setRepository(final GenericRepository<T> repository) {
//    this.repository = repository;
//  }
//
//  @Transactional
//  public void delete(Integer id) {
//    this.getRepository().delete(id);
//  }
//
//  @Transactional(readOnly = true)
//  public List<T> retrieveAll() {
//    return this.getRepository().all();
//  }
//
//  @Transactional
//  public void save(final T object) {
//    this.getRepository().save(object);
//  }
//
//  @Transactional
//  public void update(final T object) {
//    this.getRepository().update(object);
//  }

}
