'use strict';
var app = angular.module('subiQueTeLlevoApp', ["pascalprecht.translate"]);

app.run(function($rootScope) {
    $rootScope.user;
});

app.config(function($translateProvider) {
  
  $translateProvider.translations("en", {
      "REGISTER": "Register",
      "LOGIN": "Login",
      "HOME": "Home",
      "MY_RIDES": "My rides",
      "PRODUCTS": "Products",
      "EMAIL":"Email",
      "PASSWORD":"Contraseña",
      "CHECKBOX_DRIVER":"Do you have a car and want to be a driver? Select if you do!",
      "CANCEL":"Cancel",
      "VEHICLE_CAPACITY":"Vehicle capacity",
      "TYPE_VEHICLE": "Select your vehicle type",
      "CAR": "Car",
      "VAN": "Van",
      "AVAILABLE_ROUTES": "Available routes",
      "MY_ROUTES": "My routes",
      "MY_RIDE_REQUESTS": "My ride requests",
      "ROUTES" : "Routes",
      "DRIVER": "Driver",
      "DAY": "Day",
      "FROM": "From",
      "TO": "To",
      "JOIN": "Join",
      "PASSENGER" : "Passenger",
      "ALL_PRODUCTS" : "All products",
      "ADD_PRODUCT" : "Add product",
      "NAME" : "Name",
      "STOCK" : "Stock",
      "PRICE" : "Price",
      "STATUS" : "Status",
      "PASSENGERS" : "Passengers",
      "SAVE" : "Save",
  });

  $translateProvider.translations("es", {
      "REGISTER": "Registrarse",
      "LOGIN": "Login",
      "HOME": "Home",
      "MY_RIDES": "Mis recorridos",
      "PRODUCTS": "Productos",
      "EMAIL":"Email",
      "PASSWORD":"Contraseña",
      "CHECKBOX_DRIVER":"Selecciona si tenes un auto y queres ser conductor!",
      "CANCEL":"Cancelar",
      "VEHICLE_CAPACITY":"Capacidad del vehiculo",
      "TYPE_VEHICLE": "Selecciona tu tipo de vehiculo",
      "CAR": "Auto",
      "VAN": "Camioneta",
      "AVAILABLE_ROUTES": "Rutas disponibles",
      "MY_ROUTES": "Mis rutas",
      "MY_RIDE_REQUESTS": "Mis solicitudes de viaje",
      "ROUTES" : "Recorridos",
      "DRIVER": "Conductor",
      "DAY": "Dia",
      "FROM": "Desde",
      "TO": "Hasta",
      "JOIN": "Unirse",
      "PASSENGER" : "Pasajero",
      "ALL_PRODUCTS" : "Todos los productos",
      "ADD_PRODUCT" : "Agregar producto",
      "NAME" : "Nombre",
      "STOCK" : "Stock",
      "PRICE" : "Costo",
      "STATUS" : "Estado",
      "PASSENGERS" : "Pasajeros",
      "SAVE" : "Guardar",
  });

  $translateProvider.preferredLanguage("en");

});