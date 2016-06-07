angular.module("subiQueTeLlevoApp")
.controller("HomeController", function ($scope, $http, $translate, $rootScope, auth,
                                        store, $location) {
    'use strict';

    $scope.login = true;
    $scope.register = true;
    $scope.showButtonsAccounts = true;
    $scope.isDriverSelected = false;
    $scope.auth = auth;
    window.auth = auth;

    $scope.showLoginForm= function(){
        $scope.login = false;
        $scope.showButtonsAccounts = false;
    };

    function onLoginSuccess(profile, token) {
      store.set('profile', profile);
      store.set('token', token);
      var user = {"user":{"email": profile.email, "password":" "}};
      $scope.createUser(user);
      $location.path('/');
      $scope.loading = false;
    }

    function onLoginFailed() {
      $scope.message.text = 'invalid credentials';
      $scope.loading = false;
    }

    $scope.loginGoogle = function(){
      auth.signin({
        popup: false,
        connection: 'google-oauth2',
        scope: 'openid name email'
      }, onLoginSuccess, onLoginFailed);
    }

    $scope.signupGoogle = function(){
        auth.signup({
          popup: false,
          connection: 'google-oauth2',
          scope: 'openid name email'
        }, onLoginSuccess, onLoginFailed);
    }

    $scope.showRegisterForm = function(){
        $scope.register = false;
        $scope.showButtonsAccounts = false;
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
        $http.post($rootScope.baseUrl + "users/register/",
        { "email": user.email, "password": user.password })
        .success(function(data){
            $rootScope.user = data;
        });
    };

    $scope.createUser = function(user, vehicle){
        $http.post($rootScope.baseUrl + "users/register/",
        { "email": user.email, "password": user.password })
        .success(function(data){
            $rootScope.user = data;
            $rootScope.isLogin = true;
    //        if($scope.isDriverSelected){
    //            this.createVehicle(vehicle)
    //        }
        });
    };

    $scope.createVehicle = function(vehicle){
        $http.post($rootScope.baseUrl + 'vehicle');
    };
});
