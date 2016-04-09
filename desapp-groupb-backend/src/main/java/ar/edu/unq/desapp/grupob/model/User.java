package ar.edu.unq.desapp.grupob.model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private Vehicle vehicle;
	private boolean hasOneBadRate;
	public Role currentRole;
	public Driver driverRole;
	public Passenger passengerRole;
	public List<Message> messages;

	public User(){
		hasOneBadRate = false;
		driverRole = new Driver();
		passengerRole = new Passenger();
		currentRole = passengerRole;
		messages = new ArrayList<Message>();
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

	public void sendPublicMessageTo(User receiver, String message) {
		PublicMessage publicMessage = new PublicMessage(this, receiver, message);
        receiver.receiveMessage(publicMessage);
	}

    public void sendPrivateMessageTo(User receiver, String message) {
        PrivateMessage privateMessage = new PrivateMessage(this, receiver, message);
        receiver.receiveMessage(privateMessage);
    }

    public void receiveMessage(Message message){
        messages.add(message);
    }


	public List<Message> getMessages(){
		return messages;
	}

	public void acceptRequest(RideRequest rideRequest) throws Exception{
		this.handleRequest(rideRequest);
		rideRequest.accept();
	}

	public void rejectRequest(RideRequest rideRequest) throws Exception{
		this.handleRequest(rideRequest);
		rideRequest.reject();
	}

	private void handleRequest(RideRequest rideRequest) throws Exception {
		if(!getRideRequests().contains(rideRequest)){
			throw new Exception("This ride request does not belong to this user");
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