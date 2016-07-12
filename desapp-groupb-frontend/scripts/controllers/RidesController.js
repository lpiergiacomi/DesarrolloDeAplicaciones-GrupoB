angular.module("subiQueTeLlevoApp")
.controller("RidesController", function ($scope, $http, $rootScope) {
    'use strict';

    $scope.rides;
    $scope.userRides;
    $scope.userRideRequests = [];
    $scope.baseUrl = "http://localhost:8080/sqtl/";
    $scope.filteredUserRides = [];
    $scope.filteredUserRidesRequest = [];
    $scope.currentPageRide = 1;
    $scope.currentPageRideRequest = 1;
    $scope.itemsPerPage = 10;
    $scope.isDriver = false;

    $scope.getDriverRides = function(){
        $http.get($scope.baseUrl + "rides/" + $rootScope.user.id + "/driverRides")
        .success(function(data){
            $scope.userRides = data;
            $scope.totalRideItems = $scope.userRides.length;
            $scope.pageRideChanged();
        });
    };

    $scope.getPassengerRides = function(){
        $http.get($scope.baseUrl + "users/" + $rootScope.user.id + "/passengerRides")
        .success(function(data){
            $scope.userRides = data;
            $scope.totalRideItems = $scope.userRides.length;
            $scope.pageRideChanged();
        });
    };

    $scope.getDriverRideRequests = function(){
        $http.get($scope.baseUrl + "rideRequests/" + $rootScope.user.id + "/driverRideRequests")
        .success(function(data){
            $scope.userRideRequests = data;
            $scope.totalRideRequestItems = $scope.userRideRequests.length;
            $scope.pageRideRequestChanged();
            $scope.isDriver = true;
        });
    };

    $scope.getPassengerRideRequests = function(){
        $http.get($scope.baseUrl + "rideRequests/" + $rootScope.user.id + "/passengerRideRequests")
        .success(function(data){
            $scope.userRideRequests = data;
            $scope.totalRideRequestItems = $scope.userRideRequests.length;
            $scope.pageRideRequestChanged();
            $scope.isDriver = false;
        });
    };

    $scope.acceptRideRequests = function(rideRequest){
      $http.post($scope.baseUrl + "rideRequests/" + rideRequest.id + "/acceptRideRequest")
              .success(function(data){
                  removeUserRideRequest(rideRequest);
                  $scope.totalRideRequestItems = $scope.userRideRequests.length;
                  $scope.pageRideRequestChanged();
                  $rootScope.addAlert('success', 'Aceptaste una solicitud de viaje');
              });
    };

    $scope.pageRideChanged = function() {
        $scope.pageChanged(function(begin, end){
                                   $scope.filteredUserRides = $scope.userRides.slice(begin, end);}
                                  ,$scope.currentPageRide);
    };

    $scope.pageRideRequestChanged = function() {
        $scope.pageChanged(function(begin, end){
                                   $scope.filteredUserRidesRequest = $scope.userRideRequests.slice(begin, end);}
                                  ,$scope.currentPageRideRequest);
    };

    $scope.pageChanged = function(changeFilter, currentPage) {
        var end = currentPage * $scope.itemsPerPage,
            begin = (currentPage-1)* $scope.itemsPerPage;
        changeFilter(begin, end);
    };

    if($rootScope.user){
        $scope.getDriverRides();
        $scope.getDriverRideRequests();
    };

    function removeUserRideRequest(rideRequest){
      var index = $scope.userRideRequests.indexOf(rideRequest);
      $scope.userRideRequests.splice(index, 1);
    }
});
