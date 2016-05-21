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
    public void itShouldSaveARoute() {
        List<Route> routes = routeRepository.getAll();

        assertEquals(routes.size(), 4);
    }

    @Test
    public void itShouldUpdateARoute() {
        assertEquals(route.getLongitude(), 2.2, 0);

        route.setLongitude(5.0);
        routeRepository.update(route);

        assertEquals(routeRepository.find(route.getId()).getLongitude(), 5.0, 0);
    }

    @Test
    public void itShouldDeleteARoute() {
        routeRepository.delete(route.getId());

        assertEquals(routeRepository.getAll().size(), 3);
    }
}
