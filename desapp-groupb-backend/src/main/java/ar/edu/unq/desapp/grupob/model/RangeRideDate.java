package ar.edu.unq.desapp.grupob.model;

import org.joda.time.DateTime;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType= DiscriminatorType.STRING)
@DiscriminatorValue(value="range")
public abstract class RangeRideDate extends RideDate {

    @Column(name= "fromm", length = 500)
    protected DateTime fromm;
    @Column(name= "too", length = 500)
    protected DateTime too;
    @OneToOne
    protected RideDate rideDate;

    public boolean isRideDay(DateTime day) {
        return day.isAfter(fromm) && day.isBefore(too) && rideDate.isRideDay(day);

    }

    public DateTime getFromm() {
        return fromm;
    }
    public void setFromm(DateTime fromm) {
        this.fromm = fromm;
    }
    public DateTime getToo() {
        return too;
    }
    public void setToo(DateTime too) {
        this.too = too;
    }
    public RideDate getRideDate() {
        return rideDate;
    }
    public void setRideDate(RideDate rideDate) {
        this.rideDate = rideDate;
  }
}
