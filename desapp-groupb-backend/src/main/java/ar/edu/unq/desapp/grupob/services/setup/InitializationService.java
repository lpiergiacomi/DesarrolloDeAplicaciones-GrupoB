package ar.edu.unq.desapp.grupob.services.setup;

import org.joda.time.DateTimeConstants;

import ar.edu.unq.desapp.grupob.model.Coordinate;
import ar.edu.unq.desapp.grupob.model.DayOfWeekRideDate;
import ar.edu.unq.desapp.grupob.model.Product;
import ar.edu.unq.desapp.grupob.model.Ride;
import ar.edu.unq.desapp.grupob.model.RideRequest;
import ar.edu.unq.desapp.grupob.model.Route;
import ar.edu.unq.desapp.grupob.model.User;
import ar.edu.unq.desapp.grupob.repositories.CoordinateRepository;
import ar.edu.unq.desapp.grupob.repositories.MessagesRepository;
import ar.edu.unq.desapp.grupob.repositories.ProductsRepository;
import ar.edu.unq.desapp.grupob.repositories.RideDateRepository;
import ar.edu.unq.desapp.grupob.repositories.RideRepository;
import ar.edu.unq.desapp.grupob.repositories.RideRequestRepository;
import ar.edu.unq.desapp.grupob.repositories.RouteRepository;
import ar.edu.unq.desapp.grupob.repositories.UserRepository;

public class InitializationService {

    private ProductsRepository productsRepository;
    private UserRepository userRepository;
    private RideDateRepository rideDateRepository;
    private RouteRepository routeRepository;
    private RideRepository rideRepository;
    private RideRequestRepository rideRequestRepository;
    private CoordinateRepository coordinateRepository;
    private MessagesRepository messagesRepository;
    private User passenger;
    private User driver;

    public void setUp() {
        initializeProducts();
        initializeUsers();
        initializeRideDates();
        initializeCoordinates();
        initializeRoutes();
        initializeRides();
        initializeRideRequests();
    }

    private void initializeCoordinates() {
        coordinateRepository
                .save(new Coordinate("Quilmes, Buenos Aires, Argentina",
                        -34.7206336, -58.25460510000005));
        coordinateRepository
                .save(new Coordinate("Wilde, Buenos Aires, Argentina",
                        -34.7040787, -58.32059859999998));
    }

    private void initializeProducts() {
        for (int i = 1; i <= 50; i++) {
            productsRepository.save(new Product("Cubierta" + i, 10, 200));
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

        User angeles = new User();
        angeles.setEmail("angeles.tellaarena@gmail.com ");
        angeles.setName("Angeles");
        angeles.setCity("Wilde");
        userRepository.save(angeles);
        User javier = new User();
        javier.setEmail("javierperini90@gmail.com ");
        javier.setName("Javier");
        javier.setCity("Don Bosco");
        userRepository.save(javier);

        User camila = new User();
        camila.setEmail("camilagarcia.113@gmail.com ");
        userRepository.save(camila);

        javier.sendPublicMessageTo(angeles, "holis de javier a angeles");
        angeles.sendPrivateMessageTo(javier, "Este es privado");

  //    Message privado = new PrivateMessage(angeles, javier, "este es privado");
  //    angeles.receiveMessage(privado);
        userRepository.update(javier);

        angeles.sendPublicMessageTo(javier, "holis de angeles a javier");
        userRepository.update(angeles);
    }

    public void initializeRideDates() {
        rideDateRepository
          .save(new DayOfWeekRideDate(DateTimeConstants.TUESDAY));
    }

    public void initializeRoutes() {
        routeRepository.save(new Route(coordinateRepository.find(1),
                coordinateRepository.find(2)));
    }

    public void initializeRides() {
        Ride driverRide = new Ride(userRepository.find(driver.getId()),
                routeRepository.find(1), rideDateRepository.find(1));
        rideRepository.save(driverRide);
    }

    public void initializeRideRequests() {
        RideRequest rideRequest = new RideRequest(
                userRepository.find(passenger.getId()), rideRepository.find(1),
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

    public void setRideRequestRepository(
            RideRequestRepository rideRequestRepository) {
        this.rideRequestRepository = rideRequestRepository;
    }

    public void setCoordinateRepository(
            CoordinateRepository coordinateRepository) {
        this.coordinateRepository = coordinateRepository;
    }

    public MessagesRepository getMessagesRepository() {
      return messagesRepository;
    }

    public void setMessagesRepository(MessagesRepository messagesRepository) {
      this.messagesRepository = messagesRepository;
    }

}
