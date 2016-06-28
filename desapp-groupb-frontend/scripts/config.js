angular.module("subiQueTeLlevoApp")
.config(function myAppConfig ($routeProvider, authProvider, $httpProvider, $locationProvider,
            jwtInterceptorProvider) {

    authProvider.init({
        domain: AUTH0_DOMAIN,
    clientID: AUTH0_CLIENT_ID,
    loginUrl: '/login'
    });

    $routeProvider
    .when('/logout',  {
        templateUrl: 'views/logout.html',
        controller: 'LogoutCtrl'
    })
    .when('/login',   {
        templateUrl: 'templates/_home.html',
        controller: 'HomeController'
    })
    .when('/routes',   {
            templateUrl: 'templates/_routes.html',
            controller: 'RidesController',
            requiresLogin: true
    })
    .when('/rideRequests',   {
            templateUrl: 'templates/_rideRequests.html',
            controller: 'RidesController',
            requiresLogin: true
    })
    .when('/myRides',   {
            templateUrl: 'templates/_myRides.html',
            controller: 'RidesController',
            requiresLogin: true
    })
    .when('/profile',   {
        templateUrl: 'templates/_profile.html',
        controller: 'ProfileController',
        requiresLogin: true
    })
    .when('/products',   {
            templateUrl: 'templates/_products.html',
            controller: 'ProductController',
            requiresLogin: true
    })
    .when('/home',   {
                templateUrl: 'templates/_home.html',
                controller: 'HomeController'
    })
    .otherwise({ redirectTo: '/home'});

    authProvider.on('loginSuccess', function($rootScope, $location, profilePromise, idToken, store) {

        profilePromise.then(function(profile) {
            window.profile = profile;
            store.set('profile', profile);
            store.set('token', idToken);
            $rootScope.isLogin = true;
        });
        $location.path('/');
    });


    authProvider.on('loginFailure', function() {
        console.log("Error logging in");
        $location.path('/login');
    });

    //Angular HTTP Interceptor function
    jwtInterceptorProvider.tokenGetter = function(store) {
        return store.get('token');
    }
    //Push interceptor function to $httpProvider's interceptors
    $httpProvider.interceptors.push('jwtInterceptor');
});
