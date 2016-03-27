package model;

public class Passenger extends Role {

    public boolean isPassenger(){
        return true;
    }

    public boolean isDriver(){
        return false;
    }

    public void addRoute(Route route) throws Exception {
        throw new Exception("You can't add a route as a passenger, switch to driver mode instead");
    }
}
