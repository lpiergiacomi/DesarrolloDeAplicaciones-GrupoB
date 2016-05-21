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
    private Role currentRole;
    private Driver driverRole;
    private Passenger passengerRole;
    private int points;
    private List<Message> messages;
    private Integer id;

    public User(){
        driverRole = new Driver();
        passengerRole = new Passenger();
        currentRole = passengerRole;
        points = 0;
        messages = new ArrayList<>();
        vehicle = new Vehicle(0, 0); // FIXME
    }

    public boolean hasVehicle() {
      return vehicle != null;
    }

    public void addRoute(Route route){
      driverRole.addRoute(route);
    }

    public void addRideRequest(RideRequest rideRequest){
      currentRole.addRideRequest(rideRequest);
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
        if(!getRideRequests().contains(rideRequest)){
          throw new RideRequestException("This ride request does not belong to this user");
        }
    }

    public void giveGoodRate(User user) {
      user.receiveGoodRate();
    }

    public void giveBadRate(User user) {
      user.receiveBadRate();
    }

    public void receiveGoodRate() {
      points += currentRole.receiveGoodRate();
    }

    public void receiveBadRate(){
      points -= currentRole.receiveBadRate();
    }

    public void switchToDriver(){
      currentRole = driverRole;
    }

    public void switchToPassenger(){
      currentRole = passengerRole;
    }

    public void exchangeProduct(Product product, int quantity) {
        points -= product.getCost() * quantity;
        product.subtractStock(quantity);
    }

    @Transient
    public boolean isPassengerRoleActivated() {
      return currentRole.passenger();
    }

    @Transient
    public boolean isDriverRoleActivated() {
      return currentRole.driver();
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

    @Transient
    public Role getCurrentRole() {
      return currentRole;
    }

    public void setCurrentRole(Role currentRole) {
      this.currentRole = currentRole;
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
    public List<RideRequest> getRideRequests(){
      return currentRole.getRideRequests();
    }

    @Transient
    public int getGoodRate(){
      return currentRole.getGoodRate();
    }

    @Transient
    public int getBadRate(){
      return currentRole.getBadRate();
    }

    @Transient
    public List<Ride> getRides(){
        return currentRole.getRides();
    }

    public void addRide(Ride ride){
        currentRole.addRide(ride);
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
