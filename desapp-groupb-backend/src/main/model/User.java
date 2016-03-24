package model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private Vehicle vehicle;
	private List<Route> routes = new ArrayList<Route>();
	private List<RideRequest> rideRequests = new ArrayList<RideRequest>();
	private int rate;
	private boolean hasOneBadRate;

	public User(){
		rate = 0;
		hasOneBadRate = false;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<Route> getRoutes(){
		return routes;
	}

	public List<RideRequest> getRideRequests(){
		return rideRequests;
	}

	public int getRate(){
		return rate;
	}

	public boolean hasVehicle() {
		return vehicle != null;
	}

	public void addRoute(Route route){
		routes.add(route);
	}

	public void addRideRequest(RideRequest rideRequest){
		rideRequests.add(rideRequest);
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
		rate += 500;
	}

	public void receiveBadRate(){
		if(hasOneBadRate){
			rate -=1000;
		}else{
			hasOneBadRate = true;
		}
	}
}