package com.JobSearchPlatform.JobSearchPlatform.JobController;

import com.JobSearchPlatform.JobSearchPlatform.JobModel.Profile;
import com.JobSearchPlatform.JobSearchPlatform.JobRepository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @PostMapping
    public Profile createProfile(@RequestBody Profile profile) {
        return profileRepository.save(profile);
    }

    @GetMapping("/{id}")
    public Profile getProfileById(@PathVariable Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Long id) {
        profileRepository.deleteById(id);
    }
}
