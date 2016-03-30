package model;

import org.joda.time.DateTime;
import org.joda.time.MonthDay;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class DayOfMonthRideDateTest {

    DateTime tenthOfDecember = new DateTime(2016, 12, 10, 12, 0);

    @Test
    public void itShouldAssertADayOfMonthIsARideDay(){
        MonthDay dayOfMonth = new MonthDay(12, 10);
        DayOfMonthRideDate dayOfMonthRideDate = new DayOfMonthRideDate(dayOfMonth);

        assertTrue(dayOfMonthRideDate.isRideDay(tenthOfDecember));
    }

    @Test
    public void itShouldDenyADayOfMonthIsARideDay(){
        MonthDay tenthOfNovember = new MonthDay(11, 10);
        DayOfMonthRideDate dayOfMonthRideDate = new DayOfMonthRideDate(tenthOfNovember);

        assertFalse(dayOfMonthRideDate.isRideDay(this.tenthOfDecember));
    }
}
