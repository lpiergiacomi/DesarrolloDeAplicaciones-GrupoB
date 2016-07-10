package ar.edu.unq.desapp.grupob.model;

import javax.persistence.Entity;

import ar.edu.unq.desapp.grupob.model.exceptions.RouteException;

@Entity
public class Passenger extends Role {

    public Passenger() {
    }

    public void addRoute(Route route) throws RouteException {
        throw new RouteException(
                "You can't add a route as a passenger, switch to driver mode instead");
    }
}
