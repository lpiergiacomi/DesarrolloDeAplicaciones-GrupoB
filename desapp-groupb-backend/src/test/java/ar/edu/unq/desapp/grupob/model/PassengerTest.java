package ar.edu.unq.desapp.grupob.model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.desapp.grupob.model.exceptions.RouteException;

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
    public void itShouldBeAbleToAddARideRequestMadeByIt() {
        passenger.addRideRequest(rideRequest);
        assertEquals(passenger.getRideRequests().size(), 1);
    }

    @Test(expected = RouteException.class)
    public void itShouldntBeAbleToAddARoute() throws RouteException {
        passenger.addRoute(route);
    }

}