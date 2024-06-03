package com.group_eight.website_quan_li_hoat_dong_tu_thien.controller;

import com.group_eight.website_quan_li_hoat_dong_tu_thien.model.*;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    private CampaignService campaignService;

    @Autowired
    private EventService eventService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("campaigns", campaignService.findByStatus("active"));
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/verify")
    public String verify(@RequestParam("code") String code) {
        User user = userService.findByVerificationCode(code);
        if (user != null) {
            user.setEnabled(true);
            userService.save(user);
            return "verify_success";
        } else {
            return "verify_fail";
        }
    }
}