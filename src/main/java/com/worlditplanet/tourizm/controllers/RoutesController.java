package com.worlditplanet.tourizm.controllers;

import com.worlditplanet.tourizm.domain.entity.Route;
import com.worlditplanet.tourizm.services.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 23.01.2018.
 */
@Controller
@RequestMapping("/routes")
public class RoutesController {

    @Autowired
    private RoutesService routesService;

    @GetMapping
    public String getRoutesPage(@RequestParam(required = false, defaultValue = "1") Long page, Model model) {
        model.addAttribute("count",routesService.getCheckedNumberOfPages());
        model.addAttribute("page", page);
        List<Route> routeList = routesService.getRoutesByPage(page);
        if(routeList.size()>0) {
            model.addAttribute("routes", routeList);
        } else {
            return "redirect:/";
        }

        return "routes";
    }

    @GetMapping("/view")
    public String viewRoutePage(@RequestParam(required = true) Long id, Model model) {
        Route route = routesService.getRouteById(id);
        if(route!=null) {
            model.addAttribute("route", route);
            return "route";
        } else {
            return "redirect:/";
        }

    }

    @GetMapping("/create")
    public String viewCreateRoutePage() {
       return "map";
    }

    @GetMapping("/edit")
    public String editRoutePage() {
        return "editmap";
    }

    @GetMapping("/complete")
    public String routeCreatedPage() {
        return "routecreated";
    }

}
