package ar.edu.unq.desapp.grupob.model;

import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class RideTest {

    @Test
    public void testItShouldAssertTheRideIsCreatedWithUser(){
        User drive = mock(User.class);
        Route route = mock(Route.class);
        RideDate date = mock(RideDate.class);
        Ride ride = new Ride(drive, route, date);
        assertEquals(ride.getDrive(), drive);
        assertEquals(ride.getRoute(), route);
        assertEquals(ride.getDate(), date);
    }


}
