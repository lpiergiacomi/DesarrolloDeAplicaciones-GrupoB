package ar.edu.unq.desapp.grupob.persistence;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.edu.unq.desapp.grupob.model.Coordinate;
import ar.edu.unq.desapp.grupob.repositories.CoordinateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:test-spring-persistence-context.xml" })
public class CoordinatePersistenceTest {

    @Autowired
    private CoordinateRepository coordinateRepository;

    private Coordinate coordinate;

    @Before
    public void setUp() {
        coordinate = new Coordinate("La Plata", 3.123, -4.567);
        coordinateRepository.save(coordinate);
    }

    @After
    public void clean() {
        coordinateRepository.delete(coordinate.getId());
    }

    @Test
    public void itShouldSaveACoordinate() {
        List<Coordinate> coordinates = coordinateRepository.getAll();

        assertEquals(coordinates.size(), 1);
    }

    @Test
    public void itShouldUpdateACoordinate() {
        assertEquals(coordinate.getLatitude(), 3.123, 0);

        coordinate.setLatitude(4.432);
        coordinateRepository.update(coordinate);

        assertEquals(coordinate.getLatitude(), 4.432, 0);
    }
}
