package com.JobSearchPlatform.JobSearchPlatform.JobService;

import com.JobSearchPlatform.JobSearchPlatform.JobModel.Notification;
import com.JobSearchPlatform.JobSearchPlatform.JobModel.Profile;
import com.JobSearchPlatform.JobSearchPlatform.JobModel.JobListing;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    // Method to send job alert notifications
    public void sendJobAlert(Profile profile, JobListing jobListing, String message) {
        // In this case, we're simply printing the notification, but this could be an email/SMS/etc.
        System.out.println("Notification sent to " + profile.getFirstName() + " " + profile.getLastName());
        System.out.println("Job Title: " + jobListing.getTitle());
        System.out.println("Company: " + jobListing.getCompany());
        System.out.println("Location: " + jobListing.getLocation());
        System.out.println("Message: " + message);
        // You can implement email or other real-world notification logic here
    }

    public Notification sendNotification(Notification notification) {
        return notification;
    }

    public List<Notification> getNotificationsByProfileId(Long profileId) {
        return getNotificationsByProfileId(profileId);
    }

    public void markAsRead(Long notificationId) {
        System.out.println("read");
    }
}
