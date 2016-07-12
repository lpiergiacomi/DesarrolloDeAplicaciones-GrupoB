package ar.edu.unq.desapp.grupob.model;

import org.joda.time.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class DayOfMonthRideDateTest {

    private DateTime tenthOfDecember = new DateTime(2016, 12, 10, 12, 0);

    @Test
    public void itShouldAssertADayOfMonthIsARideDay() {
        MonthDay dayOfMonth = new MonthDay(12, 10);
        DayOfMonthRideDate dayOfMonthRideDate = new DayOfMonthRideDate(
                dayOfMonth);

        assertTrue(dayOfMonthRideDate.isRideDay(tenthOfDecember));
    }

    @Test
    public void itShouldDenyADayOfMonthIsARideDay() {
        MonthDay tenthOfNovember = new MonthDay(11, 10);
        DayOfMonthRideDate dayOfMonthRideDate = new DayOfMonthRideDate(
                tenthOfNovember);

        assertFalse(dayOfMonthRideDate.isRideDay(this.tenthOfDecember));
    }
}
