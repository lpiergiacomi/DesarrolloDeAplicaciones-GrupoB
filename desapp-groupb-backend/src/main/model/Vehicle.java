package model;

public class Vehicle {

	private int capacity, rate;
	
	public Vehicle(int capacity){
		this.capacity = capacity;
		rate = 0;
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
}
