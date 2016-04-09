package ar.edu.unq.desapp.grupob.model;

import org.joda.time.DateTime;
import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class RideRequestTest {
    RideRequest rideRequest;
    RideDate rideDate;

    @Before
    public void setUp() throws Exception {
        Ride ride = mock(Ride.class);
        rideDate = mock(DayOfWeekRideDate.class);
        rideRequest = new RideRequest(mock(User.class), ride, rideDate);
    }

    @Test
    public void itShouldAssertTheRideRequestHasUserRequest(){
        assertNotNull(rideRequest.getUser());
    }

    @Test
    public void itShouldAssertTheRideRequestHasARequestDate(){
        assertEquals(rideRequest.getRequestDate().getDayOfYear(), DateTime.now().getDayOfYear());
    }

    @Test
    public void itShouldAssertTheRideRequestHasARequestRideDate(){
        assertNotNull(rideRequest.getRequestRideDate());
    }

    @Test
    public void itShouldAssertTheRideRequestHasRide(){
        assertNotNull(rideRequest.getRide());
    }

    @Test
    public void itShouldAssertTheInitialRideRequestIsPending(){
        assertTrue(rideRequest.isPending());
    }

    @Test
    public void itShouldAssertTheRideRequestIsAccepted(){
        rideRequest.accept();
        assertTrue(rideRequest.isAccepted());
    }

    @Test
    public void itShouldAssertTheRideRequestIsRejected(){
        rideRequest.reject();
        assertTrue(rideRequest.isRejected());
    }
}