package ar.edu.unq.desapp.grupob.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Ride {
    RideDate date;
    User driver;
    Route route;
    Integer id;
    List<User> passengers;

    public Ride(User driver, Route route, RideDate date) {
        this.driver = driver;
        this.route = route;
        this.date = date;
        this.passengers = new ArrayList<>(this.driver.getCapacityVehicle());
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "Ride")
    public RideDate getDate() {
        return date;
    }

    public void setDate(RideDate date) {
        this.date = date;
    }

    @OneToOne
    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @OneToOne
    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    @ManyToMany
    public List<User> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<User> passengers) {
        this.passengers = passengers;
    }

    public void addPassenger(User passenger) {
        passengers.add(passenger);
    }

    @Transient
    public boolean isEfficient() {
        return (this.passengers.size()  / driver.getCapacityVehicle()) >= 0.5;
    }

}