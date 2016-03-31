package ar.edu.unq.desapp.grupob.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RoleTest {

    public Driver driver;

    @Before
    public void setUp(){
        driver = new Driver();
    }

    @Test
    public void itShouldGetItsRates(){
        assertEquals(driver.getRate(), 0);
    }

    @Test
    public void itShouldReceiveAGoodRate(){
        driver.receiveGoodRate();
        assertEquals(driver.getRate(), 500);
    }

    @Test
    public void itShouldReceiveABadRateAndItsScoreShouldntChange(){
        driver.receiveBadRate();
        assertEquals(driver.getRate(), 0);
    }

    @Test
    public void itShouldGiveABadRateToAnotherUserForTheSecondTimeAndItsScoreShouldChange(){
        driver.receiveBadRate();
        driver.receiveBadRate();
        assertEquals(driver.getRate(), -1000);
    }
}
