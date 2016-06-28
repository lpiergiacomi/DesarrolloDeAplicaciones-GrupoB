package ar.edu.unq.desapp.grupob.repositories;

import ar.edu.unq.desapp.grupob.model.RideRequest;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RideRequestRepository extends GenericRepository<RideRequest>{

    @Override
    protected Class<RideRequest> getDomainClass() {
        return RideRequest.class;
    }

    @Transactional
    public List<RideRequest> findByPassengerId(int id){
      return  this.getHibernateTemplate()
        .findByCriteria(DetachedCriteria.forClass(RideRequest.class)
          .createAlias("user", "d")
          .add(Restrictions.eq("d.id", id)));
    }

    @Transactional
    public List<RideRequest> findByDriverId(int id){
      return  this.getHibernateTemplate()
        .findByCriteria(DetachedCriteria.forClass(RideRequest.class)
          .createAlias("ride.driver", "d")
          .add(Restrictions.eq("d.id", id)));
    }
}
