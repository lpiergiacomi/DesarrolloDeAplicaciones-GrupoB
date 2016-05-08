package ar.edu.unq.desapp.grupob.repositories;

import ar.edu.unq.desapp.grupob.model.Role;

public class RoleRepository extends GenericRepository<Role>{

    @Override
    protected Class<Role> getDomainClass() {
            return Role.class;
    }
}
