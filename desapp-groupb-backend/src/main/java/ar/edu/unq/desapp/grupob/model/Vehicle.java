package ar.edu.unq.desapp.grupob.model;

public class Vehicle {

    private int capacity, rate;
    private double costPerKm;

    public Vehicle(int capacity, double costPerKm) {
        this.capacity = capacity;
        this.rate = 0;
        this.costPerKm = costPerKm;
    }

    public int getCapacity() {
        return capacity;
    }

    public void receiveGoodRate() {
        rate += 1;
    }

    public void receiveBadRate() {
        rate -= 1;
    }

    public int getRate() {
        return rate;
    }

    public double getTotalCost(Double kilometres) {
        return costPerKm * kilometres;
    }
}
