'use strict';

/**
 * @ngdoc overview
 * @name desarrolloDeAplicacionesGrupoBApp
 * @description
 * # desarrolloDeAplicacionesGrupoBApp
 *
 * Main module of the application.
 */

var subiQueTeLlevoApp = angular
.module('subiQueTeLlevoApp', [
        'ngAnimate',
        'ngCookies',
        'ngResource',
        'ngRoute',
        'ngSanitize',
        'ngTouch'
        ])

subiQueTeLlevoApp.controller('RecorridosController', function ($scope, $http) {


    $scope.rides=[{"id": 1, "driver": "pepe", "route":{"from": "Berzategui", "to": "Parque Patricios"}, "date": "12/12/06"},
    {"id": 2, "driver": "raul" , "route":{"from": "Bernal", "to": "Quilmes"}, "date": "11/12/06"}
    ];

    $scope.myRides=[{"route":{"from": "Berzategui", "to": "Parque Patricios"}, "date": "12/12/06"},
    {"route":{"from": "Bernal", "to": "Quilmes"}, "date": "11/12/06"}
    ];

    $scope.lista = false;
    $scope.baseUrl = "http://localhost:8080/sqtl";
    $scope.productNew= {"name": "", "stock":"","cost":""}
    $scope.addProduct=false;
    $scope.showAllProducts = false;
    $scope.productFind = 0;
    $scope.showSuccessAlert = false;

    $scope.showProductForm= function(){
        $scope.addProduct=true;
    }

    $scope.resetProductForm=function(){
        $scope.addProduct=false;
        $scope.productNew = {};
    }

    $scope.saveProductForm= function(product){
        console.log(product);
        $http.post($scope.baseUrl +'/products/' ,
                {"name":product.name, "stock":product.stock, "cost":product.cost})
        .success(function(data){
           $scope.productNew = {};
        })
        $scope.addProduct=false;
    }

    $scope.getAllProducts= function(){
        $http.get($scope.baseUrl +'/products/all/')
            .success(function(data){
                console.log(data);
                $scope.allProducts = data;
                $scope.showAllProducts = true;
            })
    }
    // lo quiero usar para el alert
    $scope.switchBool = function(value) {
        $scope[value] = !$scope[value];
    };

    $scope.findProduct = function(product){
        console.log(product);
        $http.get($scope.baseUrl +'/products/'+ 1)
            .success(function(data){

            })
    }

    $scope.joinRide = function(rideId){
        $scope.rides = [{"id": 2, "driver": "raul" , "route":{"from": "Bernal", "to": "Quilmes"}, "date": "11/12/06"}];

        /*
           $http.post('/joinRide' ,{"rideId": rideId}).
           success(function(data){
           console.log("Hola")
           })*/
    }

    $scope.showMap= false;
})
