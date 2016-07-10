package ar.edu.unq.desapp.grupob.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Role {

    private int goodRate;
    private int badRate;
    private boolean hasOneBadRate;
    private List<RideRequest> rideRequests = new ArrayList<RideRequest>();
    private List<Ride> rides = new ArrayList<Ride>();
    private Integer id;

    public Role() {
        goodRate = 0;
        badRate = 0;
        hasOneBadRate = false;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGoodRate() {
        return goodRate;
    }

    public void setGoodRate(int goodRate) {
        this.goodRate = goodRate;
    }

    public int getBadRate() {
        return badRate;
    }

    public void setBadRate(int badRate) {
        this.badRate = badRate;
    }

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<RideRequest> getRideRequests() {
        return rideRequests;
    }

    public void setRideRequests(List<RideRequest> rideRequests) {
        this.rideRequests = rideRequests;
    }

    public void addRideRequest(RideRequest rideRequest) {
        rideRequests.add(rideRequest);
    }

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonBackReference
    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }

    public void addRide(Ride ride) {
        rides.add(ride);
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
