package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VehicleTest {

    public Vehicle vehicle;

    @Before
    public void setUp() {
        vehicle = new Vehicle(4);
    }

    @Test
    public void itShouldKnowItsCapacity() {
        assertEquals(vehicle.getCapacity(), 4);
    }

    @Test
    public void itShouldBeAbleToReceiveGoodRates() {
        vehicle.receiveGoodRate();
        vehicle.receiveGoodRate();
        assertEquals(vehicle.getRate(), 2);
    }

    @Test
    public void itShouldBeAbleToReceiveBadRates() {
        vehicle.receiveBadRate();
        assertEquals(vehicle.getRate(), -1);
    }
}