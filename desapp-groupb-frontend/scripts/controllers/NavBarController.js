angular.module("subiQueTeLlevoApp")
.controller("NavBarController", function ($scope, $translate, auth, $rootScope, store, $location) {
    'use strict';
    $scope.goTo = function(elementId) {
        $rootScope.isHomePage = elementId === "#home";
        window.location.hash = elementId;
        $("#sidebar-wrapper").toggleClass("active");
    };

    $scope.setLanguage = function(keyLanguage){
        $translate.use(keyLanguage);
        $("#sidebar-wrapper").toggleClass("active");
    };

    $scope.logout = function() {
        auth.signout();
        store.remove('profile');
        store.remove('token');
        store.remove('currentUser');
        $rootScope.user = undefined;
        $rootScope.isLogin = false;
        $location.path('/');
        $("#sidebar-wrapper").toggleClass("active");
    }
})
