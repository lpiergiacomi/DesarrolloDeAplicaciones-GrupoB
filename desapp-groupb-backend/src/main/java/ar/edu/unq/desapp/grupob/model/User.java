package ar.edu.unq.desapp.grupob.model;

import java.util.List;

import ar.edu.unq.desapp.grupob.model.exceptions.RideRequestException;

public class User {

	private Vehicle vehicle;
	private boolean hasOneBadRate;
	public Role currentRole;
	public Driver driverRole;
	public Passenger passengerRole;

	public User(){
		hasOneBadRate = false;
		driverRole = new Driver();
		passengerRole = new Passenger();
		currentRole = passengerRole;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<Route> getRoutes(){
		return driverRole.getRoutes();
	}

	public List<RideRequest> getRideRequests(){
		return currentRole.getRideRequests();
	}

	public int getRate(){
		return currentRole.getRate();
	}

	public boolean hasVehicle() {
		return vehicle != null;
	}

	public void addRoute(Route route){
		driverRole.addRoute(route);
	}

	public void addRideRequest(RideRequest rideRequest){
		currentRole.addRideRequest(rideRequest);
	}

	public void acceptRequest(RideRequest rideRequest) throws RideRequestException{
		this.handleRequest(rideRequest);
		rideRequest.accept();
	}

	public void rejectRequest(RideRequest rideRequest) throws RideRequestException{
		this.handleRequest(rideRequest);
		rideRequest.reject();
	}

	private void handleRequest(RideRequest rideRequest) throws RideRequestException {
		if(!getRideRequests().contains(rideRequest)){
			throw new RideRequestException("This ride request does not belong to this user");
		}
	}

	public void giveGoodRate(User user) {
		user.receiveGoodRate();
	}

	public void giveBadRate(User user) {
		user.receiveBadRate();
	}

	public void receiveGoodRate() {
		currentRole.receiveGoodRate();
	}

	public void receiveBadRate(){
		currentRole.receiveBadRate();
	}

	public boolean isPassengerRoleActivated() {
		return currentRole.isPassenger();
	}

	public boolean isDriverRoleActivated() {
		return currentRole.isDriver();
	}

	public void switchToDriver(){
		currentRole = driverRole;
	}

	public void switchToPassenger(){
		currentRole = passengerRole;
	}
}