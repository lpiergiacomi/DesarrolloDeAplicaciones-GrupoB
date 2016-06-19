package ar.edu.unq.desapp.grupob.model;

import javax.persistence.Entity;
import org.joda.time.DateTime;

import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("range_dayofmonth")
public class RangeWithDayOfMonthRideDate extends RangeRideDate {

    public RangeWithDayOfMonthRideDate(DateTime from, DateTime to, DayOfMonthRideDate rideDate) {
        this.fromm= from;
        this.too = to;
        this.rideDate = rideDate;
    }

}
