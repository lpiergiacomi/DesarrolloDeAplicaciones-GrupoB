package model;

import org.joda.time.DateTime;
import org.joda.time.MonthDay;

public class DayOfMonthRideDate {

    private MonthDay monthDay;

    public DayOfMonthRideDate(MonthDay monthDay){
        this.monthDay = monthDay;
    }

    public boolean isRideDay(DateTime dateTime) {
        return dateTime.getDayOfMonth() == monthDay.getDayOfMonth()
                && dateTime.monthOfYear().get() == monthDay.monthOfYear().get();
    }
}
