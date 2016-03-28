package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User {

	private Vehicle vehicle;
	private List<Route> routes = new ArrayList<Route>();
	private List<RideRequest> rideRequests = new ArrayList<RideRequest>();
	private List<Talk> myConversation = new ArrayList<Talk>();

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
		Talk talk;
		if(!hasConversationForUser(user)) {
			talk = createNewTalk(user);
		}else {
			talk = getMyConversationFor(user).get(0);
		}
		talk.addMessage(message);
	}

	private List<Talk> getMyConversationFor(User user) {
		return myConversation.stream().filter(t -> t.isUserInConversation(user))
                .collect(Collectors.toList());
	}

	private Talk createNewTalk(User user) {
		Talk talk = new PublicTalk(this, user);
		user.addTalk(talk);
		addTalk(talk);
		return talk;
	}

	private void addTalk(Talk talk) {
		myConversation.add(talk);
	}

	private boolean hasConversationForUser(User user) {
		List<Talk> conversation = getMyConversationFor(user);
		return !conversation.isEmpty();
	}

	public List<Talk> getConversation() {
		return myConversation;
	}
}