package model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

    public User user;
    public Vehicle vehicle;

    @Before
    public void setUp() {
        user = new User();
        vehicle = mock(Vehicle.class);
    }

    @Test
    public void itShouldAssertTheUserHasAVehicle() {
        user.setVehicle(vehicle);
        assertTrue(user.hasVehicle());
    }

    @Test
    public void itShouldDenyTheUserHasAVehicle() {
        assertFalse(user.hasVehicle());
    }

    @Test
    public void itShouldGetTheUsersRoutes() {
        Route route = mock(Route.class);
        user.addRoute(route);
        assertEquals(user.getRoutes().size(), 1);
    }

    @Test
    public void itShouldSendARequestForJoiningADriversRide() {
        RideRequest rideRequest = mock(RideRequest.class);
        user.addRideRequest(rideRequest);
        assertEquals(user.getRideRequests().size(), 1);
    }

}
