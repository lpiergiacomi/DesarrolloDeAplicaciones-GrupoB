package ar.edu.unq.desapp.grupob.persistence;

import ar.edu.unq.desapp.grupob.model.User;
import ar.edu.unq.desapp.grupob.model.Vehicle;
import ar.edu.unq.desapp.grupob.repositories.UserRepository;
import ar.edu.unq.desapp.grupob.repositories.VehicleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-spring-persistence-context.xml" })
public class UserPersistenceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    private User user;

    @Before
    public void setUp() {
        user = new User();
        userRepository.save(user);
    }

    @Test
    public void itShouldSaveAUser() {
        List<User> users = userRepository.getAll();

        assertEquals(users.size(), 1);
    }

    @Test
    public void itShouldUpdateAUser() {
        Vehicle vehicle = new Vehicle(1, 2, "Honda Civic");
        vehicleRepository.save(vehicle);

        user.setVehicle(vehicle);
        userRepository.update(user);

        assertTrue(userRepository.find(user.getId()).hasVehicle());
    }

    @Test
    public void itShouldDeleteAUser() {
        userRepository.delete(user.getId());

        assertEquals(userRepository.getAll().size(), 0);
    }
}
