package com.JobSearchPlatform.JobSearchPlatform.JobRepository;


import com.JobSearchPlatform.JobSearchPlatform.JobModel.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    // Custom query method to find applications by profile
    List<JobApplication> findByProfileId(Long profileId);

    // Custom query method to find applications by job listing
    List<JobApplication> findByJobListingId(Long jobListingId);
}
