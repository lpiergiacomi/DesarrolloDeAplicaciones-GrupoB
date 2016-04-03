package ar.edu.unq.desapp.grupob.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Role {

    private int rate;
    private boolean hasOneBadRate;
    private List<RideRequest> rideRequests = new ArrayList<RideRequest>();

    public Role(){
        rate = 0;
        hasOneBadRate = false;
    }

    public abstract boolean isPassenger();

    public abstract boolean isDriver();

    public int getRate(){
        return rate;
    }

    public List<RideRequest> getRideRequests(){
        return rideRequests;
    }

    public void addRideRequest(RideRequest rideRequest){
        rideRequests.add(rideRequest);
    }

    public void receiveGoodRate() {
        rate += 500;
    }

    public void receiveBadRate() {
        if (hasOneBadRate) {
            rate -= 1000;
        } else {
            hasOneBadRate = true;
        }
    }
}
