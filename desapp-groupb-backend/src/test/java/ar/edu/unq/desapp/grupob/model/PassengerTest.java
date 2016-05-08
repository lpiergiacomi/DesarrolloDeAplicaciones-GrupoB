package ar.edu.unq.desapp.grupob.model;

import ar.edu.unq.desapp.grupob.model.exceptions.RouteException;
import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class PassengerTest {

    public Passenger passenger;
    public Route route;
    public RideRequest rideRequest;

    @Before
    public void setUp() {
        passenger = new Passenger();
        route = mock(Route.class);
        rideRequest = mock(RideRequest.class);
    }

    @Test
    public void itShouldDenyItIsADriver(){
        assertFalse(passenger.driver());
    }

    @Test
    public void itShouldAssertItIsAPassenger(){
        assertTrue(passenger.passenger());
    }

    @Test
    public void itShouldBeAbleToAddARideRequestMadeByIt() {
        passenger.addRideRequest(rideRequest);
        assertEquals(passenger.getRideRequests().size(), 1);
    }

    @Test(expected = RouteException.class)
    public void itShouldntBeAbleToAddARoute() throws RouteException {
        passenger.addRoute(route);
    }

}
