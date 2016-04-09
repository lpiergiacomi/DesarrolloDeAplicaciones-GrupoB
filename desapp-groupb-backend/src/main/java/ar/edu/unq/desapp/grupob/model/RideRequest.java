package ar.edu.unq.desapp.grupob.model;

import org.joda.time.DateTime;

public class RideRequest {
    private User user;
    private RideDate requestRideDate;
    private DateTime requestDate;
    private Ride ride;
    private static String ACCEPTED = "accepted";
    private static String REJECTED = "rejected";
    private static String PENDING = "pending";
    private String status;

    public RideRequest(User user, Ride ride, RideDate requestRideDate) throws Exception {
        this.user = user;
        this.ride = ride;
        this.requestDate = DateTime.now();
        this.requestRideDate = requestRideDate;
        status = PENDING;
    }

    public User getUser(){
        return user;
    }

    public RideDate getRequestRideDate() {
        return requestRideDate;
    }

    public DateTime getRequestDate(){
        return requestDate;
    }

    public Ride getRide() {
        return ride;
    }

    public void accept() {
        status = ACCEPTED;
    }

    public void reject() {
        status = REJECTED;
    }

    public boolean isAccepted() {
        return status.equals(ACCEPTED);
    }

    public boolean isRejected() {
        return status.equals(REJECTED);
    }

    public boolean isPending() {
        return status.equals(PENDING);
    }
}
