package ar.edu.unq.desapp.grupob.model;

import org.joda.time.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class DayOfWeekRideDateTest {

    private DayOfWeekRideDate rideDate;
    private DateTime aTuesday = new DateTime(2016, 3, 29, 12, 0);

    @Test
    public void itShouldAssertAWeekDayIsARideDay() {
        int tuesday = DateTimeConstants.TUESDAY;
        rideDate = new DayOfWeekRideDate(tuesday);

        assertTrue(rideDate.isRideDay(aTuesday));
    }

    @Test
    public void itShouldDenyAWeekDayIsARideDay() {
        int wednesday = DateTimeConstants.WEDNESDAY;
        rideDate = new DayOfWeekRideDate(wednesday);

        assertFalse(rideDate.isRideDay(aTuesday));
    }
}
