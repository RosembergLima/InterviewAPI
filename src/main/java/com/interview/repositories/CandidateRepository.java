package com.interview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.domains.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer>{

	Candidate findByEmail(String email);

}
