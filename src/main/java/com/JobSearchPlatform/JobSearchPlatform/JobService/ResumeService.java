package com.JobSearchPlatform.JobSearchPlatform.JobService;

import com.JobSearchPlatform.JobSearchPlatform.JobModel.Resume;
import com.JobSearchPlatform.JobSearchPlatform.JobRepository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    public Resume createOrUpdateResume(Resume resume) {
        return resumeRepository.save(resume);
    }

    public Optional<Resume> getResumeByProfileId(Long profileId) {
        return Optional.ofNullable(resumeRepository.findByProfileId(profileId));
    }

    public void deleteResume(Long id) {
        resumeRepository.deleteById(id);
    }
}

