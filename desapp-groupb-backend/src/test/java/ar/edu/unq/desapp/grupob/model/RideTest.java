package ar.edu.unq.desapp.grupob.model;

import org.junit.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RideTest {

    private User drive;
    private Route route;
    private RideDate date;
    private Ride ride;

    @Before
    public void setUp() {
        drive = mock(User.class);
        when(drive.getCapacityVehicle()).thenReturn(1);
        route = mock(Route.class);
        date = mock(RideDate.class);
        ride = new Ride(drive, route, date);
    }

    @Test
    public void itShouldAssertTheRideIsCreatedWithUser() {
        assertEquals(ride.getDriver(), drive);
        assertEquals(ride.getRoute(), route);
        assertEquals(ride.getDate(), date);
        assertNotNull(ride.getPassengers());
    }

    @Test
    public void itShouldAddPassengerUser() {
        User passenger = mock(User.class);
        ride.addPassenger(passenger);
        assertEquals(ride.getPassengers().size(), 1);
    }

    @Test
    public void itShouldAssertTheRideWasEfficient() {
        User passenger = mock(User.class);
        ride.addPassenger(passenger);
        assertTrue(ride.isEfficient());
    }

    @Test
    public void itShouldDenyTheRideWasEfficient() {
        assertFalse(ride.isEfficient());
    }
}