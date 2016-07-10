angular.module("subiQueTeLlevoApp")
.controller("UserController", function ($scope, $http, $translate, $rootScope, auth, $routeParams, store, $location) {
    'use strict';

    $scope.userUrl = $rootScope.baseUrl + "/users/"
    getUser($routeParams.id);
    getPublicMessages();
    $scope.newPublicMessage;
    $scope.newPrivateMessage;
    $scope.currentPublicMessagesPage = 1;
    $scope.currentPublicMessages;
    $scope.currentPrivateMessagesPage = 1;
    $scope.currentPrivateMessages;
    $scope.itemsPerPage = 10;

    function getUser(id){
        $http.get($scope.userUrl + id)
            .success(function(data){
                $scope.user = data;
        });
    };

    function getPublicMessages(){
        $http.get($scope.userUrl + $routeParams.id + "/publicMessages")
            .success(function(data){
                $scope.publicMessages = data;
                $scope.totalItems = $scope.publicMessages.length;
                $scope.publicMessagesPageChanged();
        });
    };

    $scope.getPrivateMessages = function(){
        $http.get($scope.userUrl + $routeParams.id + "/privateMessages/" + $rootScope.user.id)
            .success(function(data){
                $scope.privateMessages = data;
                $scope.totalItems = $scope.privateMessages.length;
                $scope.privateMessagesPageChanged();
        });
    };

    $scope.publicMessagesPageChanged = function() {
        var end = $scope.currentPublicMessagesPage * $scope.itemsPerPage,
            begin = ($scope.currentPublicMessagesPage - 1) * $scope.itemsPerPage;
        $scope.currentPublicMessages = $scope.publicMessages.slice(begin, end);
    };

    $scope.privateMessagesPageChanged = function() {
        var end = $scope.currentPrivateMessagesPage * $scope.itemsPerPage,
            begin = ($scope.currentPrivateMessagesPage - 1) * $scope.itemsPerPage;
        $scope.currentPrivateMessages = $scope.privateMessages.slice(begin, end);
    };

    $scope.giveDriverGoodRate = function(){
        $http.post($scope.userUrl + $scope.user.id + "/giveDriverGoodRate")
            .success(function(data){
                $scope.user = data;
            });
    };

    $scope.giveDriverBadRate = function(){
        $http.post($scope.userUrl + $scope.user.id + "/giveDriverBadRate")
            .success(function(data){
                $scope.user = data;
            });
    };

    $scope.givePassengerGoodRate = function(){
        $http.post($scope.userUrl + $scope.user.id + "/givePassengerGoodRate")
            .success(function(data){
                $scope.user = data;
            });
    };

    $scope.givePassengerBadRate = function(){
        $http.post($scope.userUrl + $scope.user.id + "/givePassengerBadRate")
            .success(function(data){
                $scope.user = data;
            });
    };

    $scope.sendPublicMessage = function(){
        $http.post($scope.userUrl + $rootScope.user.id + "/sendPublicMessage/" + $scope.user.id,
                    $scope.newPublicMessage)
            .success(function(data){
                $scope.newPublicMessage = "";
                $scope.getPublicMessages();
            });
    };


    $scope.sendPrivateMessage = function(){
        $http.post($scope.userUrl + $rootScope.user.id + "/sendPrivateMessage/" + $scope.user.id,
                    $scope.newPrivateMessage)
            .success(function(data){
                $scope.newPrivateMessage = "";
                $scope.getPrivateMessages();
            });
    };

    $scope.editUser = function(){
        // TODO
    }
})
