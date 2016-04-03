package ar.edu.unq.desapp.grupob.model;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class RideRequestTest {
    RideRequest rideRequest;

    @Before
    public void setUp(){
        rideRequest = new RideRequest();
    }

    @Test
    public void itShouldAssertTheRideRequestHasUserRequest(){
        User user = mock(User.class);
        rideRequest.setUser(user);
        assertEquals(rideRequest.getUser(), user);
    }

    @Test
    public void itShouldAssertTheRideRequestHasInitialDate(){
        DateTime requestDate = new DateTime(2016, 4, 25, 12, 0);
        rideRequest.setRequestDate(requestDate);
        assertEquals(rideRequest.getRequestDate(), requestDate);
    }

    @Test
    public void itShouldAssertTheRideRequestHasRide(){
        Ride ride = mock(Ride.class);
        rideRequest.setRide(ride);
        assertEquals(rideRequest.getRide(), ride);
    }

    @Test
    public void itShouldAssertTheInitialRideRequestIsPending(){
        assertTrue(rideRequest.isPending());
    }

    @Test
    public void itShouldAssertTheRideRequestIsAccept(){
        rideRequest.accept();
        assertTrue(rideRequest.isAccepted());
    }

    @Test
    public void itShouldAssertTheRideRequestIsReject(){
        rideRequest.reject();
        assertTrue(rideRequest.isRejected());
    }
}
