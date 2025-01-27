package com.JobSearchPlatform.JobSearchPlatform.JobRepository;

import com.JobSearchPlatform.JobSearchPlatform.JobModel.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobListingRepository extends JpaRepository<JobListing, Long> {

    @Query("SELECT j FROM JobListing j WHERE " +
            "(:title IS NULL OR LOWER(j.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
            "(:company IS NULL OR LOWER(j.company) LIKE LOWER(CONCAT('%', :company, '%'))) AND " +
            "(:location IS NULL OR LOWER(j.location) LIKE LOWER(CONCAT('%', :location, '%'))) AND " +
            "(:category IS NULL OR LOWER(j.category) LIKE LOWER(CONCAT('%', :category, '%'))) AND " +
            "(:employmentType IS NULL OR LOWER(j.employmentType) LIKE LOWER(CONCAT('%', :employmentType, '%'))) AND " +
            "(:salary IS NULL OR j.salary >= :salary)")
    List<JobListing> searchJobs(String title, String company, String location, String category, String employmentType, Double salary);
}
