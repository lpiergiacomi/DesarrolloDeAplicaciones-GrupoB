package ar.edu.unq.desapp.grupob.model;

import org.joda.time.DateTime;
import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class RideRequestTest {
    RideRequest rideRequest;
    RideDate rideDate;
    Ride ride;

    @Before
    public void setUp() throws Exception {
        ride = mock(Ride.class);
        rideDate = mock(DayOfWeekRideDate.class);
        rideRequest = new RideRequest(mock(User.class), ride, rideDate);
    }

    @Test
    public void itShouldAssertTheRideRequestHasUserRequest(){
        assertNotNull(rideRequest.getUser());
    }

    @Test
    public void itShouldAssertTheRideRequestHasARequestDate() {
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
    public void itShouldAssertTheRideRequestIsAccepted() {
        rideRequest.accept();
        assertTrue(rideRequest.isAccepted());
        verify(ride, times(1)).addPassenger(any(User.class));
    }

    @Test
    public void itShouldAssertTheRideRequestIsRejected() {
        rideRequest.reject();
        assertTrue(rideRequest.isRejected());
        verify(ride, times(0)).addPassenger(any(User.class));
    }
}