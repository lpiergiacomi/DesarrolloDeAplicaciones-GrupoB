package model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private Vehicle vehicle;
	private List<Route> routes = new ArrayList<Route>();
	private List<RideRequest> rideRequests = new ArrayList<RideRequest>();
	private TalkManager manargerTalk = new TalkManager(this);

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

	public void sendMenssageTo(User user, String message) {
		manargerTalk.sendMessageTo(user, message);
	}

	public void addTalk(Talk talk) {
		manargerTalk.addTalk(talk);
	}

	public List<Talk> getTalks(){
		return manargerTalk.getTalks();
	}


}