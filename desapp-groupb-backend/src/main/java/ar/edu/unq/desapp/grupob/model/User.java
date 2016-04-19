package ar.edu.unq.desapp.grupob.model;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupob.model.exceptions.RideRequestException;

public class User {

	private Vehicle vehicle;
	private Role currentRole;
	private Driver driverRole;
	private Passenger passengerRole;
    private int points;
	private List<Message> messages;

	public User(){
		driverRole = new Driver();
		passengerRole = new Passenger();
		currentRole = passengerRole;
        points = 0;
		messages = new ArrayList<>();
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

    public int getCapacityVehicle() {
        return vehicle.getCapacity();
    }

	public List<Route> getRoutes(){
		return driverRole.getRoutes();
	}

	public List<RideRequest> getRideRequests(){
		return currentRole.getRideRequests();
	}

	public int getGoodRate(){
		return currentRole.getGoodRate();
	}

	public int getBadRate(){
		return currentRole.getBadRate();
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

	public void acceptRequest(RideRequest rideRequest) throws RideRequestException {
		this.handleRequest(rideRequest);
		rideRequest.accept();
	}

	public void rejectRequest(RideRequest rideRequest) throws RideRequestException {
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
		points += currentRole.receiveGoodRate();
	}

	public void receiveBadRate(){
		points -= currentRole.receiveBadRate();
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

    public int getPoints(){
        return points;
    }

    public void exchangeProduct(Product product, int quantity) {
		points -= product.getCost() * quantity;
		product.subtractStock(quantity);
    }
}