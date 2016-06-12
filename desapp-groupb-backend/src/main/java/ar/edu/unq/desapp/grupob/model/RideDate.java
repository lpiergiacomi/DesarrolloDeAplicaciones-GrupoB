package ar.edu.unq.desapp.grupob.model;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="ridedate")
public abstract class RideDate {

    private Integer id;

    @Transient
    public abstract boolean isRideDay(DateTime dateTime);

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
