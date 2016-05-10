package ar.edu.unq.desapp.grupob.persistence;

import ar.edu.unq.desapp.grupob.model.DayOfWeekRideDate;
import ar.edu.unq.desapp.grupob.model.RideDate;
import ar.edu.unq.desapp.grupob.repositories.RideDateRepository;
import org.joda.time.DateTimeConstants;
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
public class RideDatePersistenceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private RideDateRepository rideDateRepository;

    private DayOfWeekRideDate dayOfWeekRideDate;

    @Before
    public void setUp() {
        int tuesday = DateTimeConstants.TUESDAY;
        dayOfWeekRideDate = new DayOfWeekRideDate(tuesday);
        rideDateRepository.save(dayOfWeekRideDate);
    }

    @Test
    public void itShouldSaveARideDate() {
        List<RideDate> rideDates = rideDateRepository.getAll();

        assertEquals(rideDates.size(), 1);
    }

    @Test
    public void itShouldDeleteARideDate() {
        rideDateRepository.delete(dayOfWeekRideDate.getId());

        assertEquals(rideDateRepository.getAll().size(), 0);
    }

}
