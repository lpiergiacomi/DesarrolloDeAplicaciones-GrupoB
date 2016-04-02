package ar.edu.unq.desapp.grupob.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExchangeableTest {
    int stock;
    int cost;
    Product product;
    Voucher voucher;

    @Before
    public void setUp(){
        stock = 100;
        cost = 1000;
        product = new Product("Bag", stock, cost);
        voucher = new Voucher("$100 oil", stock , cost);
    }

    @Test
    public void itShouldGetProductPoints(){
        assertEquals(product.getCost(), cost);
    }

    @Test
    public void itShouldGetProductStock(){
        assertEquals(product.getStock(), stock);
    }

    @Test
    public void itShouldAssertProductSubtractAStock(){
        product.subtractStock(1);
        assertEquals(product.getStock(), 99);
    }

    @Test
    public void itShouldAssertProductIsProduct(){
        assertTrue(product.isProduct());
    }

    @Test
    public void itShouldDenyProductIsVoucher(){
        assertFalse(product.isVoucher());
    }

    @Test
    public void itShouldDenyVoucherIsProduct(){
        assertFalse(voucher.isProduct());
    }

    @Test
    public void itShouldAssertVoucherIsVoucher(){
        assertTrue(voucher.isVoucher());
    }
}
