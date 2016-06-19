package ar.edu.unq.desapp.grupob.model;

import org.joda.time.DateTime;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("range_dayofweek")
public class RangeWithDayOfWeekRideDate extends RangeRideDate {

    public RangeWithDayOfWeekRideDate(DateTime from, DateTime to, DayOfWeekRideDate rideDate) {
        this.fromm= from;
        this.too = to;
        this.rideDate = rideDate;
    }

}

