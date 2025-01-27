package com.JobSearchPlatform.JobSearchPlatform.JobController;


import com.JobSearchPlatform.JobSearchPlatform.JobModel.InterviewSchedule;
import com.JobSearchPlatform.JobSearchPlatform.JobService.InterviewScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/interview-schedules")
public class InterviewScheduleController {

    @Autowired
    private InterviewScheduleService interviewScheduleService;

    @PostMapping
    public ResponseEntity<InterviewSchedule> scheduleInterview(@RequestBody InterviewSchedule interviewSchedule) {
        InterviewSchedule createdSchedule = interviewScheduleService.scheduleInterview(interviewSchedule);
        return ResponseEntity.ok(createdSchedule);
    }

    @GetMapping
    public ResponseEntity<List<InterviewSchedule>> getAllSchedules() {
        List<InterviewSchedule> schedules = interviewScheduleService.getAllSchedules();
        return ResponseEntity.ok(schedules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InterviewSchedule> getScheduleById(@PathVariable Long id) {
        Optional<InterviewSchedule> schedule = interviewScheduleService.getScheduleById(id);
        return schedule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterviewSchedule> updateSchedule(@PathVariable Long id, @RequestBody InterviewSchedule updatedSchedule) {
        try {
            InterviewSchedule schedule = interviewScheduleService.updateSchedule(id, updatedSchedule);
            return ResponseEntity.ok(schedule);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        interviewScheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
