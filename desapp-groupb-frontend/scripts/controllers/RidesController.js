angular.module("subiQueTeLlevoApp")
.controller("RidesController", function ($scope, $http, $rootScope) {
    'use strict';

    $scope.rides;
    $scope.userRides;
    $scope.userRideRequests = {};
    $scope.baseUrl = "http://localhost:8080/sqtl/";
    $scope.showSuccessAlert = false;
    $scope.showMap= true;
    $scope.filteredUserRides = [];
    $scope.filteredUserRidesRequest = [];
    $scope.filteredAllRides = [];
    $scope.currentPageRide = 1;
    $scope.currentPageRideRequest = 1;
    $scope.currentPageAllRide = 1;
    $scope.itemsPerPage = 10;


    // lo quiero usar para el alert
    $scope.switchBool = function(value) {
        $scope[value] = !$scope[value];
    };

    $scope.getDriverRides = function(){
        $http.get($scope.baseUrl + "rides/" + $rootScope.user.id + "/driverRides")
        .success(function(data){
            $scope.userRides = data;
            $scope.totalRideItems = $scope.userRides.length;
            $scope.pageRideChanged();
        });
    };

    $scope.getPassengerRides = function(){
        // ARREGLAR EL PEDIDO PORQUE NO FUNCIONA
        $http.get($scope.baseUrl + "users/" + $rootScope.user.id + "/passengerRides")
        .success(function(data){
            $scope.userRides = data;
            $scope.totalRideItems = $scope.userRides.length;
            $scope.pageRideChanged();
        });
    };

    $scope.getDriverRideRequests = function(){
        $http.get($scope.baseUrl + "users/" + $rootScope.user.id + "/driverRideRequests")
        .success(function(data){
            $scope.userRideRequests = data;
        });
    };

    $scope.getPassengerRideRequests = function(){
        $http.get($scope.baseUrl + "users/" + $rootScope.user.id + "/passengerRideRequests")
        .success(function(data){
            $scope.userRideRequests = data;
        });
    };

    $scope.joinRide = function(ride){
        $http.post($scope.baseUrl + 'rideRequests/joinRide',
            { ride: ride, user: $rootScope.user }).
        success(function(data){
             $scope.myRides.add(data);
         });
    };

    $scope.getAllRides = function(){
        $http.get($scope.baseUrl + "rides/all")
        .success(function(data){
            $scope.rides = data;
            $scope.totalAllRidesItems = $scope.rides.length;
            $scope.pageAllRidesChanged();
        })
    }

    $scope.pageRideChanged = function() {
        var end = $scope.currentPageRide * $scope.itemsPerPage,
          begin = ($scope.currentPageRide-1)* $scope.itemsPerPage;
        $scope.filteredUserRides = $scope.userRides.slice(begin, end);
    };

    $scope.pageRideRequestChanged = function() {
        $scope.pageChanged($scope.userRideRequests, $scope.filteredUserRidesRequest,
                           $scope.currentPageRideRequest);
    };

    $scope.pageAllRidesChanged =function(){
        $scope.pageChanged($scope.rides, $scope.filteredAllRides, $scope.currentPageAllRide)
    };

    $scope.pageChanged = function(list, listFiltered, currentPage) {
        var end = currentPage * $scope.itemsPerPage,
            begin = (currentPage-1)* $scope.itemsPerPage;
        listFiltered = list.slice(begin, end);
    };

    $scope.getAllRides();

});
