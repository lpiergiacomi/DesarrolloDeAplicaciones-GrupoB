package ar.edu.unq.desapp.grupob.model;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="ridedate")
public abstract class RideDate {

    @Id
    @GeneratedValue
    private Integer id;

    @Transient
    public abstract boolean isRideDay(DateTime dateTime);

    public void setId(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
