package com.JobSearchPlatform.JobSearchPlatform.JobRepository;


import com.JobSearchPlatform.JobSearchPlatform.JobModel.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    // This method will find profiles that have a skill matching the job's category
    List<Profile> findBySkillsContaining(String skills);
}
