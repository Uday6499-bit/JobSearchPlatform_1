package com.JobSearchPlatform.JobSearchPlatform.JobRepository;

import com.JobSearchPlatform.JobSearchPlatform.JobModel.InterviewSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewScheduleRepository extends JpaRepository<InterviewSchedule, Long> {
}