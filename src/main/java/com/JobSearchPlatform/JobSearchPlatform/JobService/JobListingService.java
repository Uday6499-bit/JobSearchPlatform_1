package com.JobSearchPlatform.JobSearchPlatform.JobService;

import com.JobSearchPlatform.JobSearchPlatform.JobModel.JobListing;
import com.JobSearchPlatform.JobSearchPlatform.JobModel.Profile;
import com.JobSearchPlatform.JobSearchPlatform.JobRepository.JobListingRepository;
import com.JobSearchPlatform.JobSearchPlatform.JobRepository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobListingService {

    @Autowired
    private JobListingRepository jobListingRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private NotificationService notificationService;

    /**
     * Searches for job listings based on various parameters.
     * @param title The title of the job.
     * @param company The company offering the job.
     * @param location The location of the job.
     * @param category The category of the job (e.g., IT, Marketing, etc.).
     * @param employmentType The type of employment (e.g., Full-time, Part-time).
     * @param salary The salary range for the job.
     * @return A list of job listings that match the search criteria.
     */
    public List<JobListing> searchJobs(String title, String company, String location,
                                       String category, String employmentType, Double salary) {
        try {
            // If no search parameters are provided, return all job listings
            if (title == null && company == null && location == null &&
                    category == null && employmentType == null && salary == null) {
                return jobListingRepository.findAll();
            }

            // Build the query dynamically based on provided parameters
            if (title != null || company != null || location != null || category != null || employmentType != null || salary != null) {
                return jobListingRepository.searchJobs(title, company, location, category, employmentType, salary);
            }

            // Return empty list if no matching jobs are found
            return List.of();
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
            throw new RuntimeException("Error occurred while searching for jobs", e); // Throw a runtime exception
        }
    }
    public JobListing createJobListing(JobListing jobListing) {
        try {
            // Save the job listing
            JobListing savedJobListing = jobListingRepository.save(jobListing);

            // Send job alerts to profiles matching the job's category or skills
            sendJobAlerts(savedJobListing);

            return savedJobListing;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error occurred while creating job listing", e);
        }
    }

    private void sendJobAlerts(JobListing jobListing) {
        List<Profile> profiles = profileRepository.findAll(); // Get all profiles, you can refine this query to only match relevant profiles

        for (Profile profile : profiles) {
            if (profile.getSkills().contains(jobListing.getCategory())) {
                // Directly send a notification without saving it to the database
                String message = "A new job matching your skills is available!";
                notificationService.sendJobAlert(profile, jobListing, message); // Send notification to the profile
            }
        }
    }
}

