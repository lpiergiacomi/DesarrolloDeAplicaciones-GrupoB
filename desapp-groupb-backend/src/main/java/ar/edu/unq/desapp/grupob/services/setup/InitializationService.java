package ar.edu.unq.desapp.grupob.services.setup;

import ar.edu.unq.desapp.grupob.model.*;
import ar.edu.unq.desapp.grupob.repositories.*;
import org.joda.time.DateTimeConstants;

public class InitializationService {

  ProductsRepository productsRepository;
  UserRepository userRepository;
  RideDateRepository rideDateRepository;
  RouteRepository routeRepository;
  RideRepository rideRepository;
  RideRequestRepository rideRequestRepository;
  User passenger;
  User driver;
  Ride driverRide;

  public void setUp(){
    initializeProducts();
    initializeUsers();
    initializeRideDates();
    initializeRoutes();
    initializeRides();
    initializeRideRequests();
  }

  private void initializeProducts() {
    for ( int i = 1; i <= 50; i ++ ) {
      productsRepository.save(new Product("Cubierta"+ i, 10, 200));
    }
  }

  private void initializeUsers() {
    driver = new User();
    driver.setEmail("driver@domain.com");
    driver.setPassword("123456");
    userRepository.save(driver);

    passenger = new User();
    passenger.setEmail("passenger@domain.com");
    passenger.setPassword("123456");
    userRepository.save(passenger);
  }

  public void initializeRideDates() {
    rideDateRepository.save(new DayOfWeekRideDate(DateTimeConstants.TUESDAY));
  }

  public void initializeRoutes() {
    routeRepository.save(new Route(0, 0));
  }

  public void initializeRides() {
    driverRide = new Ride(userRepository.find(driver.getId()), routeRepository.find(1),
                          rideDateRepository.find(1));
    rideRepository.save(driverRide);
  }

  public void initializeRideRequests() {
    RideRequest rideRequest = new RideRequest(userRepository.find(passenger.getId()), rideRepository.find(1),
                                              rideDateRepository.find(1));
    rideRequestRepository.save(rideRequest);
  }

  public void setProductsRepository(ProductsRepository productsRepository) {
    this.productsRepository = productsRepository;
  }

  public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void setRideDateRepository(RideDateRepository rideDateRepository) {
    this.rideDateRepository = rideDateRepository;
  }

  public void setRouteRepository(RouteRepository routeRepository) {
    this.routeRepository = routeRepository;
  }

  public void setRideRepository(RideRepository rideRepository) {
    this.rideRepository = rideRepository;
  }

  public void setRideRequestRepository(RideRequestRepository rideRequestRepository) {
    this.rideRequestRepository = rideRequestRepository;
  }
}
