package com.bug_tracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboarddController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}
