package ar.edu.unq.desapp.grupob.model;

import javax.persistence.*;

@Entity
@Table
public class Vehicle {

    private int capacity, rate, id;
    private double costPerKm;

    public Vehicle(){}

    public Vehicle(int capacity, double costPerKm) {
        this.capacity = capacity;
        this.rate = 0;
        this.costPerKm = costPerKm;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void receiveGoodRate() {
        rate += 1;
    }

    public void receiveBadRate() {
        rate -= 1;
    }

    @Column(name = "rate", nullable = false, columnDefinition = "int default 0")
    public int getRate() {
        return rate;
    }

    public double getTotalCost(Double kilometres) {
        return costPerKm * kilometres;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public double getCostPerKm() {
        return costPerKm;
    }

    public void setCostPerKm(double costPerKm) {
        this.costPerKm = costPerKm;
    }

}
