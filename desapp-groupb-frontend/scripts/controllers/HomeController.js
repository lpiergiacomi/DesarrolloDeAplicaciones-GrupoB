angular.module("subiQueTeLlevoApp")
.controller("HomeController", function ($scope, $http, $translate, $rootScope, auth, store, $location) {
    'use strict';

    $scope.auth = auth;

    function setCurrentUser(data){
      store.set("currentUser", data);
      $rootScope.user = data;
      $rootScope.$broadcast('isLogged');
      $rootScope.isHomePage = true;
    }

    $scope.loginUser = function(user){
        $http.get($rootScope.baseUrl + "/users/login/" + user.email)
            .success(function(data){
                 setCurrentUser(data);
            });
    };

    $scope.createUser = function(user){
        $http.post($rootScope.baseUrl + "/users/register/",
                { "email": user.email, "password": user.password })
        .success(function(data){
            setCurrentUser(data);
        });
    };

    function endLoginProccess(profile, token){
        store.set('profile', profile);
        store.set('token', token);
        $location.path('/home');
        $scope.loading = false;
    }

    function onLoginSuccess(profile, token) {
        var user = {"email": profile.email, "password": profile.password};
        $scope.loginUser(user);
        endLoginProccess(profile, token);
    };

    function onSingUpSuccess(profile, token) {
        var user = {"email": profile.email, "password": profile.password};
        $scope.createUser(user);
        endLoginProccess(profile, token);
    };

    function onFailed() {
        $scope.loading = false;
    };

    $scope.loginGoogle = function(){
        auth.signin({
            popup: false,
            connection: 'google-oauth2',
            scope: 'openid name email'
        }, onLoginSuccess, onFailed);
    };

    $scope.signUpGoogle = function(){
        auth.signup({
            popup: false,
            connection: 'google-oauth2',
            scope: 'openid name email'
        }, onSingUpSuccess, onFailed);
    };

    $scope.createVehicle = function(vehicle){
        $http.post($rootScope.baseUrl + 'vehicle');
    };
});
