package com.JobSearchPlatform.JobSearchPlatform.JobRepository;

import com.JobSearchPlatform.JobSearchPlatform.JobModel.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
    Resume findByProfileId(Long profileId);
}
