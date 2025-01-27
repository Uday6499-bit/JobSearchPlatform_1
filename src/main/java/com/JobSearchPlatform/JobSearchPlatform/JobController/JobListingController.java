package com.JobSearchPlatform.JobSearchPlatform.JobController;

import com.JobSearchPlatform.JobSearchPlatform.JobModel.JobListing;
import com.JobSearchPlatform.JobSearchPlatform.JobService.JobListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobListingController {

    @Autowired
    private JobListingService jobListingService;

    @GetMapping("/test")
    public String testEndpoint() {
        return "Test Success!";
    }

    @GetMapping("/search")
    public List<JobListing> searchJobs(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String company,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String employmentType,
            @RequestParam(required = false) Double salary) {
        try {
            List<JobListing> jobListings = jobListingService.searchJobs(title, company, location, category, employmentType, salary);
            if (jobListings.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No jobs found matching the criteria");
            }
            return jobListings;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error processing request", e);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JobListing createJobListing(@RequestBody JobListing jobListing) {
        return jobListingService.createJobListing(jobListing); // Call the createJobListing method
    }
}
