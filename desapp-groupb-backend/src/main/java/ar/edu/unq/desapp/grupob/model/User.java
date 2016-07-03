package ar.edu.unq.desapp.grupob.model;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unq.desapp.grupob.model.exceptions.RideRequestException;
import org.hibernate.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class User {

    private String email;
    private String password;
    private Vehicle vehicle;
    private Driver driverRole;
    private Passenger passengerRole;
    private int points;
    private List<Message> messages;
    private Integer id;

    public User(){
        driverRole = new Driver();
        passengerRole = new Passenger();
        points = 0;
        messages = new ArrayList<>();
        vehicle = new Vehicle(4, 0); // FIXME
        email = "example@holis.com";
        password = "123456";
    }

    public boolean hasVehicle() {
      return vehicle != null;
    }

    public void addRoute(Route route){
      driverRole.addRoute(route);
    }

    public void addDriverRideRequest(RideRequest rideRequest){
      driverRole.addRideRequest(rideRequest);
    }

    public void addPassengerRideRequest(RideRequest rideRequest){
      passengerRole.addRideRequest(rideRequest);
    }

    public void sendPublicMessageTo(User receiver, String message) {
        PublicMessage publicMessage = new PublicMessage(this, receiver, message);
        receiver.receiveMessage(publicMessage);
    }

    public void sendPrivateMessageTo(User receiver, String message) {
        PrivateMessage privateMessage = new PrivateMessage(this, receiver, message);
        receiver.receiveMessage(privateMessage);
    }

    public void receiveMessage(Message message){
          messages.add(message);
      }

    public void acceptRequest(RideRequest rideRequest) throws RideRequestException{
        this.handleRequest(rideRequest);
        rideRequest.accept();
    }

    public void rejectRequest(RideRequest rideRequest) throws RideRequestException {
        this.handleRequest(rideRequest);
        rideRequest.reject();
    }

    private void handleRequest(RideRequest rideRequest) throws RideRequestException {
        if(!getDriverRideRequests().contains(rideRequest)){
          throw new RideRequestException("This ride request does not belong to this user");
        }
    }

    public void giveDriverGoodRate(User user) {
      user.receiveGoodRate(user.getDriverRole());
    }

    public void givePassengerGoodRate(User user) {
      user.receiveGoodRate(user.getPassengerRole());
    }

    public void giveDriverBadRate(User user) {
      user.receiveBadRate(user.getDriverRole());
    }

    public void givePassengerBadRate(User user) {
      user.receiveBadRate(user.getPassengerRole());
    }

    public void receiveGoodRate(Role currentRole) {
      points += currentRole.receiveGoodRate();
    }

    public void receiveBadRate(Role currentRole){
      points -= currentRole.receiveBadRate();
    }

    public void exchangeProduct(Product product, int quantity) {
        points -= product.getCost() * quantity;
        product.subtractStock(quantity);
    }

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public Driver getDriverRole() {
      return driverRole;
    }

    public void setDriverRole(Driver driverRole) {
      this.driverRole = driverRole;
    }

    @Column(nullable = false, columnDefinition = "int default 0")
    public int getPoints(){
          return points;
      }

    public void setPoints(int points) {
      this.points = points;
    }

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public Passenger getPassengerRole() {
      return passengerRole;
    }

    public void setPassengerRole(Passenger passengerRole) {
      this.passengerRole = passengerRole;
    }

    @Id @GeneratedValue
    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public Vehicle getVehicle() {
      return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
      this.vehicle = vehicle;
    }

    @Transient
    public List<Route> getRoutes(){
      return driverRole.getRoutes();
    }

    public void setRoutes(List<Route> routes){
          driverRole.setRoutes(routes);
      }

    @Transient
    public List<RideRequest> getPassengerRideRequests(){
      return passengerRole.getRideRequests();
    }

    @Transient
    public List<RideRequest> getDriverRideRequests(){
      return driverRole.getRideRequests();
    }

    @Transient
    public int getPassengerGoodRate(){
      return passengerRole.getGoodRate();
    }

    @Transient
    public int getPassengerBadRate(){
      return passengerRole.getBadRate();
    }

    @Transient
    public int getDriverGoodRate(){
      return driverRole.getGoodRate();
    }

    @Transient
    public int getDriverBadRate(){
      return driverRole.getBadRate();
    }

    @Transient
    public List<Ride> getDriverRides(){
      return driverRole.getRides();
    }

    @Transient
    public List<Ride> getPassengerRides(){
      return passengerRole.getRides();
    }

    public void addPassengerRide(Ride ride){
        passengerRole.addRide(ride);
    }

    public void addDriverRide(Ride ride){
        driverRole.addRide(ride);
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn
    public List<Message> getMessages(){
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Transient
    public int getCapacityVehicle() {
      return vehicle.getCapacity();
  }

    @Column(unique = true)
    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
  }
}
