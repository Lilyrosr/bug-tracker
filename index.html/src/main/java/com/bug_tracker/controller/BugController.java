package com.bug_tracker.controller;

import com.bug_tracker.entity.Bug;
import com.bug_tracker.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bugs")
public class BugController {

    @Autowired
    private BugService bugService;

    @PostMapping("/create")
    public Bug createBug(@RequestBody Map<String, String> req) {
        return bugService.createBug(req.get("title"), req.get("description"), req.get("priority"), req.get("username"));
    }

    @PostMapping("/assign")
    public Bug assignBug(@RequestParam Long bugId, @RequestParam Long devId) {
        return bugService.assignBug(bugId, devId);
    }

    @PostMapping("/status")
    public Bug updateStatus(@RequestParam Long bugId, @RequestParam String status) {
        return bugService.updateStatus(bugId, status);
    }

    @GetMapping("/assigned")
    public List<Bug> getAssignedBugs(@RequestParam Long userId) {
        return bugService.getAssignedBugs(userId);
    }
}

