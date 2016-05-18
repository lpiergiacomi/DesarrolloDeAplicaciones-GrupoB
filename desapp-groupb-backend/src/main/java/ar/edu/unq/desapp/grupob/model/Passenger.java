package ar.edu.unq.desapp.grupob.model;

import ar.edu.unq.desapp.grupob.model.exceptions.RouteException;

import javax.persistence.Entity;
import java.beans.Transient;

@Entity
public class Passenger extends Role {

    public Passenger(){}

    @Transient
    public boolean passenger(){
        return true;
    }

    @Transient
    public boolean driver(){
        return false;
    }

    public void addRoute(Route route) throws RouteException {
        throw new RouteException("You can't add a route as a passenger, switch to driver mode instead");
    }
}
