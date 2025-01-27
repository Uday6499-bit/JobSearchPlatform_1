package com.JobSearchPlatform.JobSearchPlatform.JobService;


import com.JobSearchPlatform.JobSearchPlatform.JobModel.Profile;
import com.JobSearchPlatform.JobSearchPlatform.JobRepository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile createOrUpdateProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Optional<Profile> getProfile(Long userId) {
        return profileRepository.findById(userId);
    }

    public void deleteProfile(Long userId) {
        profileRepository.deleteById(userId);
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }
}

