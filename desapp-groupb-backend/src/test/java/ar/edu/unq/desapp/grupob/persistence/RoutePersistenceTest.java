package ar.edu.unq.desapp.grupob.persistence;

import ar.edu.unq.desapp.grupob.model.Coordinate;
import ar.edu.unq.desapp.grupob.model.Route;
import ar.edu.unq.desapp.grupob.repositories.CoordinateRepository;
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

    @Autowired
    private CoordinateRepository coordinateRepository;

    private Route route;

    @Before
    public void setUp() {
        Coordinate beginning = new Coordinate("Caballito", 2.123, -3.456);
        Coordinate end = new Coordinate("Lomas", -4.123, 5.342);
        coordinateRepository.save(beginning);
        coordinateRepository.save(end);

        route = new Route(beginning, end);
        routeRepository.save(route);
    }

    @Test
    public void itShouldSaveARoute() {
        List<Route> routes = routeRepository.getAll();

        assertEquals(routes.size(), 1);
    }

    @Test
    public void itShouldUpdateARoute() {
        assertEquals(route.getBegin().getLatitude(), 2.123, 0);
        assertEquals(route.getBegin().getLongitude(), -3.456, 0);

        Coordinate newBeginning = new Coordinate("Lanus", -3.456, 8.907);
        route.setBegin(newBeginning);
        routeRepository.update(route);

        assertEquals(route.getBegin().getLatitude(), -3.456, 0);
        assertEquals(route.getBegin().getLongitude(), 8.907, 0);
    }

    @Test
    public void itShouldDeleteARoute() {
        routeRepository.delete(route.getId());

        assertEquals(routeRepository.getAll().size(), 0);
    }
}
