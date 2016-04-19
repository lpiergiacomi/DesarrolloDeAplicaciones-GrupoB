package ar.edu.unq.desapp.grupob.model;

import static org.junit.Assert.*;
import org.junit.*;

public class RoleTest {

    public Driver driver;

    @Before
    public void setUp(){
        driver = new Driver();
    }

    @Test
    public void itShouldGetItsGoodRates(){
        assertEquals(driver.getGoodRate(), 0);
    }

    @Test
    public void itShouldGetItsBadRates(){
        assertEquals(driver.getBadRate(), 0);
    }

    @Test
    public void itShouldReceiveAGoodRate() {
        driver.receiveGoodRate();
        assertEquals(driver.getGoodRate(), 1);
    }

    @Test
    public void itShouldReceiveABadRateAndItsScoreShouldChange() {
        driver.receiveBadRate();
        assertEquals(driver.getBadRate(), 1);
    }
}
