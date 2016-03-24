package model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private Vehicle vehicle;
	private List<Route> routes = new ArrayList<Route>();
	private List<RideRequest> rideRequests = new ArrayList<RideRequest>();

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<Route> getRoutes(){
		return routes;
	}

	public List<RideRequest> getRideRequests(){
		return rideRequests;
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

}