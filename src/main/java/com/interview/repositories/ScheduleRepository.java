package com.interview.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.domains.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{

	List<Schedule> findAllByTime(Date time);

	List<Schedule> findByTimeBetween(Date start, Date end);


}
