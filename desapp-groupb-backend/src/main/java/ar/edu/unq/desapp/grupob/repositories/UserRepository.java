package ar.edu.unq.desapp.grupob.repositories;

import ar.edu.unq.desapp.grupob.model.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public class UserRepository extends GenericRepository<User> {

    @Override
    protected Class<User> getDomainClass() {
        return User.class;
    }

    @Transactional
    public User findByEmail(String email) {
        try {
            List<User> users = (List<User>) this.getHibernateTemplate()
                    .findByCriteria(DetachedCriteria.forClass(User.class)
                            .add(Restrictions.eq("email", email)));
            return users.get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
