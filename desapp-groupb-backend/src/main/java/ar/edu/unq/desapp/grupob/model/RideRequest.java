package ar.edu.unq.desapp.grupob.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;

@Entity
@Table
public class RideRequest {

    private static String ACCEPTED = "accepted";
    private static String REJECTED = "rejected";
    private static String PENDING = "pending";

    private User user;
    private RideDate requestRideDate;
    private Date requestDate;
    private Ride ride;
    private String status;
    private Integer id;

    public RideRequest(){}

    public RideRequest(User user, Ride ride, RideDate requestRideDate) {
        this.user = user;
        this.ride = ride;
        this.requestDate = new Date(Calendar.getInstance().getTime().getTime());
        this.requestRideDate = requestRideDate;
        this.status = PENDING;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
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

    public Date getRequestDate(){
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
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
