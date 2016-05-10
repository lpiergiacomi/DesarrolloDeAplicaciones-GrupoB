package ar.edu.unq.desapp.grupob.persistence;

import ar.edu.unq.desapp.grupob.model.*;
import ar.edu.unq.desapp.grupob.repositories.ExchangerRegisterRepository;
import ar.edu.unq.desapp.grupob.repositories.ProductsRepository;
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
public class ExchangeRegisterPersistenceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private ExchangerRegisterRepository exchangerRegisterRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private UserRepository userRepository;


    private ExchangeRegister exchangeRegister;
    private User user;
    private Product product;

    @Before
    public void setUp() {
        user = new User();
        userRepository.save(user);
        product = new Product("a Product", 1, 2);
        productsRepository.save(product);
        exchangeRegister = new ExchangeRegister(user, product);
        exchangerRegisterRepository.save(exchangeRegister);
    }

    @Test
    public void itShouldSaveAExchangeRegister() {
        List<ExchangeRegister> exchangeRegisters = exchangerRegisterRepository.getAll();

        assertEquals(exchangeRegisters.size(), 1);
    }

    @Test
    public void itShouldUpdateAExchangeRegister() {
        assertEquals(exchangeRegister.getProduct(), product);
        Product productUpdate = new Product("a Product", 3, 1);
        productsRepository.save(productUpdate);
        exchangeRegister.setProduct(productUpdate);
        exchangerRegisterRepository.update(exchangeRegister);

        assertEquals(exchangerRegisterRepository.find(exchangeRegister.getId()).getProduct(), productUpdate);
    }

    @Test
    public void itShouldDeleteAExchangeRegister() {
        exchangerRegisterRepository.delete(exchangeRegister.getId());

        assertEquals(exchangerRegisterRepository.getAll().size(), 0);
    }

}

