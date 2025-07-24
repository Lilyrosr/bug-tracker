package com.bug_tracker.repository;

import com.bug_tracker.entity.Bug;
import com.bug_tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BugRepository extends JpaRepository<Bug, Long> {
    List<Bug> findByAssignedTo(User user);
}
