package com.cbc.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbc.bank.entity.Schedule;
import com.cbc.bank.exception.ResourceNotFoundException;
import com.cbc.bank.repository.ScheduleRepository;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    // Get all schedules
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    // Get schedule by ID
    public Schedule getScheduleById(int scheduleId) {
        return scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not found with id: " + scheduleId));
    }

    // Add a new schedule
    public Schedule addSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    // Update schedule details
    public Schedule updateSchedule(int scheduleId, Schedule newSchedule) {
        return scheduleRepository.findById(scheduleId).map(schedule -> {
            newSchedule.setScheduleId(scheduleId);
            return scheduleRepository.save(newSchedule);
        }).orElseThrow(() -> new ResourceNotFoundException("Schedule not found with id: " + scheduleId));
    }

    // Update schedule name
    public String updateScheduleName(int scheduleId, String newName) {
        Schedule schedule = getScheduleById(scheduleId);
        newName = newName.replaceAll("\\r\\n", ""); // Remove \r\n characters
        schedule.setName(newName);
        scheduleRepository.save(schedule);
        return "Schedule Name updated successfully";
    }

    // Update schedule status
    public String updateScheduleStatus(int scheduleId, String newStatus) {
        Schedule schedule = getScheduleById(scheduleId);
        newStatus = newStatus.replaceAll("\\r\\n", ""); // Remove \r\n characters
        schedule.setStatus(newStatus);
        scheduleRepository.save(schedule);
        return "Schedule Status updated successfully";
    }

    // Delete a schedule by ID
    public boolean deleteSchedule(int scheduleId) {
        if (scheduleRepository.existsById(scheduleId)) {
            scheduleRepository.deleteById(scheduleId);
            return true;
        } else {
            throw new ResourceNotFoundException("Schedule not found with id: " + scheduleId);
        }
    }
}
