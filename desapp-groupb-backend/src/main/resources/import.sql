INSERT INTO Product (ID, name, stock, cost) VALUES (1,'Aceite', 1, 3);
INSERT INTO Product (ID, name, stock, cost) VALUES (2,'Cubierta', 1, 4);
INSERT INTO Product (ID, name, stock, cost) VALUES (3,'Espejo', 1, 5);

INSERT INTO Route (ID, latitude, longitude) VALUES (3, 1, 5);
INSERT INTO Route (ID, latitude, longitude) VALUES (2, 3, 5);
INSERT INTO Route (ID, latitude, longitude) VALUES (1, 4, 5);

INSERT INTO RideDate (ID) VALUES (1);

INSERT INTO Vehicle (ID) VALUES (1);
INSERT INTO Vehicle (ID) VALUES (2);

INSERT INTO Driver (ID) VALUES (1);
INSERT INTO Driver (ID) VALUES (2);

INSERT INTO Passenger (ID) VALUES (1);
INSERT INTO Passenger (ID) VALUES (2);

INSERT INTO User (ID, vehicle_id, driverrole_id, passengerrole_id) VALUES (1, 1, 1, 1);
INSERT INTO User (ID, vehicle_id, driverrole_id, passengerrole_id) VALUES (2, 2, 2, 2);

INSERT INTO Ride (ID, rideDate, driver_id, route_id) VALUES (1, 1, 2, 3);
INSERT INTO Ride (ID, rideDate, driver_id, route_id) VALUES (2, 1, 2, 1);
INSERT INTO Ride (ID, rideDate, driver_id, route_id) VALUES (3, 1, 1, 2);

