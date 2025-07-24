package com.bug_tracker.service;

import com.bug_tracker.entity.Bug;
import com.bug_tracker.entity.User;
import com.bug_tracker.repository.BugRepository;
import com.bug_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BugService {

    @Autowired
    private BugRepository bugRepo;

    @Autowired
    private UserRepository userRepo;

    public Bug createBug(String title, String desc, String priority, String username) {
        User creator = userRepo.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        Bug bug = new Bug();
        bug.setTitle(title);
        bug.setDescription(desc);
        bug.setPriority(priority);
        bug.setStatus("Open");
        bug.setCreatedBy(creator);
        return bugRepo.save(bug);
    }

    public Bug assignBug(Long bugId, Long userId) {
        Bug bug = bugRepo.findById(bugId).orElseThrow();
        User dev = userRepo.findById(userId).orElseThrow();
        bug.setAssignedTo(dev);
        return bugRepo.save(bug);
    }

    public Bug updateStatus(Long bugId, String status) {
        Bug bug = bugRepo.findById(bugId).orElseThrow();
        bug.setStatus(status);

        if ("Fixed".equalsIgnoreCase(status)) {
            System.out.println("Message sent to: " + bug.getCreatedBy().getUsername() + " - Bug fixed!");
        }

        return bugRepo.save(bug);
    }

    public List<Bug> getAssignedBugs(Long userId) {
        User user = userRepo.findById(userId).orElseThrow();
        return bugRepo.findByAssignedTo(user);
    }
}
