'use strict';
var app = angular.module('subiQueTeLlevoApp', ['pascalprecht.translate','auth0',
                                               'angular-storage', 'angular-jwt', 'ngRoute']);

app.run(function($rootScope, auth, store, jwtHelper, $location) {
    $rootScope.user;
    $rootScope.isLogin = false;
    $rootScope.baseUrl = "http://localhost:8080/sqtl/";

    auth.hookEvents();

    $rootScope.$on('$locationChangeStart', function() {
      var token = store.get('token'),
         profile = store.get('profile');

      $rootScope.isLogin = profile !==null;

      if (token) {
        if (!jwtHelper.isTokenExpired(token)) {
          if (!auth.isAuthenticated) {
            //Re-authenticate user if token is valid
            auth.authenticate(store.get('profile'), token);
          }
        } else {
          // Either show the login page or use the refresh token to get a new idToken
          $location.path('/');
        }
      }
    });
});

app.config(function myAppConfig ($routeProvider, authProvider, $httpProvider, $locationProvider,
  jwtInterceptorProvider) {

     authProvider.init({
        domain: AUTH0_DOMAIN,
        clientID: AUTH0_CLIENT_ID,
        loginUrl: '/login'
      });

     $routeProvider
      .when('/logout',  {
        templateUrl: 'views/logout.html',
        controller: 'LogoutCtrl'
      })
      .when('/login',   {
        templateUrl: 'views/_home.html',
        controller: 'HomeController'
      })
        .when('/', {
        templateUrl: 'views/root.html',
    controller: 'RootCtrl',
    /* isAuthenticated will prevent user access to forbidden routes */
    requiresLogin: true
  });

  authProvider.on('loginSuccess', function($rootScope, $location, profilePromise, idToken, store) {

    profilePromise.then(function(profile) {
      window.profile = profile;
      store.set('profile', profile);
      store.set('token', idToken);
      $rootScope.isLogin = true;
    });
    $location.path('/');
  });


  authProvider.on('loginFailure', function() {
    console.log("Error logging in");
    $location.path('/login');
  });

  //Angular HTTP Interceptor function
  jwtInterceptorProvider.tokenGetter = function(store) {
      return store.get('token');
  }
  //Push interceptor function to $httpProvider's interceptors
  $httpProvider.interceptors.push('jwtInterceptor');
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
app.controller('RootCtrl', function (auth, $scope) {
  $scope.auth = auth;
  $scope.$watch('auth.profile.name', function(name) {
    if (!name) {
      return;
    }
    $scope.message.text = 'Welcome ' + auth.profile.name + '!';
  });

});

