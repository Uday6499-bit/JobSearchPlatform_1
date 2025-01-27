package com.JobSearchPlatform.JobSearchPlatform.JobModel;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class InterviewSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_application_id", referencedColumnName = "id")
    private JobApplication jobApplication;

    private LocalDateTime interviewDate;

    private String mode; // e.g., Online, In-person

    private String interviewerName;

    private String interviewStatus; // e.g., Scheduled, Completed, Cancelled

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JobApplication getJobApplication() {
        return jobApplication;
    }

    public void setJobApplication(JobApplication jobApplication) {
        this.jobApplication = jobApplication;
    }

    public LocalDateTime getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDateTime interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getInterviewerName() {
        return interviewerName;
    }

    public void setInterviewerName(String interviewerName) {
        this.interviewerName = interviewerName;
    }

    public String getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(String interviewStatus) {
        this.interviewStatus = interviewStatus;
    }
}
