package ar.edu.unq.desapp.grupob.model;

import org.joda.time.DateTime;

public class SpecificDayRideDate extends RangeRideDate {

    private DateTime specificDay;

    public SpecificDayRideDate(DateTime day) {
        this.specificDay = day;
    }

    public boolean isRideDay(DateTime day) {
        return day.getDayOfMonth() == specificDay.getDayOfMonth()
                && day.monthOfYear().get() == specificDay.monthOfYear().get()
                && day.getYear() == specificDay.getYear();

    }
}
