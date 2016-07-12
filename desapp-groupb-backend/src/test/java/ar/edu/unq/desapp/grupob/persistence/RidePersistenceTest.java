package ar.edu.unq.desapp.grupob.persistence;

import ar.edu.unq.desapp.grupob.model.*;
import ar.edu.unq.desapp.grupob.repositories.*;
import org.joda.time.DateTimeConstants;
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
public class RidePersistenceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RideDateRepository rideDateRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    private Ride ride;
    private User user;
    private Route route;
    private DayOfWeekRideDate rideDate;

    @Before
    public void setUp() {
        user =  new User();
        route = new Route(new Coordinate("Quilmes", 2.0, 2.3), new Coordinate("Bernal", 3.0, 4.3));
        int tuesday = DateTimeConstants.TUESDAY;
        rideDate = new DayOfWeekRideDate(tuesday);
        Vehicle vehicle = new Vehicle(1, 2, "Honda Civic");
        user.setVehicle(vehicle);

        vehicleRepository.save(vehicle);
        rideDateRepository.save(rideDate);
        routeRepository.save(route);
        userRepository.save(user);

        ride = new Ride(user, route, rideDate);
        rideRepository.save(ride);
    }

    @Test
    public void itShouldSaveARide() {
        List<Ride> rides = rideRepository.getAll();

        assertEquals(rides.size(), 1);
    }

    @Test
    public void itShouldUpdateARide() {
        assertEquals(ride.getDate(), rideDate);
        int monday = DateTimeConstants.MONDAY;
        DayOfWeekRideDate rideDateUpdate = new DayOfWeekRideDate(monday);

        ride.setDate(rideDateUpdate);
        rideRepository.update(ride);

        assertEquals(rideRepository.find(ride.getId()).getDate(), rideDateUpdate);
    }

    @Test
    public void itShouldDeleteARide() {
        rideRepository.delete(ride.getId());

        assertEquals(rideRepository.getAll().size(), 0);
    }
}
