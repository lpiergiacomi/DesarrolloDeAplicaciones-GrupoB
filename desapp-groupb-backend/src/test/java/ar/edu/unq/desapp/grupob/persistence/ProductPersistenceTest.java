package ar.edu.unq.desapp.grupob.persistence;

import ar.edu.unq.desapp.grupob.model.Product;
import ar.edu.unq.desapp.grupob.repositories.ProductsRepository;
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
@ContextConfiguration(locations = {
        "classpath:test-spring-persistence-context.xml" })
public class ProductPersistenceTest
        extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private ProductsRepository productsRepository;

    private Product product;

    @Before
    public void setUp() {
        product = new Product("a Product", 1, 2);
        productsRepository.save(product);
    }

    @Test
    public void itShouldSaveAProduct() {
        List<Product> products = productsRepository.getAll();

        assertEquals(products.size(), 1);
    }

    @Test
    public void itShouldUpdateAProduct() {
        assertEquals(product.getCost(), 2);

        product.setCost(5);
        productsRepository.update(product);

        assertEquals(productsRepository.find(product.getId()).getCost(), 5);
    }

    @Test
    public void itShouldDeleteAProduct() {
        productsRepository.delete(product.getId());

        assertEquals(productsRepository.getAll().size(), 0);
    }
}
