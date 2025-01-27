package com.JobSearchPlatform.JobSearchPlatform.JobModel;

import jakarta.persistence.*;

@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relationship with Profile (One JobApplication is related to one Profile)
    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    // Relationship with JobListing (One JobApplication is related to one JobListing)
    @ManyToOne
    @JoinColumn(name = "job_listing_id", referencedColumnName = "id")
    private JobListing jobListing;

    private String applicationStatus;  // e.g., Applied, Interviewed, Rejected

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public JobListing getJobListing() {
        return jobListing;
    }

    public void setJobListing(JobListing jobListing) {
        this.jobListing = jobListing;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
