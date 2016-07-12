package ar.edu.unq.desapp.grupob.persistence;

import ar.edu.unq.desapp.grupob.model.Passenger;
import ar.edu.unq.desapp.grupob.model.Role;
import ar.edu.unq.desapp.grupob.repositories.RoleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:test-spring-persistence-context.xml" })
public class RolePersistenceTest
        extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private RoleRepository roleRepository;

    private Passenger passenger;

    @Before
    public void setUp() {
        passenger = new Passenger();
        roleRepository.save(passenger);
    }

    @Test
    public void itShouldSaveARole() {
        List<Role> roles = roleRepository.getAll();

        assertEquals(roles.size(), 1);
    }

    @Test
    public void itShouldUpdateARole() {
        assertEquals(passenger.getGoodRate(), 0);
        passenger.receiveGoodRate();
        roleRepository.update(passenger);
        assertEquals(roleRepository.find(passenger.getId()).getGoodRate(), 1);
    }

    @Test
    public void itShouldDeleteARole() {
        roleRepository.delete(passenger.getId());

        assertEquals(roleRepository.getAll().size(), 0);
    }
}
