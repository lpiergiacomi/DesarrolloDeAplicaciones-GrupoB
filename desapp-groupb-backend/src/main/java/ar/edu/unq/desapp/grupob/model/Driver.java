package ar.edu.unq.desapp.grupob.model;

import javax.persistence.*;
import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Driver extends Role {

    private List<Route> routes = new ArrayList<Route>();

    public Driver(){}

    @Transient
    public boolean passenger(){
        return false;
    }
    @Transient
    public boolean driver(){
        return true;
    }

    public void addRoute(Route route){
        routes.add(route);
    }

    @OneToMany
    @JoinColumn
    public List<Route> getRoutes(){
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}
