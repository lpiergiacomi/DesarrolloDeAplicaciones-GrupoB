package ar.edu.unq.desapp.grupob.persistence;

import ar.edu.unq.desapp.grupob.model.Vehicle;
import ar.edu.unq.desapp.grupob.repositories.VehicleRepository;
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
@ContextConfiguration(locations = { "classpath:test-spring-persistence-context.xml" })
public class VehiclePersistenceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private VehicleRepository vehicleRepository;

    private Vehicle vehicle;

    @Before
    public void setUp() {
        vehicle = new Vehicle(1);
        vehicleRepository.save(vehicle);
    }

    @Test
    public void itShouldSaveAProduct() {
        List<Vehicle> vehicles = vehicleRepository.all();

        assertEquals(vehicles.size(), 1);
    }

    @Test
    public void itShouldUpdateAProduct() {
        assertEquals(vehicle.getCapacity(), 1);

        vehicle.setCapacity(2);
        vehicleRepository.update(vehicle);

        assertEquals(vehicleRepository.find(1).getCapacity(), 2);
    }

    @Test
    public void itShouldDeleteAProduct() {
        vehicleRepository.delete(vehicle.getId());

        assertEquals(vehicleRepository.all().size(), 0);
    }
}