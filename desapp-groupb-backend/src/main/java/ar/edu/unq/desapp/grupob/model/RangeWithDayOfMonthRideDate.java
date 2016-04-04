package ar.edu.unq.desapp.grupob.model;

import org.joda.time.DateTime;

public class RangeWithDayOfMonthRideDate extends RangeRideDate {

    public RangeWithDayOfMonthRideDate(DateTime from, DateTime to, DayOfMonthRideDate rideDate) {
        this.from= from;
        this.to = to;
        this.rideDate = rideDate;
    }

}