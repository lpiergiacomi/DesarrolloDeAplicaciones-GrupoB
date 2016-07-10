'use strict';
var app = angular.module('subiQueTeLlevoApp', ['pascalprecht.translate','auth0',
        'angular-storage', 'angular-jwt', 'ngRoute', 'ui.bootstrap']);

app.run(function($rootScope, auth, store, jwtHelper, $location) {
    $rootScope.user;
    $rootScope.isLogin = false;
    $rootScope.isHomePage = false;
    $rootScope.baseUrl = "http://localhost:8080/sqtl";
    $rootScope.alerts = [];

    auth.hookEvents();

    $rootScope.$on('$locationChangeStart', function() {
        var token = store.get('token'),
        profile = store.get('profile'),
        user = store.get('currentUser');
        $rootScope.isLogin = user !== null && profile !== null;

        if($rootScope.isLogin) {
            $rootScope.user = user;
        }

        $rootScope.isHomePage = location.href.indexOf("home") > 1

        if (token) {
            if (!jwtHelper.isTokenExpired(token)) {
                if (!auth.isAuthenticated) {
                    //Re-authenticate user if token is valid
                    auth.authenticate(store.get('profile'), token);
                }
            } else {
                // Either show the login page or use the refresh token to get a new idToken
                $location.path('/');
            }
        }
    });

    $rootScope.addAlert = function(type, msg) {
        $rootScope.alerts.push({ type: type, msg: msg});
    };

    $rootScope.closeAlert = function(index) {
        $rootScope.alerts.splice(index, 1);
    };

});