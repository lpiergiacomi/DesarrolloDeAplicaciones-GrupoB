package ar.edu.unq.desapp.grupob.model;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    int stock;
    int cost;
    Product product;

    @Before
    public void setUp() {
        stock = 100;
        cost = 1000;
        product = new Product("Bag", stock, cost);
    }

    @Test
    public void itShouldGetProductsCost(){
        assertEquals(product.getCost(), cost);
    }

    @Test
    public void itShouldGetProductStock(){
        assertEquals(product.getStock(), stock);
    }

    @Test
    public void itShouldAssertProductSubtractAStock() {
        product.subtractStock(1);
        assertEquals(99, product.getStock());
    }
}
