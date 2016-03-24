package model;

import org.joda.time.DateTime;

public class Ride {
    DateTime date;
    User drive;
    Route route;

    public Ride(User drive, Route route, DateTime date) {
        this.drive = drive;
        this.route = route;
        this.date = date;
    }

    public DateTime getDate() {
        return date;
    }

    public Route getRoute() {
        return route;
    }

    public User getDrive() {
        return drive;
    }
}