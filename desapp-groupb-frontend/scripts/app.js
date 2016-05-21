"use strict";

var app = angular
.module("subiQueTeLlevoApp", [
        "ngAnimate",
        "ngCookies",
        "ngResource",
        "ngRoute",
        "ngSanitize",
        "ngTouch",
        "pascalprecht.translate",
        ]);


app.run(function($rootScope) {
    $rootScope.user;
})

app.controller("HomeController", function ($scope, $http, $translate, $rootScope) {
    $scope.baseUrl = "http://localhost:8080/sqtl/";
    $scope.login = true;
    $scope.register = true;
    $scope.showButtonsAccounts = true;
    $scope.isDriverSelected = false;

    $scope.showLoginForm= function(){
      $scope.login = false;
      $scope.showButtonsAccounts = false;
    };

    $scope.showRegisterForm = function(){
      $scope.register = false;
      $scope.showButtonsAccounts = false;
    };

    $scope.setLanguage = function(keyLanguage){
      $translate.use(keyLanguage);
    };

    $scope.selectDriver = function(){
      $scope.isDriverSelected = !$scope.isDriverSelected;
    };

   $scope.resetForm = function(){
      $scope.showButtonsAccounts = true;
      $scope.login = true;
      $scope.register = true;
   };

   $scope.loginUser = function(user){
//      $http.get($scope.baseUrl + "users/" + user.email + "/" + user.password);
      $http.post($scope.baseUrl + "users/register/",
          { "email": user.email, "password": user.password })
      .success(function(data){
          $rootScope.user = data;
      });
   };

   $scope.createUser = function(user, vehicle){
    $http.post($scope.baseUrl + "users/register/",
        { "email": user.email, "password": user.password })
    .success(function(data){
        $rootScope.user = data;
//        if($scope.isDriverSelected){
//            this.createVehicle(vehicle)
//        }
    });
   };

   $scope.createVehicle= function(vehicle){
          $http.post($scope.baseUrl + 'vehicle')
   };

});

app.controller("ProductController", function ($scope, $http) {
    $scope.baseUrl = "http://localhost:8080/sqtl/products/";
    $scope.addProduct=false;
    $scope.showAllProducts = false;
    $scope.productFind;
    $scope.productNew= {"name": "", "stock":"", "cost":""};

    $scope.showProductForm= function(){
         $scope.showAllProducts = false;
         $scope.addProduct=true;
    };

    $scope.resetProductForm=function(){
        $scope.addProduct=false;
        $scope.productNew = {"name": "", "stock":"","cost":""};
    };

    $scope.saveProductForm= function(product){
        $http.post($scope.baseUrl,
                {"name": product.name, "stock": product.stock, "cost": product.cost})
        .success(function(data){
           $scope.productNew = {"name": "", "stock":"","cost":""};
        });
        $scope.addProduct=false;
    };

    $scope.getAllProducts= function(){
        $scope.addProduct=false;
        $http.get($scope.baseUrl + "all")
            .success(function(data){
                $scope.allProducts = data;
                $scope.showAllProducts = true;
            });
    };

    $scope.findProduct = function(productName){
        $http.get($scope.baseUrl + productName)
            .success(function(data){
                $scope.allProducts = [data];
                $scope.showAllProducts = true;
            });
        $scope.showAllProducts = false;
        $scope.addProduct=false;
    };
});

app.controller("RidesController", function ($scope, $http, $rootScope) {

    $scope.rides;
    $scope.userRides;
    $scope.userRideRequests;
    $scope.baseUrl = "http://localhost:8080/sqtl/";
    $scope.showSuccessAlert = false;
    $scope.showMap= false;

    // lo quiero usar para el alert
    $scope.switchBool = function(value) {
        $scope[value] = !$scope[value];
    };

    $scope.getDriverRides = function(){
        $http.get($scope.baseUrl + "users/" + $rootScope.user.id + "/driverRides").
        success(function(data){
            $scope.userRides = data;
        })
    }

    $scope.getPassengerRides = function(){
        $http.get($scope.baseUrl + "users/" + $rootScope.user.id + "/passengerRides").
        success(function(data){
            $scope.userRides = data;
        })
    }

    $scope.getDriverRideRequests = function(){
        $http.get($scope.baseUrl + "users/" + $rootScope.user.id + "/driverRideRequests").
        success(function(data){
            $scope.userRideRequests = data;
        })
    }

    $scope.getPassengerRideRequests = function(){
        $http.get($scope.baseUrl + "users/" + $rootScope.user.id + "/passengerRideRequests").
        success(function(data){
            $scope.userRideRequests = data;
        })
    }

    $scope.joinRide = function(ride){
        $http.post($scope.baseUrl + 'rideRequests/joinRide',
            { ride: ride, user: $rootScope.user }).
        success(function(data){
             $scope.myRides.add(data);
         });
    };


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
  });

  $translateProvider.preferredLanguage("en");

});
