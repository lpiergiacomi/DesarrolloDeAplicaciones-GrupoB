package ar.edu.unq.desapp.grupob.model;

import ar.edu.unq.desapp.grupob.model.SpecificDayRideDate;
import org.joda.time.DateTime;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class SpecificDayRideDateTest {

    SpecificDayRideDate rideDate;
    DateTime aDay = new DateTime(2016, 3, 29, 12, 0);

    @Test
    public void itShouldAssertASpecificDayIsARideDay(){
        rideDate = new SpecificDayRideDate(aDay);

        assertTrue(rideDate.isRideDay(aDay));
    }

    @Test
    public void itShouldDenyASpecificDayIsARideDay(){
        DateTime anotherDay = new DateTime(2016, 5, 9, 12, 0);
        rideDate = new SpecificDayRideDate(aDay);

        assertFalse(rideDate.isRideDay(anotherDay));
    }
}

