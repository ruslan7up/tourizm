/**
 * Created by Admin on 04.02.2018.
 */
$(document).ready(function () {
    $('.map').each(function (index, element) {
        var a = $(this).attr("route-id");
        $.ajax({
            type: 'POST',
            url:'/api/routes/waypoints/'+a,
            dataType:'json',
            contentType:'application/json',
            statusCode : {
                200: function (waypoints) {

                    var map = new google.maps.Map(element, {
                        zoom: 2,
                        center: new google.maps.LatLng(0, 0)
                    });
                    if(waypoints.length>0) {
                        var directionsService = new google.maps.DirectionsService;
                        var directionsDisplay = new google.maps.DirectionsRenderer({
                            suppressMarkers: true,
                            preserveViewport: true
                        });

                        directionsDisplay.setMap(map);

                        var latLngTmp = [];

                        for (var i = 1; i < waypoints.length - 1; i++) {
                            latLngTmp.push({
                                location: {"lat": waypoints[i].latitude, "lng": waypoints[i].longitude},
                                stopover: true
                            });
                        }

                        directionsService.route({
                            origin: {"lat": waypoints[0].latitude, "lng": waypoints[0].longitude},
                            destination: {
                                "lat": waypoints[waypoints.length - 1].latitude,
                                "lng": waypoints[waypoints.length - 1].longitude
                            },
                            waypoints: latLngTmp,
                            optimizeWaypoints: false,
                            travelMode: 'WALKING'
                        }, function (response, status) {
                            if (status === 'OK') {
                                var bounds = new google.maps.LatLngBounds();
                                var num = 0;
                                for(var i = 0; i < waypoints.length; i++) {
                                    var content = waypoints[i].description;
                                        var infowindow = new google.maps.InfoWindow();
                                        var marker = new google.maps.Marker({
                                            position: {"lat": waypoints[i].latitude, "lng": waypoints[i].longitude},
                                            label: ++num + '',
                                            map: map
                                        });
                                        bounds.extend(marker.position);
                                    if(content.length>0) {
                                        google.maps.event.addListener(marker, 'click', (function (marker, content, infowindow) {
                                            return function () {
                                                infowindow.setContent(content);
                                                infowindow.open(map, marker);
                                            };
                                        })(marker, content, infowindow));
                                    }
                                }
                                directionsDisplay.setDirections(response);
                                map.fitBounds(bounds);
                            } else {
                                console.log('Ошибка, невозможно составить маршрут, текст ошибки = ' + status);
                            }
                        });
                    }
                }
            }
        })
    });
});