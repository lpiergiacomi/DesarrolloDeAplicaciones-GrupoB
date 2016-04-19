package ar.edu.unq.desapp.grupob.model;

import org.joda.time.*;
import org.junit.*;
import static org.junit.Assert.*;

public class RangeWithDayOfWeekRideDateTest {

    RangeWithDayOfWeekRideDate rideDate;
    DayOfWeekRideDate dayOfWeekRideDate;
    DateTime from = new DateTime(2016, 3, 29, 12, 0);
    DateTime to = new DateTime(2016, 4, 29, 12, 0);

    @Before
    public void setUp() {
        int tuesday = DateTimeConstants.TUESDAY;
        dayOfWeekRideDate = new DayOfWeekRideDate(tuesday);
        rideDate = new RangeWithDayOfWeekRideDate(from, to, dayOfWeekRideDate);
    }

    @Test
    public void itShouldAssertADayOfWeekIsInsideTheRideDatesRange() {
        DateTime aTuesday = new DateTime(2016, 4, 5, 12, 0);

        assertTrue(rideDate.isRideDay(aTuesday));
    }

    @Test
    public void itShouldDenyADayOfWeekIsInsideTheRideDatesRange() {
        DateTime outOfRangeDay = new DateTime(2015, 5, 9, 12, 0);
        rideDate = new RangeWithDayOfWeekRideDate(from, to, dayOfWeekRideDate);

        assertFalse(rideDate.isRideDay(outOfRangeDay));
    }

    @Test
    public void itShouldDenyADayOfWeekIsARideDayDespiteBeingInsideTheRideDatesRange() {
        DateTime aWednesday = new DateTime(2016, 4, 13, 12, 0);
        rideDate = new RangeWithDayOfWeekRideDate(from, to, dayOfWeekRideDate);

        assertFalse(rideDate.isRideDay(aWednesday));
    }
}