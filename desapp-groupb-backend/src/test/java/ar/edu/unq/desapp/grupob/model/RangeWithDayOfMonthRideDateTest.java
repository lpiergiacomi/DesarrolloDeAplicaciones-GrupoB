package ar.edu.unq.desapp.grupob.model;

import ar.edu.unq.desapp.grupob.model.DayOfMonthRideDate;
import ar.edu.unq.desapp.grupob.model.RangeWithDayOfMonthRideDate;
import org.joda.time.DateTime;
import org.joda.time.MonthDay;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class RangeWithDayOfMonthRideDateTest {

    RangeWithDayOfMonthRideDate rideDate;
    DayOfMonthRideDate dayOfMonthRideDate;
    DateTime from = new DateTime(2016, 3, 29, 12, 0);
    DateTime to = new DateTime(2018, 3, 29, 12, 0);

    @Before
    public void setUp(){
        MonthDay fifthOfMay = new MonthDay(5, 5);
        dayOfMonthRideDate = new DayOfMonthRideDate(fifthOfMay);
        rideDate = new RangeWithDayOfMonthRideDate(from, to, dayOfMonthRideDate);
    }

    @Test
    public void itShouldAssertADayOfMonthIsInsideTheRideDatesRange(){
        DateTime aFifthOfMay = new DateTime(2016, 5, 5, 12, 0);

        assertTrue(rideDate.isRideDay(aFifthOfMay));
    }

    @Test
    public void itShouldDenyADayOfWeekIsInsideTheRideDatesRange(){
        DateTime outOfRangeDay = new DateTime(2015, 5, 5, 12, 0);
        rideDate = new RangeWithDayOfMonthRideDate(from, to, dayOfMonthRideDate);

        assertFalse(rideDate.isRideDay(outOfRangeDay));
    }

    @Test
    public void itShouldDenyADayOfWeekIsARideDayDespiteBeingInsideTheRideDatesRange(){
        DateTime aSixthOfMay = new DateTime(2016, 5, 6, 12, 0);
        rideDate = new RangeWithDayOfMonthRideDate(from, to, dayOfMonthRideDate);

        assertFalse(rideDate.isRideDay(aSixthOfMay));
    }
}