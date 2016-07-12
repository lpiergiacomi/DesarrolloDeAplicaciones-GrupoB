package ar.edu.unq.desapp.grupob.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordinateTest {

    private Coordinate coordinate;

    @Test
    public void itShouldCreateANewCoordinateWithItsLatitudeAndLongitude() {
        coordinate = new Coordinate("Quilmes city", -2.3456, 7.89034);
        assertEquals(coordinate.getName(), "Quilmes city");
        assertEquals(coordinate.getLatitude(), -2.3456, 0);
        assertEquals(coordinate.getLongitude(), 7.89034, 0);
    }

    @Test
    public void itShouldCalculateTheDistanceBetweenTwoCoordinates() {
        Coordinate firstCoordinate = new Coordinate("Quilmes city", -34.724225,
                -58.2817395);
        Coordinate secondCoordinate = new Coordinate("Bernal", -34.7039121,
                -58.2909478);
        double distance = Coordinate.calculateDistanceBetween(firstCoordinate,
                secondCoordinate);
        assertEquals(0.022302616333066592, distance, 0);
    }

}