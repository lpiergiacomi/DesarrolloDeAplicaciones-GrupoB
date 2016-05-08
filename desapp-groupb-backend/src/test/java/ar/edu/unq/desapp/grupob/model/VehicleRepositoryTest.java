package ar.edu.unq.desapp.grupob.model;

import static org.junit.Assert.*;

import org.junit.*;

public class VehicleRepositoryTest {

    public Vehicle vehicle;

    @Before
    public void setUp() {
        vehicle = new Vehicle(4, 2.50);
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

    @Test
    public void itShouldGetCostToKilometres() {
        assertEquals(vehicle.getTotalCost(100.0), 250, 0);
    }
}