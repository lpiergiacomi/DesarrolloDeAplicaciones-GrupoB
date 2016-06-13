package ar.edu.unq.desapp.grupob.repositories;
import ar.edu.unq.desapp.grupob.model.User;
import org.springframework.transaction.annotation.Transactional;

public class UserRepository extends GenericRepository<User>{

    @Override
    protected Class<User> getDomainClass() {
        return User.class;
    }

    @Transactional
    public User findByEmail(String email){
      User user = new User();
      user.setEmail(email);
      try{
        return (User) this.getHibernateTemplate().findByExample(user).get(0);
      }catch(IndexOutOfBoundsException e){
        return null;
      }
    }
}
