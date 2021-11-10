package com.interview.domains;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer timeStart;
	private Integer timeEnd;
	private Date time;
	
	@ManyToOne
	@JoinColumn(name = "recruiter_id")
	private Recruiter recruiter;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	
	public Schedule() {
	}
	
	public Schedule(Integer timeStart, Integer timeEnd, Date time, Recruiter recruiter, Candidate candidate) {
		super();
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.time = time;
		this.recruiter = recruiter;
		this.candidate = candidate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Integer timeStart) {
		this.timeStart = timeStart;
	}

	public Integer getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Integer timeEnd) {
		this.timeEnd = timeEnd;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Recruiter getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

}
