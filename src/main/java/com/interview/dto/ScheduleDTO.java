package com.interview.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.interview.domains.Schedule;

public class ScheduleDTO {

	private Integer timeStart;
	private Integer timeEnd;
	private String candidate;
	private String recruiter;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date time;

	public ScheduleDTO(Schedule obj) {
		this.timeStart = obj.getTimeStart();
		this.timeEnd = obj.getTimeEnd();
		this.time = obj.getTime();
		this.candidate = obj.getCandidate().getName();
		this.recruiter = obj.getRecruiter().getName();
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

	public String getCandidate() {
		return candidate;
	}

	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}

	public String getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(String recruiter) {
		this.recruiter = recruiter;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
