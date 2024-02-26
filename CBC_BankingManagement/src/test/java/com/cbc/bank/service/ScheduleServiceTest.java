package com.cbc.bank.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cbc.bank.entity.Schedule; 
import com.cbc.bank.exception.ResourceNotFoundException; 
import com.cbc.bank.repository.ScheduleRepository;

class ScheduleServiceTest {

    @Mock
    private ScheduleRepository scheduleRepository;

    @InjectMocks
    private ScheduleService scheduleService;

    @SuppressWarnings("deprecation")
	@BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testUpdateSchedule() {
        int scheduleId = 1;
        Schedule existingSchedule = new Schedule();
        Schedule newSchedule = new Schedule();

        when(scheduleRepository.findById(scheduleId)).thenReturn(Optional.of(existingSchedule));
        when(scheduleRepository.save(newSchedule)).thenReturn(newSchedule);

        Schedule updatedSchedule = scheduleService.updateSchedule(scheduleId, newSchedule);

        assertEquals("Updated Schedule", updatedSchedule.getName());
        assertEquals("2024-02-11", updatedSchedule.getStartDate());
        assertEquals("2024-02-11", updatedSchedule.getEndDate());
        assertEquals("Completed", updatedSchedule.getStatus());
    }

    @Test
    void testUpdateSchedule_ThrowsResourceNotFoundException() {
        int scheduleId = 1;
        Schedule newSchedule = new Schedule();

        when(scheduleRepository.findById(scheduleId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            scheduleService.updateSchedule(scheduleId, newSchedule);
        });
    }

    @Test
    void testUpdateScheduleName() {
        int scheduleId = 1;
        String newName = "Updated Schedule Name";

        Schedule existingSchedule = new Schedule();

        when(scheduleRepository.findById(scheduleId)).thenReturn(Optional.of(existingSchedule));

        String result = scheduleService.updateScheduleName(scheduleId, newName);

        assertEquals("Schedule Name updated successfully", result);
        assertEquals(newName, existingSchedule.getName());
    }

    @Test
    void testUpdateScheduleStatus() {
        int scheduleId = 1;
        String newStatus = "Completed";

        Schedule existingSchedule = new Schedule();

        when(scheduleRepository.findById(scheduleId)).thenReturn(Optional.of(existingSchedule));

        String result = scheduleService.updateScheduleStatus(scheduleId, newStatus);

        assertEquals("Schedule Status updated successfully", result);
        assertEquals(newStatus, existingSchedule.getStatus());
    }

}
