package com.JobSearchPlatform.JobSearchPlatform.JobController;

import com.JobSearchPlatform.JobSearchPlatform.JobModel.Resume;
import com.JobSearchPlatform.JobSearchPlatform.JobService.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/resumes")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping
    public ResponseEntity<Resume> createOrUpdateResume(@RequestBody Resume resume) {
        Resume savedResume = resumeService.createOrUpdateResume(resume);
        return ResponseEntity.ok(savedResume);
    }

    @GetMapping("/{profileId}")
    public ResponseEntity<Resume> getResumeByProfileId(@PathVariable Long profileId) {
        Optional<Resume> resume = resumeService.getResumeByProfileId(profileId);
        return resume.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResume(@PathVariable Long id) {
        resumeService.deleteResume(id);
        return ResponseEntity.noContent().build();
    }
}

