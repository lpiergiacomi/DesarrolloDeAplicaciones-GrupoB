package ar.edu.unq.desapp.grupob.model;

import org.joda.time.DateTime;

public abstract class RangeRideDate extends RideDate {

    protected DateTime from;
    protected DateTime to;
    protected RideDate rideDate;

    public boolean isRideDay(DateTime day) {
        return day.isAfter(from) && day.isBefore(to) && rideDate.isRideDay(day);

    }
}
