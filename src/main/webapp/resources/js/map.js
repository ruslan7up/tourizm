/**
 * Created by Admin on 31.01.2018.
 */
var num = 0;
var waypts = [];
var directionsService;
var directionsDisplay;
var geocoder;
function initMap() {
    directionsService = new google.maps.DirectionsService;
    geocoder = new google.maps.Geocoder();
    directionsDisplay = new google.maps.DirectionsRenderer({
        suppressMarkers: true,
        preserveViewport: true
    });
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 2,
        center: new google.maps.LatLng(0, 0)
    });
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var initialLocation = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
            geocoder.geocode(
                {'latLng': initialLocation},
                function(results, status) {
                    if (status == google.maps.GeocoderStatus.OK) {
                        for (var i = 0; i < results.length; i++) {
                            var isFound = false;
                            for(var k = 0; k < results[i].types.length; k++) {
                                if(results[i].types[k]==='locality') {
                                    isFound = true;
                                    break;
                                }
                            }
                            if(isFound) {
                                geocoder.geocode( { 'address': results[i].formatted_address}, function(results, status) {
                                    if (status == google.maps.GeocoderStatus.OK) {
                                        map.setCenter(results[0].geometry.location);
                                        map.fitBounds(results[0].geometry.viewport);
                                    }
                                });
                                break;
                            }
                        }
                    }
                    else {
                        console.log("Geocoder failed due to: " + status);
                    }
                }
            );

        });
    }

    directionsDisplay.setMap(map);

    google.maps.event.addListener(map, 'click', function(event) {
        addMarker(event.latLng, map);
    });
}

function calculateAndDisplayRoute(marker, deleteMode) {
    var latLngTmp = [];

    for (var i = 1; i < waypts.length-1; i++) {
        latLngTmp.push({
            location: waypts[i].getPosition(),
            stopover: true
        });
    }

    directionsService.route({
        origin: waypts[0].getPosition(),
        destination: waypts[waypts.length-1].getPosition(),
        waypoints: latLngTmp,
        optimizeWaypoints: false,
        travelMode: 'WALKING'
    }, function(response, status) {
        if (status === 'OK') {
            directionsDisplay.setDirections(response);
            if(deleteMode!==true) {
                $('#minfo').append('<li><input type="text" style="width: 25%;" placeholder="Информация для маркера" id="m' + num + '"></li><hr>');
            }
        } else {
            window.alert('Directions request failed due to ' + status);
            marker.setMap(null);
            waypts.pop();
            num = waypts.length;
        }
    });
}

function addMarker(location, map) {

    var marker = new google.maps.Marker({
        position: location,
        label: ++num+'',
        map: map
    });

    waypts.push(marker);
    calculateAndDisplayRoute(marker, false);
    marker.addListener("dblclick", function() {
        waypts = waypts.filter(function (p1) { return p1!==marker});
        for(var i = 0; i < waypts.length; i++) {
            waypts[i].setLabel(i+1+'');
        }

        calculateAndDisplayRoute(marker, true);
        marker.setMap(null);
    });}
$('input[type=submit]').click(function () {
    $('input[type="submit"]').prop('disabled', true);
    var route = {
        title: $('#title').val(),
        country: $('#country').val(),
        city: $('#city').val(),
        text:$('#text').val(),
        waypoints: []
    };
    for (var i = 0; i < waypts.length; i++) {
        route.waypoints.push({
            latitude: waypts[i].getPosition().lat(),
            longitude: waypts[i].getPosition().lng(),
            description: $('#m'+(i+1)).val()
        })
    }

    $.ajax({
        type: 'POST',
        url:'/api/routes',
        dataType:'json',
        contentType:'application/json',
        data: JSON.stringify(route),
        statusCode : {
            201: function () {
                window.location.href = "/routes/complete";
            }
        }
    });
    $('input[type="submit"]').prop('disabled', false);
});