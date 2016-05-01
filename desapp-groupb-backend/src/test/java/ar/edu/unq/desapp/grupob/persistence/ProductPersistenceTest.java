package ar.edu.unq.desapp.grupob.persistence;

import ar.edu.unq.desapp.grupob.model.Product;
import ar.edu.unq.desapp.grupob.repositories.ProductsRepository;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-spring-persistence-context.xml" })
public class ProductPersistenceTest extends AbstractTransactionalJUnit4SpringContextTests {

  @Autowired
  private SessionFactory sessionFactory;

  @Autowired
  private HibernateTransactionManager transactionManager;

  @Autowired
  private ProductsRepository productsRepository;

  private Product product;

  @Before
  public void setUp() {
    product = new Product("a Product", 1, 2);
    productsRepository.save(product);
  }

  @Test
  @Transactional
  public void itShouldSaveAProduct() {
    List<Product> products = productsRepository.all();

    assertEquals(products.size(), 1);
  }

  @Test
  @Transactional
  public void itShouldUpdateAProduct() {
    assertEquals(product.getCost(), 2);

    product.setCost(5);
    productsRepository.update(product);

    assertEquals(productsRepository.find(1).getCost(), 5);
  }

  @Test
  @Transactional
  public void itShouldDeleteAProduct() {
    productsRepository.delete(product.getId());

    assertEquals(productsRepository.all().size(), 0);
  }

}
