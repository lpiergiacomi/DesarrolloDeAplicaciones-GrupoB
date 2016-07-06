angular.module("subiQueTeLlevoApp")
.controller("UserController", function ($scope, $http, $translate, $rootScope, auth, $routeParams, store, $location) {
    'use strict';

    $scope.userUrl = $rootScope.baseUrl +"/users/"
    $scope.user = getUser($routeParams.id);

    function getUser(id){
        $http.get($rootScope.userUrl + "/get/" + id)
            .success(function(data){
                return data;
        });
    };
})
