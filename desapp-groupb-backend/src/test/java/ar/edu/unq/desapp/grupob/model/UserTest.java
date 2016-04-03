package ar.edu.unq.desapp.grupob.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	public User user;
	public Vehicle vehicle;
	public RideRequest rideRequest;

	@Before
	public void setUp(){
		user = new User();
		vehicle = mock(Vehicle.class);
		rideRequest = mock(RideRequest.class);
	}

    @Test
    public void itShouldAssertTheUserHasAVehicle() {
        user.setVehicle(vehicle);
        assertTrue(user.hasVehicle());
    }

    @Test
    public void itShouldDenyTheUserHasAVehicle() {
        assertFalse(user.hasVehicle());
    }

    @Test
    public void itShouldGetTheUsersRoutes() {
        Route route = mock(Route.class);
        user.addRoute(route);
        assertEquals(user.getRoutes().size(), 1);
    }

	@Test
	public void itShouldSendARequestForJoiningADriversRide(){
		user.addRideRequest(rideRequest);
		assertEquals(user.getRideRequests().size(), 1);
	}

	@Test
	public void itShouldAcceptARideRequest() throws Exception{
		user.addRideRequest(rideRequest);
		user.acceptRequest(rideRequest);
		verify(rideRequest, times(1)).accept();
	}

	@Test
	public void itShouldRejectARideRequest() throws Exception{
		user.addRideRequest(rideRequest);
		user.rejectRequest(rideRequest);
		verify(rideRequest, times(1)).reject();
	}

	@Test(expected=Exception.class)
	public void itShouldntHandleAnUnknownRideRequest() throws Exception{
		RideRequest anotherRideRequest = mock(RideRequest.class);

		user.rejectRequest(anotherRideRequest);
		verify(anotherRideRequest, never()).accept();

		user.acceptRequest(anotherRideRequest);
		verify(anotherRideRequest, never()).reject();
	}

	@Test
	public void itShouldRetrieveUsersRate(){
		assertEquals(user.getRate(), 0);
	}

	@Test
	public void itShouldGiveAGoodRateToAnotherUser(){
		User anotherUser = new User();
		user.giveGoodRate(anotherUser);
		assertEquals(anotherUser.getRate(), 500);
	}

	@Test
	public void itShouldGiveABadRateToAnotherUserAndItsScoreShouldntChange(){
		User anotherUser = new User();
		user.giveBadRate(anotherUser);
		assertEquals(anotherUser.getRate(), 0);
	}

	@Test
	public void itShouldGiveABadRateToAnotherUserForTheSecondTimeAndItsScoreShouldChange(){
		User anotherUser = new User();
		user.giveBadRate(anotherUser);
		user.giveBadRate(anotherUser);
		assertEquals(anotherUser.getRate(), -1000);
	}

	@Test
	public void itShouldBeInitiatedAsAPassenger(){
		assertTrue(user.isPassengerRoleActivated());
	}

	@Test
	public void itShouldSwitchToDriverRoleSuccessfully(){
		user.switchToDriver();
		assertTrue(user.isDriverRoleActivated());
		assertFalse(user.isPassengerRoleActivated());
	}

	@Test
	public void itShouldSwitchToPassengerRoleSuccessfully(){
		user.switchToPassenger();
		assertFalse(user.isDriverRoleActivated());
		assertTrue(user.isPassengerRoleActivated());
	}
}
