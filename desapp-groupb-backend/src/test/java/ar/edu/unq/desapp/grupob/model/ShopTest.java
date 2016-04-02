package ar.edu.unq.desapp.grupob.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ShopTest {
    Shop shop;

    @Before
    public void setUp(){
        shop = new Shop();
    }

    @Test
    public void itGetExchangeables(){
        assertEquals(shop.getExchangeables().size(), 0);
    }

    @Test
    public void itAssertAddAExchangeable(){
        Exchangeable exchangeable = mock(Exchangeable.class);
        shop.addExchangeable(exchangeable);

        assertEquals(shop.getExchangeables().size(), 1);
    }

    @Test
    public void itAssertAddAListExchangeables(){
        Exchangeable product = mock(Exchangeable.class);
        List<Exchangeable> listExangeables = new ArrayList<Exchangeable>();
        listExangeables.add(product);
        listExangeables.add(product);
        shop.addListExchangeables(listExangeables);

        assertEquals(2, shop.getExchangeables().size());
    }

    /*
    @Test
    public void itAssertSellExchangeableToUser(){
        assertEquals(shop.getExchangeables().size(), 0);
    }
    */


}
