package ar.edu.unq.desapp.grupob.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class RouteTest {

    Route route;

    @Test
    public void itShouldCreateANewRouteWithItsLatitudeAndLongitude() {
        route = new Route(-2.3456, 7.89034);
        assertEquals(route.getLatitude(), -2.3456, 0);
        assertEquals(route.getLongitude(), 7.89034, 0);
    }
}
