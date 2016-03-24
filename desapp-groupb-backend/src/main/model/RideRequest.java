package model;

import org.joda.time.DateTime;

public class RideRequest {
    private User userCreated;
    private DateTime requestDate;
    private Ride ride;
    private boolean status;


    public User getUserCreated(){
        return userCreated;
    }

    public void setUserCreated(User userCreated) {
        this.userCreated = userCreated;
    }

    public void setRequestDate(DateTime requestDate) {
        this.requestDate = requestDate;
    }

    public DateTime getRequestDate() {
        return requestDate;
    }

    public int getHour() {
        return requestDate.getHourOfDay();
    }

    public int getDay() {
        return requestDate.getDayOfMonth();
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public Ride getRide() {
        return ride;
    }

    public void accept() {
        status = true;
    }

    public boolean getStatus() {
        return status;
    }

    public void reject() {
        status = false;
    }
}
