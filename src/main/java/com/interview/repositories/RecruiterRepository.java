package com.interview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.domains.Recruiter;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Integer>{

}
