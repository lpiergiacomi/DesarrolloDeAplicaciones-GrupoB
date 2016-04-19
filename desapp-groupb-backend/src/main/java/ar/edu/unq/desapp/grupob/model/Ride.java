package ar.edu.unq.desapp.grupob.model;

import java.util.ArrayList;
import java.util.List;

public class Ride {
    RideDate date;
    User driver;
    Route route;
    List<User> passengers;

    public Ride(User driver, Route route, RideDate date) {
        this.driver = driver;
        this.route = route;
        this.date = date;
        this.passengers = new ArrayList<>(this.driver.getCapacityVehicle());
    }

    public RideDate getDate() {
        return date;
    }

    public Route getRoute() {
        return route;
    }

    public User getDriver() {
        return driver;
    }

    public void addPassenger(User passenger) {
        passengers.add(passenger);
    }

    public List<User> getPassengers() {
        return passengers;
    }

    public boolean isEfficient() {
        return (this.passengers.size()  / driver.getCapacityVehicle()) >= 0.5;
    }
}