package ar.edu.unq.desapp.grupob.model;

import org.hibernate.annotations.Entity;
import org.joda.time.DateTime;

import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("dayofmonth")
public class RangeWithDayOfMonthRideDate extends RangeRideDate {

    public RangeWithDayOfMonthRideDate(DateTime from, DateTime to, DayOfMonthRideDate rideDate) {
        this.from= from;
        this.to = to;
        this.rideDate = rideDate;
    }

}
