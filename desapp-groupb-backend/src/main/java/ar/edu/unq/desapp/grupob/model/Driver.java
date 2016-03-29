package ar.edu.unq.desapp.grupob.model;

import java.util.ArrayList;
import java.util.List;

public class Driver extends Role {

    protected List<Route> routes = new ArrayList<Route>();

    public boolean isPassenger(){
        return false;
    }

    public boolean isDriver(){
        return true;
    }

    public void addRoute(Route route){
        routes.add(route);
    }

    public List<Route> getRoutes(){
        return routes;
    }
}
