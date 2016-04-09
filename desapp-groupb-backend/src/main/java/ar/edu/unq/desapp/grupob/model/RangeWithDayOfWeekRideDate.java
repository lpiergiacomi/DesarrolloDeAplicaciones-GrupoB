package ar.edu.unq.desapp.grupob.model;

import org.joda.time.DateTime;

public class RangeWithDayOfWeekRideDate extends RangeRideDate {

    public RangeWithDayOfWeekRideDate(DateTime from, DateTime to, DayOfWeekRideDate rideDate) {
        this.from= from;
        this.to = to;
        this.rideDate = rideDate;
    }

}

