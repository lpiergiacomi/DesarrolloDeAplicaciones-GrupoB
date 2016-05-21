package ar.edu.unq.desapp.grupob.model;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table
public class RideRequest {
    private User user;
    private RideDate requestRideDate;
    private DateTime requestDate;
    private Ride ride;
    private static String ACCEPTED = "accepted";
    private static String REJECTED = "rejected";
    private static String PENDING = "pending";
    private String status;
    private Integer id;

    public RideRequest(User user, Ride ride, RideDate requestRideDate) {
        this.user = user;
        this.ride = ride;
        this.requestDate = DateTime.now();
        this.requestRideDate = requestRideDate;
        this.status = PENDING;
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
    public User getUser(){
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @OneToOne
    public RideDate getRequestRideDate() {
        return requestRideDate;
    }

    public void setRequestRideDate(RideDate requestRideDate) {
        this.requestRideDate = requestRideDate;
    }

    public DateTime getRequestDate(){
        return requestDate;
    }

    public void setRequestDate(DateTime requestDate) {
        this.requestDate = requestDate;
    }

    @ManyToOne
    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public void accept() {
        status = ACCEPTED;
        ride.addPassenger(user);
        user.addRide(ride);
    }

    public void reject() {
        status = REJECTED;
    }

    @Transient
    public boolean isAccepted() {
        return status.equals(ACCEPTED);
    }

    @Transient
    public boolean isRejected() {
        return status.equals(REJECTED);
    }

    @Transient
    public boolean isPending() {
        return status.equals(PENDING);
    }

}
