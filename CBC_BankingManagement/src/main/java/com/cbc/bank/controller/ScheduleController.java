package com.cbc.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cbc.bank.entity.Schedule;
import com.cbc.bank.service.ScheduleService;

@RestController
@RequestMapping("/api/schedules") 
@CrossOrigin("http://localhost:4200")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    // Get all schedules
    @GetMapping
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    // Get schedule by ID
    @GetMapping("/{scheduleId}")
    public Schedule getScheduleById(@PathVariable int scheduleId) {
        return scheduleService.getScheduleById(scheduleId);
    }
    

    // Add new schedule
    @PostMapping
    public Schedule addSchedule(@RequestBody Schedule schedule) {
        return scheduleService.addSchedule(schedule);
    }

    // Update all data in schedule by ID
    @PutMapping("/{scheduleId}")
    public Schedule updateSchedule(@PathVariable int scheduleId, @RequestBody Schedule newSchedule) {
        return scheduleService.updateSchedule(scheduleId, newSchedule);
    }
    
    
    // Update schedule name by ID
    @PutMapping("/name/{scheduleId}")
    public String updateScheduleName(@PathVariable int scheduleId, @RequestBody String newName) {
        return scheduleService.updateScheduleName(scheduleId, newName);
    }
    
    // Update schedule status by ID
    @PutMapping("/status/{scheduleId}")
    public String updateScheduleStatus(@PathVariable int scheduleId, @RequestBody String newStatus) {
        return scheduleService.updateScheduleStatus(scheduleId, newStatus);
    }

    // Delete schedule by ID
    @DeleteMapping("/{scheduleId}")
    public String deleteSchedule(@PathVariable int scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return "Schedule deleted successfully.";
    }
}
