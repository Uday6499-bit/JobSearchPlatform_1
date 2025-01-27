package com.JobSearchPlatform.JobSearchPlatform.JobService;

import com.JobSearchPlatform.JobSearchPlatform.JobModel.JobApplication;
import com.JobSearchPlatform.JobSearchPlatform.JobRepository.JobApplicationRepository;
import com.JobSearchPlatform.JobSearchPlatform.JobRepository.JobListingRepository;
import com.JobSearchPlatform.JobSearchPlatform.JobRepository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    private JobListingRepository jobListingRepository;

    @Autowired
    private ProfileRepository profileRepository;

    // Method to apply for a job
    public JobApplication applyForJob(Long profileId, Long jobListingId) {
        // Find the profile and job listing
        var profile = profileRepository.findById(profileId).orElseThrow(() -> new RuntimeException("Profile not found"));
        var jobListing = jobListingRepository.findById(jobListingId).orElseThrow(() -> new RuntimeException("Job listing not found"));

        // Create new job application
        JobApplication jobApplication = new JobApplication();
        jobApplication.setProfile(profile);
        jobApplication.setJobListing(jobListing);
        jobApplication.setApplicationStatus("Applied");  // Default status when applying

        // Save the application
        return jobApplicationRepository.save(jobApplication);
    }

    // Method to get applications by profile
    public List<JobApplication> getApplicationsByProfile(Long profileId) {
        return jobApplicationRepository.findByProfileId(profileId);
    }

    // Method to get applications by job listing
    public List<JobApplication> getApplicationsByJobListing(Long jobListingId) {
        return jobApplicationRepository.findByJobListingId(jobListingId);
    }

    // Method to update application status
    public JobApplication updateApplicationStatus(Long applicationId, String newStatus) {
        var jobApplication = jobApplicationRepository.findById(applicationId).orElseThrow(() -> new RuntimeException("Application not found"));
        jobApplication.setApplicationStatus(newStatus);
        return jobApplicationRepository.save(jobApplication);
    }

    public JobApplication save(JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);
    }

    public JobApplication findById(Long id) {
        return jobApplicationRepository.findById(id).orElseThrow(() -> new RuntimeException("Application not found"));
    }

    public List<JobApplication> findByProfileId(Long profileId) {
        return jobApplicationRepository.findByProfileId(profileId);
    }
}
