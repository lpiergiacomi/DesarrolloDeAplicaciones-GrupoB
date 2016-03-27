package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class PassengerTest {

    public Passenger passenger;
    public Route route;
    public RideRequest rideRequest;

    @Before
    public void setUp(){
        passenger = new Passenger();
        route = mock(Route.class);
        rideRequest = mock(RideRequest.class);
    }

    @Test
    public void itShouldDenyItIsADriver(){
        assertFalse(passenger.isDriver());
    }

    @Test
    public void itShouldAssertItIsAPassenger(){
        assertTrue(passenger.isPassenger());
    }

    @Test
    public void itShouldBeAbleToAddARideRequestMadeByIt(){
        passenger.addRideRequest(rideRequest);
        assertEquals(passenger.getRideRequests().size(), 1);
    }
}
