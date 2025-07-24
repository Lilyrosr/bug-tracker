package com.bug_tracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "login"; // Login page
    }

    @GetMapping("/create-bug")
    public String createBugForm() {
        return "create_bug";
    }
}

