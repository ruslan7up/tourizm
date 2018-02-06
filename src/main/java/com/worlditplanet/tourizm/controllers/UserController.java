package com.worlditplanet.tourizm.controllers;

import com.worlditplanet.tourizm.domain.entity.Role;
import com.worlditplanet.tourizm.domain.entity.User;
import com.worlditplanet.tourizm.services.RolesService;
import com.worlditplanet.tourizm.services.UserService;
import com.worlditplanet.tourizm.utils.RecaptchaUtils;
import com.worlditplanet.tourizm.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 14.01.2018.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RolesService rolesService;

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user,/*@RequestParam("g-recaptcha-response") String recaptcha,*/ BindingResult result, Model model, HttpServletRequest request) {
        if(result.hasErrors()) {
            return "register";
        }
        String recaptcha = request.getParameter("g-recaptcha-response");
        if(!RecaptchaUtils.isCaptchaValid(recaptcha)) {
            model.addAttribute("recaptcha","error");
            return "register";
        }  else {
            user.setPassword(SecurityUtils.encodePassword(user.getPassword()));
            List<Role> roles = new ArrayList<>();
            roles.add(rolesService.getRoleByDesc("USER"));
            user.setRoles(roles);
            userService.addUser(user);
            model.addAttribute("user",user);
            return "regcomplete";
        }
    }

    @GetMapping("/profile")
    public String getProfilePage(@RequestParam Long id, Model model) {
        model.addAttribute("user",userService.getUserById(id));
        return "profile";
    }

    @GetMapping("/edit")
    public String getEditPage(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByLogin(principal.getName()));
        return "editprofile";
    }
}
