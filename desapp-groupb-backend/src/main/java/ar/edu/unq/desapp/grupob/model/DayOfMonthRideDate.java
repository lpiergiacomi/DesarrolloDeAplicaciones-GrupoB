package ar.edu.unq.desapp.grupob.model;

import org.joda.time.DateTime;
import org.joda.time.MonthDay;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("dayofmonth")
public class DayOfMonthRideDate extends RideDate {

    @Column(name= "monthDay", length = 500)
    private MonthDay monthDay;

    public DayOfMonthRideDate(MonthDay monthDay){
        this.monthDay = monthDay;
    }

    public boolean isRideDay(DateTime dateTime) {
        return dateTime.getDayOfMonth() == monthDay.getDayOfMonth()
                && dateTime.monthOfYear().get() == monthDay.monthOfYear().get();
    }
}
