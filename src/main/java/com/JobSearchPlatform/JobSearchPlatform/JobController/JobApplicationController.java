package com.JobSearchPlatform.JobSearchPlatform.JobController;

import com.JobSearchPlatform.JobSearchPlatform.JobModel.JobApplication;
import com.JobSearchPlatform.JobSearchPlatform.JobService.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    // Create a new job application
    @PostMapping
    public ResponseEntity<JobApplication> createJobApplication(@RequestBody JobApplication jobApplication) {
        JobApplication savedJobApplication = jobApplicationService.save(jobApplication);
        return new ResponseEntity<>(savedJobApplication, HttpStatus.CREATED);
    }

    // Get job application by ID
    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getJobApplication(@PathVariable Long id) {
        JobApplication jobApplication = jobApplicationService.findById(id);
        if (jobApplication == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jobApplication, HttpStatus.OK);
    }

    // Get all job applications for a specific profile (optional)
    @GetMapping("/profile/{profileId}")
    public ResponseEntity<List<JobApplication>> getApplicationsByProfile(@PathVariable Long profileId) {
        List<JobApplication> jobApplications = jobApplicationService.findByProfileId(profileId);
        if (jobApplications.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(jobApplications, HttpStatus.OK);
    }
}
