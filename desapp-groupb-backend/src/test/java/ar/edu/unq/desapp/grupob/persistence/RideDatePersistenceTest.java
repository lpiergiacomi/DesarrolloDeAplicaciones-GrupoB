package ar.edu.unq.desapp.grupob.persistence;

import ar.edu.unq.desapp.grupob.model.*;
import ar.edu.unq.desapp.grupob.repositories.RideDateRepository;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.MonthDay;
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
        DateTime from = new DateTime(2016, 3, 29, 12, 0);
        DateTime to = new DateTime(2016, 4, 29, 12, 0);

        dayOfWeekRideDate = new DayOfWeekRideDate(tuesday);
        rideDateRepository.save(dayOfWeekRideDate);

        DayOfMonthRideDate dayOfMonthRideDate = new DayOfMonthRideDate(new MonthDay(12, 10));
        rideDateRepository.save(dayOfMonthRideDate);

        RangeWithDayOfMonthRideDate rangeWithDayOfMonthRideDate = new RangeWithDayOfMonthRideDate(from, to, dayOfMonthRideDate);
        rideDateRepository.save(rangeWithDayOfMonthRideDate);

        RangeWithDayOfWeekRideDate rangeWithDayOfWeekRideDate = new RangeWithDayOfWeekRideDate(from, to, dayOfWeekRideDate);
        rideDateRepository.save(rangeWithDayOfWeekRideDate);
    }

    @Test
    public void itShouldSaveARideDate() {
        List<RideDate> rideDates = rideDateRepository.getAll();

        assertEquals(rideDates.size(), 4);

        rideDateRepository.delete(dayOfWeekRideDate.getId());
    }
}
