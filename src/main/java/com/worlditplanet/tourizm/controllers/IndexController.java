package com.worlditplanet.tourizm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Admin on 24.01.2018.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String returnToRoutes() {
        return "redirect:/routes";
    }
}
