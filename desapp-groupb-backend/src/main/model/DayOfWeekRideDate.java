package model;

import org.joda.time.DateTime;

public class DayOfWeekRideDate {

    private int day;

    public DayOfWeekRideDate(int day){
        this.day = day;
    }

    public boolean isRideDay(DateTime dateTime){
        return dateTime.dayOfWeek().get() == day;
    }
}
