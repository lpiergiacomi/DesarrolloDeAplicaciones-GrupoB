app.controller("RidesController", ['$scope', '$http', '$rootScope', function ($scope, $http, $rootScope) {
    'use strict';

    $scope.rides = {};
    $scope.userRides = {};
    $scope.userRideRequests = {};
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
        });
    };

    $scope.getPassengerRides = function(){
        $http.get($scope.baseUrl + "users/" + $rootScope.user.id + "/passengerRides").
        success(function(data){
            $scope.userRides = data;
        });
    };

    $scope.getDriverRideRequests = function(){
        $http.get($scope.baseUrl + "users/" + $rootScope.user.id + "/driverRideRequests").
        success(function(data){
            $scope.userRideRequests = data;
        });
    };

    $scope.getPassengerRideRequests = function(){
        $http.get($scope.baseUrl + "users/" + $rootScope.user.id + "/passengerRideRequests").
        success(function(data){
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
}]);