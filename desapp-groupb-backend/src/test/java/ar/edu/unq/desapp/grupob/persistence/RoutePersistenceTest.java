package ar.edu.unq.desapp.grupob.persistence;

import ar.edu.unq.desapp.grupob.model.Route;
import ar.edu.unq.desapp.grupob.repositories.RouteRepository;
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
public class RoutePersistenceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private RouteRepository routeRepository;

    private Route route;

    @Before
    public void setUp() {
        route = new Route(1.0, 2.2);
        routeRepository.save(route);
    }

    @Test
    public void itShouldSaveAProduct() {
        List<Route> routes = routeRepository.all();

        assertEquals(routes.size(), 1);
    }

    @Test
    public void itShouldUpdateAProduct() {
        assertEquals(route.getLongitude(), 2.2, 0);

        route.setLongitude(5.0);
        routeRepository.update(route);

        assertEquals(routeRepository.find(1).getLongitude(), 5.0, 0);
    }

    @Test
    public void itShouldDeleteAProduct() {
        routeRepository.delete(route.getId());

        assertEquals(routeRepository.all().size(), 0);
    }
}