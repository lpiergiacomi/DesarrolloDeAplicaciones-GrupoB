package ar.edu.unq.desapp.grupob.model;

import javax.persistence.*;

@Entity
@Table
public class Ride {
    RideDate date;
    User drive;
    Route route;
    Integer id;

    public Ride(User drive, Route route, RideDate date) {
        this.drive = drive;
        this.route = route;
        this.date = date;
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
    public User getDrive() {
        return drive;
    }

    public void setDrive(User drive) {
        this.drive = drive;
    }
}