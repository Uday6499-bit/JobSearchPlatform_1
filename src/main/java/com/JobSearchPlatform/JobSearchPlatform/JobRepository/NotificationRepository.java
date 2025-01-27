package com.JobSearchPlatform.JobSearchPlatform.JobRepository;

import com.JobSearchPlatform.JobSearchPlatform.JobModel.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // Find notifications by profile ID
    List<Notification> findByProfileId(Long profileId);
}

