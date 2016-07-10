package ar.edu.unq.desapp.grupob.services.setup;

import ar.edu.unq.desapp.grupob.model.*;
import ar.edu.unq.desapp.grupob.repositories.*;
import org.joda.time.DateTimeConstants;

public class InitializationService {

    private ProductsRepository productsRepository;
    private UserRepository userRepository;
    private RideDateRepository rideDateRepository;
    private RouteRepository routeRepository;
    private RideRepository rideRepository;
    private RideRequestRepository rideRequestRepository;
    private CoordinateRepository coordinateRepository;
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

        User javier = new User();
        javier.setEmail("javierperini90@gmail.com ");
        userRepository.save(javier);

        User camila = new User();
        camila.setEmail("camilagarcia.113@gmail.com ");
        userRepository.save(camila);
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
}
