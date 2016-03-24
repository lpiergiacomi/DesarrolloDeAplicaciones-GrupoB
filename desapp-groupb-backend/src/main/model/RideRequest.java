package model;

import org.joda.time.DateTime;

public class RideRequest {
    private User user;
    private DateTime requestDate;
    private Ride ride;
    private static String ACCEPTED = "accepted";
    private static String REJECTED = "rejected";
    private static String PENDING = "pending";
    private String status;

    public RideRequest(){
        status = PENDING;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRequestDate(DateTime requestDate) {
        this.requestDate = requestDate;
    }

    public DateTime getRequestDate() {
        return requestDate;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
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
