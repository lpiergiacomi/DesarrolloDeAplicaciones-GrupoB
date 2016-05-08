package ar.edu.unq.desapp.grupob.repositories;
import ar.edu.unq.desapp.grupob.model.User;

public class UserRepository extends GenericRepository<User>{

    @Override
    protected Class<User> getDomainClass() {
        return User.class;
    }
}
