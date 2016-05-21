"use strict";

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
            map.setZoom(17);
        }
    }

    origin_autocomplete.addListener("place_changed", function() {
        var place = origin_autocomplete.getPlace();
        if (!place.geometry) {
            window.alert("Autocomplete's returned place contains no geometry");
            return;
        }
        expandViewportToFitPlace(map, place);

        // If the place has a geometry, store its place ID and route if we have
        // the other place ID
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

        // If the place has a geometry, store its place ID and route if we have
        // the other place ID
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
            } else {
                window.alert("Directions request failed due to " + status);
            }
        });
    }
}
