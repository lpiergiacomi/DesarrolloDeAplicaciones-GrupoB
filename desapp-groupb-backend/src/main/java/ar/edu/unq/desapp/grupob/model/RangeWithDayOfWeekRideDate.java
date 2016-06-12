package ar.edu.unq.desapp.grupob.model;

import org.hibernate.annotations.Entity;
import org.joda.time.DateTime;

import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("dayofweek")
public class RangeWithDayOfWeekRideDate extends RangeRideDate {

    public RangeWithDayOfWeekRideDate(DateTime from, DateTime to, DayOfWeekRideDate rideDate) {
        this.from= from;
        this.to = to;
        this.rideDate = rideDate;
    }

}

