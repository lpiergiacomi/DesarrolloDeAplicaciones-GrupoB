package ar.edu.unq.desapp.grupob.model;

import org.joda.time.DateTime;
import org.joda.time.MonthDay;

import javax.persistence.Entity;

@Entity
public class DayOfMonthRideDate extends RideDate {

    private MonthDay monthDay;

    public DayOfMonthRideDate(MonthDay monthDay){
        this.monthDay = monthDay;
    }

    public boolean isRideDay(DateTime dateTime) {
        return dateTime.getDayOfMonth() == monthDay.getDayOfMonth()
                && dateTime.monthOfYear().get() == monthDay.monthOfYear().get();
    }
}
