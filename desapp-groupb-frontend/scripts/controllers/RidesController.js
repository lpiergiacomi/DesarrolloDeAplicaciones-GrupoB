angular.module("subiQueTeLlevoApp")
.controller("RidesController", function ($scope, $http, $rootScope) {
    'use strict';

    $scope.rides;
    $scope.userRides;
    $scope.userRideRequests = [];
    $scope.baseUrl = "http://localhost:8080/sqtl/";
    $scope.filteredUserRides = [];
    $scope.filteredUserRidesRequest = [];
    $scope.filteredAllRides = [];
    $scope.currentPageRide = 1;
    $scope.currentPageRideRequest = 1;
    $scope.currentPageAllRide = 1;
    $scope.itemsPerPage = 10;

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
                                  ,$scope.currentPageAllRide);
    };

    $scope.pageAllRidesChanged = function(){
        $scope.pageChanged(function(begin, end){$scope.filteredAllRides = $scope.rides.slice(begin, end);}
                     ,$scope.currentPageAllRide);
    };

    $scope.pageChanged = function(changeFilter, currentPage) {
        var end = currentPage * $scope.itemsPerPage,
            begin = (currentPage-1)* $scope.itemsPerPage;
        changeFilter(begin, end);
    };

    $rootScope.$on('isLogged', function(){
        $scope.getDriverRides();
    });

    function removeUserRideRequest(rideRequest){
      var index = $scope.userRideRequests.indexOf(rideRequest);
      $scope.userRideRequests.splice(index, 1);
    }
});
