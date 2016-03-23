import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void itShouldCheckIfAUserHasAVehicle() {
		User user = new User();
		assertTrue(user.hasVehicle());
	}
}
