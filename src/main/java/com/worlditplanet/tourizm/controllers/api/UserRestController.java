package com.worlditplanet.tourizm.controllers.api;

import com.worlditplanet.tourizm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @PutMapping("/name")
    public void updateName(@RequestParam("name") String name) {

    }

    @PutMapping("/pass")
    public void updatePass(@RequestParam("pass") String pass) {

    }

    @PutMapping("/country")
    public void updateCountry(@RequestParam("country") String country) {

    }

    @PutMapping("/city")
    public void updateCity(@RequestParam("city") String city) {

    }

}
