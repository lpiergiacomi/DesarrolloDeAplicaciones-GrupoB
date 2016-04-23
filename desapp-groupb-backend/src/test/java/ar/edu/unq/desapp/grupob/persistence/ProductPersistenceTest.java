package ar.edu.unq.desapp.grupob.persistence;

import ar.edu.unq.desapp.grupob.model.Product;
import ar.edu.unq.desapp.grupob.repositories.ProductsRepository;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test/test-spring-persistence-context.xml" })
public class ProductPersistenceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTransactionManager transactionManager;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @Transactional
    public void testAPlayerCouldBeSaved() {
        Product product = new Product("a Product", 1, 2);

        productsRepository.save(product);

        sessionFactory.getCurrentSession().flush();

    }

}
