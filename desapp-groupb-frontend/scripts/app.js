'use strict';

/**
 * @ngdoc overview
 * @name desarrolloDeAplicacionesGrupoBApp
 * @description
 * # desarrolloDeAplicacionesGrupoBApp
 *
 * Main module of the application.
 */

var app = angular
.module('subiQueTeLlevoApp', [
        'ngAnimate',
        'ngCookies',
        'ngResource',
        'ngRoute',
        'ngSanitize',
        'ngTouch',
        'pascalprecht.translate',
        ])

app.controller('HomeController', function ($scope, $http, $translate) {
    $scope.baseUrl = "http://localhost:8080/sqtl/";
    $scope.login = true;
    $scope.register = true;
    $scope.showButtonsAccounts = true;
    $scope.isDriverSelected = false;
    $scope.user;

    $scope.showLoginForm= function(){
      $scope.login = false;
      $scope.showButtonsAccounts = false;
    }

    $scope.showRegisterForm= function(){
      $scope.register = false;
      $scope.showButtonsAccounts = false;
    }
    $scope.setLanguage= function(keyLanguage){
     $translate.use(keyLanguage);
    }

    $scope.selectDriver= function(){
      $scope.isDriverSelected = !$scope.isDriverSelected;
    }

   $scope.resetForm =function(){
      $scope.showButtonsAccounts = true;
      $scope.login = true;
      $scope.register = true;
   }

   $scope.loginUser=function(user){
      $http.get($scope.baseUrl + 'users/' + user.email + '/' + user.password)
   }

   $scope.createUser=function(user){
    $http.get($scope.baseUrl + 'users/register/' + user.email + '/' + user.password)
    .success(function(data){
        $scope.user = data;
    })

   }

})

app.controller('ProductController', function ($scope, $http) {
    $scope.baseUrl = "http://localhost:8080/sqtl/products/";
    $scope.addProduct=false;
    $scope.showAllProducts = false;
    $scope.productFind;
    $scope.productNew= {"name": "", "stock":"","cost":""}

    $scope.showProductForm= function(){
         $scope.addProduct=true;
    }

    $scope.resetProductForm=function(){
        $scope.addProduct=false;
        $scope.productNew = {"name": "", "stock":"","cost":""};
    }

    $scope.saveProductForm= function(product){
        console.log(product);
        $http.post($scope.baseUrl,
                {"name":product.name, "stock":product.stock, "cost":product.cost})
        .success(function(data){
           $scope.productNew = {"name": "", "stock":"","cost":""};
        })
        $scope.addProduct=false;
    }

    $scope.getAllProducts= function(){
        $http.get($scope.baseUrl + 'all')
            .success(function(data){
                $scope.allProducts = data;
                $scope.showAllProducts = true;
            })
    }

    $scope.findProduct = function(product){
        $http.get($scope.baseUrl + product)
            .success(function(data){
                $scope.allProductgs = [data];
                $scope.showAllProducts = true;
            })
    }
})

app.controller('RecorridosController', function ($scope, $http) {


    $scope.rides=[{"id": 1, "driver": "pepe", "route":{"from": "Berzategui", "to": "Parque Patricios"}, "date": "12/12/06"},
    {"id": 2, "driver": "raul" , "route":{"from": "Bernal", "to": "Quilmes"}, "date": "11/12/06"}
    ];

    $scope.myRides=[{"route":{"from": "Berzategui", "to": "Parque Patricios"}, "date": "12/12/06"},
    {"route":{"from": "Bernal", "to": "Quilmes"}, "date": "11/12/06"}
    ];

    $scope.lista = false;
    $scope.baseUrl = "http://localhost:8080/sqtl";
    $scope.showSuccessAlert = false;
    $scope.showMap= false;


    // lo quiero usar para el alert
    $scope.switchBool = function(value) {
        $scope[value] = !$scope[value];
    };

    $scope.joinRide = function(rideId){
        $scope.rides = [{"id": 2, "driver": "raul" , "route":{"from": "Bernal", "to": "Quilmes"}, "date": "11/12/06"}];

        /*
           $http.post('/joinRide' ,{"rideId": rideId}).
           success(function(data){
           console.log("Hola")
           })*/
    }


})

app.config(function($translateProvider) {
  $translateProvider.translations('en', {
      'REGISTER': 'Register',
      'LOGIN': 'Login',
      'HOME': 'Home',
      'MY_RIDES': 'My rides',
      'PRODUCTS': 'Products',
      'EMAIL':'Email',
      'PASSWORD':'Contraseña',
      'CHECKBOX_DRIVER':'Do you have a car and want to be a driver? Select if you do!',
      'CANCEL':'Cancel',
      'VEHICLE_CAPACITY':'Vehicle capacity',
      'TYPE_VEHICLE': 'Select your vehicle type',
  })

  $translateProvider.translations('sp', {
        'REGISTER': 'Registrarse',
        'LOGIN': 'Login',
        'HOME': 'Home',
        'MY_RIDES': 'Mis recorridos',
        'PRODUCTS': 'Productos',
        'EMAIL':'Email',
        'PASSWORD':'Contraseña',
        'CHECKBOX_DRIVER':'Selecciona si tenes un auto y queres ser conductor!',
        'CANCEL':'Cancelar',
        'VEHICLE_CAPACITY':'Capacidad del vehiculo',
        'TYPE_VEHICLE': 'Selecciona tu tipo de vehiculo',
    })
  $translateProvider.preferredLanguage('en');

})
