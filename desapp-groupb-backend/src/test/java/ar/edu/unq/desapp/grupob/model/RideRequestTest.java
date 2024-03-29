package ar.edu.unq.desapp.grupob.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Date;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class RideRequestTest {

    private RideRequest rideRequest;
    private RideDate rideDate;
    private Ride ride;

    @Before
    public void setUp() throws Exception {
        ride = mock(Ride.class);
        rideDate = mock(DayOfWeekRideDate.class);
        rideRequest = new RideRequest(mock(User.class), ride, rideDate);
    }

    @Test
    public void itShouldAssertTheRideRequestHasUserRequest() {
        assertNotNull(rideRequest.getUser());
    }

    @Test
    public void itShouldAssertTheRideRequestHasARequestDate() {
        assertEquals(rideRequest.getRequestDate().getDay(),
                new Date(Calendar.getInstance().getTime().getTime()).getDay());
    }

    @Test
    public void itShouldAssertTheRideRequestHasARequestRideDate() {
        assertNotNull(rideRequest.getRequestRideDate());
    }

    @Test
    public void itShouldAssertTheRideRequestHasRide() {
        assertNotNull(rideRequest.getRide());
    }

    @Test
    public void itShouldAssertTheInitialRideRequestIsPending() {
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
