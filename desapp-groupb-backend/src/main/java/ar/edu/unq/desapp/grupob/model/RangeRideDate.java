package ar.edu.unq.desapp.grupob.model;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType= DiscriminatorType.STRING)
@DiscriminatorValue(value="range")
public abstract class RangeRideDate extends RideDate {

    @Column(name= "from")
    protected DateTime from;
    @Column(name= "to")
    protected DateTime to;
    @Column(name= "rideDate")
    protected RideDate rideDate;

    public boolean isRideDay(DateTime day) {
        return day.isAfter(from) && day.isBefore(to) && rideDate.isRideDay(day);

    }
}
