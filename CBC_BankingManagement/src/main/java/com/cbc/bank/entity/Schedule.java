package com.cbc.bank.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="schedule")
public class Schedule {
    
    @Id
    @Column(name="schedule_id")
    private int scheduleId;
    
    @Column(name="name")
    private String name;
    
    @Column(name="start_date")
    private LocalDate startDate;
    
    @Column(name="start_time")
    private String startTime;
    
    @Column(name="end_date")
    private LocalDate endDate;
    
    @Column(name="end_time")
    private String endTime;
    
    @Column(name="status")
    private String status;
    
    public Schedule() {
        super();
    }

    // Constructor with parameters
    public Schedule(int scheduleId, String name, LocalDate startDate, String startTime, LocalDate endDate,
            String endTime, String status) {
        super();
        this.scheduleId = scheduleId;
        this.name = name;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.status = status;
    }

    // Getter and setter methods
    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }    
}
