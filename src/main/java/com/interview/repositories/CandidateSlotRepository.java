package com.interview.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.domains.CandidateSlot;

@Repository
public interface CandidateSlotRepository extends JpaRepository<CandidateSlot, Integer>{

	List<CandidateSlot> findAllByTime(Date time);

}
