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
    public void itShouldRegisterAnExchangeForAProduct() {
        Product product = mock(Product.class);
        User user = mock(User.class);
        shop.registerExchange(user, product);
        assertEquals(shop.getExchangeRegisters().size(), 1);
    }
}
