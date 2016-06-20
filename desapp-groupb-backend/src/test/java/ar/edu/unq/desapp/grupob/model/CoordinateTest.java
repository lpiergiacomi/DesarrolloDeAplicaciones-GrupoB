package ar.edu.unq.desapp.grupob.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordinateTest {

    Coordinate coordinate;

    @Test
    public void itShouldCreateANewCoordinateWithItsLatitudeAndLongitude() {
        coordinate = new Coordinate(-2.3456, 7.89034);
        assertEquals(coordinate.getLatitude(), -2.3456, 0);
        assertEquals(coordinate.getLongitude(), 7.89034, 0);
    }
}

