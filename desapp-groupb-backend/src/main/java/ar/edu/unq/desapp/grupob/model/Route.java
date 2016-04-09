package ar.edu.unq.desapp.grupob.model;

public class Route {

    private double latitude;
    private double longitude;

    public Route(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
