package com.JobSearchPlatform.JobSearchPlatform.JobController;

import com.JobSearchPlatform.JobSearchPlatform.JobModel.Notification;
import com.JobSearchPlatform.JobSearchPlatform.JobService.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // Endpoint to send a notification
    @PostMapping
    public ResponseEntity<Notification> sendNotification(@RequestBody Notification notification) {
        Notification savedNotification = notificationService.sendNotification(notification);
        return ResponseEntity.ok(savedNotification);
    }

    // Endpoint to get notifications by profileId
    @GetMapping("/{profileId}")
    public ResponseEntity<List<Notification>> getNotificationsByProfileId(@PathVariable Long profileId) {
        List<Notification> notifications = notificationService.getNotificationsByProfileId(profileId);
        return ResponseEntity.ok(notifications);
    }

    // Endpoint to mark a notification as read
    @PutMapping("/{notificationId}/read")
    public ResponseEntity<Void> markNotificationAsRead(@PathVariable Long notificationId) {
        notificationService.markAsRead(notificationId);
        return ResponseEntity.noContent().build();
    }
}
