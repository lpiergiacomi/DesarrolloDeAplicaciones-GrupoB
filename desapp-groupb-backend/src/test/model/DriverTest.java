package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class DriverTest {

    public Driver driver;
    public Route route;
    public RideRequest rideRequest;

    @Before
    public void setUp(){
        driver = new Driver();
        route = mock(Route.class);
        rideRequest = mock(RideRequest.class);
    }

    @Test
    public void itShouldAssertItIsADriver(){
        assertTrue(driver.isDriver());
    }

    @Test
    public void itShouldDenyItIsAPassenger(){
        assertFalse(driver.isPassenger());
    }

    @Test
    public void itShouldBeAbleToAddARoute(){
        driver.addRoute(route);
        assertEquals(driver.getRoutes().size(), 1);
    }

    @Test
    public void itShouldBeAbleToAddARideRequestMadeByAPassenger(){
        driver.addRideRequest(rideRequest);
        assertEquals(driver.getRideRequests().size(), 1);
    }
}
