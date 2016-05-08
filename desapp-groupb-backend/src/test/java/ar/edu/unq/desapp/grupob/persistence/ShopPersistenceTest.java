package ar.edu.unq.desapp.grupob.persistence;

/**
 * Created by javier on 03/05/16.
 */

import ar.edu.unq.desapp.grupob.model.Product;
import ar.edu.unq.desapp.grupob.model.Shop;
import ar.edu.unq.desapp.grupob.model.User;
import ar.edu.unq.desapp.grupob.repositories.ProductsRepository;
import ar.edu.unq.desapp.grupob.repositories.ShopRepository;
import ar.edu.unq.desapp.grupob.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-spring-persistence-context.xml" })
public class ShopPersistenceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private UserRepository userRepository;

    private Shop shop;

    @Before
    public void setUp() {
        shop = new Shop();
        shopRepository.save(shop);
    }

    @Test
    public void itShouldSaveAShop() {
        List<Shop> shops = shopRepository.all();

        assertEquals(shops.size(), 1);
    }

    @Test
    public void itShouldUpdateAShop() {
        assertEquals(shop.getExchangeRegisters().size(), 0);
        Product product = new Product("a Product", 1, 2);
        productsRepository.save(product);
        User user = new User();
        userRepository.save(user);

        shop.registerExchange(user, product);
        shopRepository.update(shop);

        assertEquals(shopRepository.find(shop.getId()).getExchangeRegisters().size(), 1);
    }

    @Test
    public void itShouldDeleteAShop() {
        shopRepository.delete(shop.getId());

        assertEquals(shopRepository.all().size(), 0);
    }
}