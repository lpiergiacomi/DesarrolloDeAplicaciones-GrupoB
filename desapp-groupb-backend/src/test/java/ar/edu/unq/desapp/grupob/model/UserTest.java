package ar.edu.unq.desapp.grupob.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.*;

import ar.edu.unq.desapp.grupob.model.exceptions.RideRequestException;

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
    public void itShouldGetTheUsersRoutes() {
        Route route = mock(Route.class);
        user.addRoute(route);
        assertEquals(user.getRoutes().size(), 1);
    }

	@Test
	public void itShouldSendARequestForJoiningADriversRide() {
		user.addDriverRideRequest(rideRequest);
		assertEquals(user.getDriverRideRequests().size(), 1);
	}

	@Test
	public void itShouldAcceptARideRequest() throws RideRequestException {
		user.addDriverRideRequest(rideRequest);
		user.acceptRequest(rideRequest);
		verify(rideRequest, times(1)).accept();
	}

	@Test
	public void itShouldRejectARideRequest() throws RideRequestException {
		user.addDriverRideRequest(rideRequest);
		user.rejectRequest(rideRequest);
		verify(rideRequest, times(1)).reject();
	}

	@Test(expected=RideRequestException.class)
	public void itShouldNotHandleAnUnknownRideRequest() throws RideRequestException {
		RideRequest anotherRideRequest = mock(RideRequest.class);

		user.rejectRequest(anotherRideRequest);
		verify(anotherRideRequest, never()).accept();

		user.acceptRequest(anotherRideRequest);
		verify(anotherRideRequest, never()).reject();
	}

	@Test
	public void itShouldGiveAGoodRateToAnotherUser() {
		User anotherUser = new User();
		user.giveDriverGoodRate(anotherUser);
		assertEquals(anotherUser.getDriverGoodRate(), 1);
	}

	@Test
	public void itShouldGiveABadRateToAnotherUserAndItsScoreShouldChange() {
		User anotherUser = new User();
		user.giveDriverBadRate(anotherUser);
		assertEquals(anotherUser.getDriverBadRate(), 1);
	}

  @Test
  public void itShouldIncreaseItsPointsWhenReceivingAGoodRate() {
      user.receiveGoodRate(user.getDriverRole());
      assertEquals(user.getPoints(), 500);
  }

  @Test
  public void itShouldNotChangeItsPointsWhenReceivingABadRateForTheFirstTime() {
      user.receiveBadRate(user.getDriverRole());
      assertEquals(user.getPoints(), 0);
  }

  @Test
  public void itShouldDecreaseItsPointsWhenReceivingABadRateForTheSecondTime() {
      user.receiveBadRate(user.getDriverRole());
      user.receiveBadRate(user.getDriverRole());
      assertEquals(user.getPoints(), -1000);
  }


  @Test
  public void itShouldExchangePointsForAProduct() {
      int initialRate = user.getPoints();
      Product product = mock(Product.class);
      when(product.getCost()).thenReturn(100);
      user.exchangeProduct(product, 1);
      assertEquals(user.getPoints(), initialRate - 100);

  }

	@Test
	public void itShouldSendAPrivateMessageToAnotherUser() {
		User anotherUser = new User();
		user.sendPrivateMessageTo(anotherUser, "Hello World");
		assertEquals(anotherUser.getMessages().size(), 1);
	}

	@Test
	public void itShouldSendAPublicMessageToAnotherUser() {
		User anotherUser = new User();
		user.sendPublicMessageTo(anotherUser, "Hello World");
		assertEquals(anotherUser.getMessages().size(), 1);
	}

}
