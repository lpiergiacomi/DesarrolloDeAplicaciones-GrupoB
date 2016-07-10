package ar.edu.unq.desapp.grupob.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Coordinate {

    private String name;
    private double latitude;
    private double longitude;
    private Integer id;

    public Coordinate() {}

    public Coordinate(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static double calculateDistanceBetween(Coordinate firstCoordinate, Coordinate secondCoordinate) {
        double latitudesDifference = firstCoordinate.getLatitude() - secondCoordinate.getLatitude();
        double longitudesDifference = firstCoordinate.getLongitude() - secondCoordinate.getLongitude();
        return Math.sqrt(latitudesDifference * latitudesDifference + longitudesDifference * longitudesDifference);
    }

}
