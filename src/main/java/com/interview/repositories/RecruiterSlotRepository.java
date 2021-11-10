package com.interview.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.domains.RecruiterSlot;

@Repository
public interface RecruiterSlotRepository extends JpaRepository<RecruiterSlot, Integer>{

	List<RecruiterSlot> findByTime(Date time);

}
