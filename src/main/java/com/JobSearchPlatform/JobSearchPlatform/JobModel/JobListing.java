package com.JobSearchPlatform.JobSearchPlatform.JobModel;

import jakarta.persistence.*;

@Entity
@Table(name = "job_listings")
public class JobListing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the ID for MySQL
    private Long id;

    private String title;
    private String company;
    private String location;
    private String description;
    private String category;  // e.g., IT, Marketing, etc.
    private String employmentType;  // Full-time, Part-time, Contract, etc.
    private double salary;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
