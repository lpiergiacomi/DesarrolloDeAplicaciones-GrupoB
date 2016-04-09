package ar.edu.unq.desapp.grupob.model;

public class Ride {
    RideDate date;
    User drive;
    Route route;

    public Ride(User drive, Route route, RideDate date) {
        this.drive = drive;
        this.route = route;
        this.date = date;
    }

    public RideDate getDate() {
        return date;
    }

    public Route getRoute() {
        return route;
    }

    public User getDrive() {
        return drive;
    }
}