app.controller("HomeController", ['$scope', '$http', '$translate', '$rootScope', function ($scope, $http, $translate, $rootScope) {
    'use strict';

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

    $scope.createVehicle = function(vehicle){
        $http.post($scope.baseUrl + 'vehicle');
    };

    $scope.goTo = function(elementId) {
        window.location.hash = elementId;
        $("#sidebar-wrapper").toggleClass("active");
    };
}]);