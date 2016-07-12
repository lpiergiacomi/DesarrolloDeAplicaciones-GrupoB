package ar.edu.unq.desapp.grupob.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Driver extends Role {

    private List<Route> routes = new ArrayList<Route>();

    public Driver() {
    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}
