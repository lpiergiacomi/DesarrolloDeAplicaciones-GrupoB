package ar.edu.unq.desapp.grupob.model;

import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("dayofweek")
public class DayOfWeekRideDate extends RideDate {

    @Column(name= "dai")
    private int dai;

    public DayOfWeekRideDate(int dai){
        this.dai = dai;
    }

    @Transient
    public boolean isRideDay(DateTime dateTime){
        return dateTime.dayOfWeek().get() == dai;
    }

    public int getDai() {
      return dai;
    }

    public void setDai(int dai) {
      this.dai = dai;
    }
}
