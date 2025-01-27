package com.JobSearchPlatform.JobSearchPlatform.JobService;


import com.JobSearchPlatform.JobSearchPlatform.JobModel.InterviewSchedule;
import com.JobSearchPlatform.JobSearchPlatform.JobRepository.InterviewScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewScheduleService {

    @Autowired
    private InterviewScheduleRepository interviewScheduleRepository;

    public InterviewSchedule scheduleInterview(InterviewSchedule interviewSchedule) {
        return interviewScheduleRepository.save(interviewSchedule);
    }

    public List<InterviewSchedule> getAllSchedules() {
        return interviewScheduleRepository.findAll();
    }

    public Optional<InterviewSchedule> getScheduleById(Long id) {
        return interviewScheduleRepository.findById(id);
    }

    public InterviewSchedule updateSchedule(Long id, InterviewSchedule updatedSchedule) {
        Optional<InterviewSchedule> optionalSchedule = interviewScheduleRepository.findById(id);
        if (optionalSchedule.isPresent()) {
            InterviewSchedule schedule = optionalSchedule.get();
            schedule.setInterviewDate(updatedSchedule.getInterviewDate());
            schedule.setMode(updatedSchedule.getMode());
            schedule.setInterviewerName(updatedSchedule.getInterviewerName());
            schedule.setInterviewStatus(updatedSchedule.getInterviewStatus());
            return interviewScheduleRepository.save(schedule);
        }
        throw new RuntimeException("Schedule not found with id " + id);
    }

    public void deleteSchedule(Long id) {
        interviewScheduleRepository.deleteById(id);
    }
}