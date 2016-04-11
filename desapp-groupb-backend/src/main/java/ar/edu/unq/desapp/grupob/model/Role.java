package ar.edu.unq.desapp.grupob.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Role {

    private int goodRate;
    private int badRate;
    private boolean hasOneBadRate;
    private List<RideRequest> rideRequests = new ArrayList<RideRequest>();

    public Role(){
        goodRate = 0;
        badRate = 0;
        hasOneBadRate = false;
    }

    public abstract boolean isPassenger();

    public abstract boolean isDriver();

    public int getGoodRate(){
        return goodRate;
    }

    public int getBadRate(){
        return badRate;
    }

    public List<RideRequest> getRideRequests(){
        return rideRequests;
    }

    public void addRideRequest(RideRequest rideRequest){
        rideRequests.add(rideRequest);
    }

    public int receiveGoodRate() {
        goodRate += 1;
        return 500;
    }

    public int receiveBadRate() {
        badRate += 1;
        if (hasOneBadRate) {
            hasOneBadRate = false;
            return 1000;
        } else {
            hasOneBadRate = true;
            return 0;
        }
    }
}
