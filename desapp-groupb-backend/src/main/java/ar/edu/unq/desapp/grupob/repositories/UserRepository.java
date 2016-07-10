package ar.edu.unq.desapp.grupob.repositories;
import ar.edu.unq.desapp.grupob.model.Message;
import ar.edu.unq.desapp.grupob.model.User;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public class UserRepository extends GenericRepository<User>{

    @Override
    protected Class<User> getDomainClass() {
        return User.class;
    }

    @Transactional
    public User findByEmail(String email){
      try{
        List<User> users = (List<User>) this.getHibernateTemplate()
          .findByCriteria(DetachedCriteria.forClass(User.class).add(Restrictions.eq("email", email)));
        return users.get(0);
      }catch(IndexOutOfBoundsException e){
        return null;
      }
    }
//
//    @Transactional
//    public List<Message> getPrivateMessages(Integer rootUserId, Integer otherUserId) {
//
//      List<Message> messages = this.getHibernateTemplate()
//                                 .findByCriteria(DetachedCriteria.forClass(Message.class)
//                                                   .add(Restrictions.eq("isPrivate", true))
//                                                   .createAlias("sender", "s")
//                                                   .createAlias("receiver", "r")
//                                                   .add(Restrictions.or(Restrictions.eq("s.id", otherUserId), Restrictions.eq("r.id", otherUserId))));
//      return users.get(0);
//    }
}
