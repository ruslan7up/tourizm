package com.worlditplanet.tourizm.controllers.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.worlditplanet.tourizm.domain.entity.Route;
import com.worlditplanet.tourizm.domain.entity.Waypoint;
import com.worlditplanet.tourizm.services.RoutesService;
import com.worlditplanet.tourizm.services.UserService;
import com.worlditplanet.tourizm.services.WaypointsService;
import com.worlditplanet.tourizm.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/routes")
public class RoutesRestController {

    @Autowired
    private RoutesService routesService;

    @Autowired
    private UserService userService;

    @Autowired
    private WaypointsService waypointsService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/waypoints/{id}")
    public List<Waypoint> getWaypoints(@PathVariable Long id) {

        return waypointsService.getWaypointsByRouteId(id);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createRoute(@RequestBody Route route, Principal principal) {
        for (Waypoint waypoint: route.getWaypoints()) {
            waypoint.setRoute(route);
        }
        route.setAuthor(userService.getUserByLogin(principal.getName()));
        routesService.addRoute(route);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRoute(@RequestBody Route route) {
        for (Waypoint waypoint: route.getWaypoints()) {
            waypoint.setRoute(route);
        }
        route.setAuthor(routesService.getRouteById(route.getId()).getAuthor());
        routesService.updateRoute(route);
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delRoute(@RequestBody Long id) {
        routesService.removeRouteById(id);
    }

    /*@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/count")
    public ObjectNode getNumberOfPages() {
        Long count = routesService.getCheckedNumberOfPages();
        ObjectNode node = JsonUtils.createObjectNode();
        node.put("count", count);
        return node;
    }*/
}
