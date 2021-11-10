package com.interview.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.interview.domains.CandidateSlot;

public class CandidateSlotDTO {

	private Integer timeStart;
	private Integer timeEnd;
	private String candidate;
	private String email;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date time;

	public CandidateSlotDTO() {
	}
	
	public CandidateSlotDTO(CandidateSlot slot) {
		this.candidate = slot.getCandidate().getName();
		this.email = slot.getCandidate().getEmail();
		this.time = slot.getTime();
		this.timeStart = slot.getTimeStart();
		this.timeEnd = slot.getTimeEnd();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
