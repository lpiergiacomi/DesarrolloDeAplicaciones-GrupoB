angular.module("subiQueTeLlevoApp")
.controller("NavBarCtrl", function ($scope, $translate, auth, $rootScope, store, $location) {
    'use strict';
    $scope.goTo = function(elementId) {
        window.location.hash = elementId;
        $("#sidebar-wrapper").toggleClass("active");
      };

    $scope.setLanguage = function(keyLanguage){
        $translate.use(keyLanguage);
    };

    $scope.logout = function() {
      auth.signout();
      store.remove('profile');
      store.remove('token');
      $rootScope.isLogin = false;
      $location.path('/login');
    }
})
