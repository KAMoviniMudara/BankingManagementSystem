package com.cbc.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cbc.bank.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

	Optional<Schedule> findByName(String name);

	
    
}
