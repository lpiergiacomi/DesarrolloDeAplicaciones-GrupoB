package ar.edu.unq.desapp.grupob.model;

import ar.edu.unq.desapp.grupob.model.exceptions.RouteException;

public class Passenger extends Role {

    public boolean isPassenger(){
        return true;
    }

    public boolean isDriver(){
        return false;
    }

    public void addRoute(Route route) throws RouteException {
        throw new RouteException("You can't add a route as a passenger, switch to driver mode instead");
    }
}
