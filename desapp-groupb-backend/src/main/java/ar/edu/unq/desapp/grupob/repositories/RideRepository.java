package ar.edu.unq.desapp.grupob.repositories;

import ar.edu.unq.desapp.grupob.model.Ride;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RideRepository extends GenericRepository<Ride>{

    @Override
    protected Class<Ride> getDomainClass() {
            return Ride.class;
    }

    @Transactional
    public List<Ride> findByDriverId(int id){
        return  this.getHibernateTemplate()
          .findByCriteria(DetachedCriteria.forClass(Ride.class)
            .createAlias("driver", "d")
            .add(Restrictions.eq("d.id", id)));
    }
}
