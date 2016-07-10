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
        vehicle = new Vehicle(1, 2, "Honda Civic");
        vehicleRepository.save(vehicle);
    }

    @Test
    public void itShouldSaveAVehicle() {
        List<Vehicle> vehicles = vehicleRepository.getAll();

        assertEquals(vehicles.size(), 1);
    }

    @Test
    public void itShouldUpdateAVehicle() {
        assertEquals(vehicle.getCapacity(), 1);

        vehicle.setCapacity(2);
        vehicleRepository.update(vehicle);

        assertEquals(vehicleRepository.find(vehicle.getId()).getCapacity(), 2);
    }

    @Test
    public void itShouldDeleteAVehicle() {
        vehicleRepository.delete(vehicle.getId());

        assertEquals(vehicleRepository.getAll().size(), 0);
    }
}
