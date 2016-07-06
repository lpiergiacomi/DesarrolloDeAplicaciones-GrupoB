angular.module("subiQueTeLlevoApp")
.controller("MapController", function ($scope, $http, $rootScope) {

    $scope.routeUrl = $rootScope.baseUrl +"/routes/"
    
    $scope.fetchDrawnRoute = function() {
        // $scope.originName = localStorage.getItem("originName");
        $scope.originLatitude = localStorage.getItem("originLatitude");
        $scope.originLongitude = localStorage.getItem("originLongitude");
        // $scope.destinationName = localStorage.getItem("destinationName");
        $scope.destinationLatitude = localStorage.getItem("destinationLatitude");
        $scope.destinationLongitude = localStorage.getItem("destinationLongitude");
    };

    $scope.clearLocalStorage = function() {
        // localStorage.removeItem("originName");
        localStorage.removeItem("originLatitude");
        localStorage.removeItem("originLongitude");
        // localStorage.removeItem("destinationName");
        localStorage.removeItem("destinationLatitude");
        localStorage.removeItem("destinationLongitude");
    }

    $scope.fetchDrawnRoute();

    $scope.clearInputs = function() {
        document.getElementById("origin-input").value = "";
        document.getElementById("destination-input").value = "";
    };

    $scope.saveRoute = function() {
        var saveRouteUrl = $scope.routeUrl + "saveRoute";
        $http.post(saveRouteUrl, 
            {
                "begin": {"latitude": $scope.originLatitude, "longitude": $scope.originLongitude},
                "end": {"latitude": $scope.destinationLatitude, "longitude": $scope.destinationLongitude}
            }).success(function(data) {
                console.log("Route saved successfully");
            });
        $scope.clearLocalStorage();
        $scope.clearInputs();
    };

    $scope.searchRoute = function() {
        $http.get($scope.routeUrl + "all").success(function(data){
                $scope.routes = data;
            });
    };
}); 

function initMap() {

    var originPlaceId = null;
    var destinationPlaceId = null;
    var travelMode = google.maps.TravelMode.DRIVING;
    var buenosAires = {
        lat : -34.6261939,
        lng : -58.410998
    };
    var map = new google.maps.Map(document.getElementById("map"), {
        mapTypeControl : false,
        center : buenosAires,
        zoom : 13
    });
    var directionsService = new google.maps.DirectionsService;
    var directionsDisplay = new google.maps.DirectionsRenderer;

    var geocoder = new google.maps.Geocoder;

    directionsDisplay.setMap(map);

    var origin_input = document.getElementById("origin-input");
    var destination_input = document.getElementById("destination-input");

    var origin_autocomplete = new google.maps.places.Autocomplete(origin_input);
    origin_autocomplete.bindTo("bounds", map);
    var destination_autocomplete = new google.maps.places.Autocomplete(
            destination_input);
    destination_autocomplete.bindTo("bounds", map);

    function expandViewportToFitPlace(map, place) {
        if (place.geometry.viewport) {
            map.fitBounds(place.geometry.viewport);
        } else {
            map.setCenter(place.geometry.location);
            map.setZoom(20);
        }
    }

    origin_autocomplete.addListener("place_changed", function() {
        var place = origin_autocomplete.getPlace();
        if (!place.geometry) {
            window.alert("Autocomplete's returned place contains no geometry");
            return;
        }
        expandViewportToFitPlace(map, place);

        originPlaceId = place.place_id;
        route(originPlaceId, destinationPlaceId, travelMode,
                directionsService, directionsDisplay);
    });

    destination_autocomplete.addListener("place_changed", function() {
        var place = destination_autocomplete.getPlace();
        if (!place.geometry) {
            window.alert("Autocomplete's returned place contains no geometry");
            return;
        }
        expandViewportToFitPlace(map, place);

        destinationPlaceId = place.place_id;
        route(originPlaceId, destinationPlaceId, travelMode,
                directionsService, directionsDisplay);
    });

    function route(originPlaceId, destinationPlaceId, travelMode,
            directionsService, directionsDisplay) {
        if (!originPlaceId || !destinationPlaceId) {
            return;
        }
        directionsService.route({
            origin : {
                "placeId" : originPlaceId
            },
            destination : {
                "placeId" : destinationPlaceId
            },
            travelMode : travelMode
        }, function(response, status) {
                if (status === google.maps.DirectionsStatus.OK) {
                    directionsDisplay.setDirections(response);
                    geocodeAddressOrigin();
                    geocodeAddressDestination();
                } else {
                    window.alert("Directions request failed due to " + status);
                }
        });
    }

    function geocodeAddressOrigin() {
        geocoder.geocode({'placeId': directionsDisplay.getDirections().geocoded_waypoints[0].place_id}, function(results, status) {
            if (status === google.maps.GeocoderStatus.OK) {
                //localStorage.setItem("originName", results[0].formatted_address);
                localStorage.setItem("originLatitude", results[0].geometry.location.lat());
                localStorage.setItem("originLongitude", results[0].geometry.location.lng());
            }
        });
    };

    function geocodeAddressDestination() {
        geocoder.geocode({'placeId': directionsDisplay.getDirections().geocoded_waypoints[1].place_id}, function(results, status) {
            if (status === google.maps.GeocoderStatus.OK) {
                //localStorage.setItem("destinationName", results[0].formatted_address);
                localStorage.setItem("destinationLatitude", results[0].geometry.location.lat());
                localStorage.setItem("destinationLongitude", results[0].geometry.location.lng());
            }
        });
    };
}