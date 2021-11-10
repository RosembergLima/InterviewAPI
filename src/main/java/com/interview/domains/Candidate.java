package com.interview.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Candidate implements Serializable {

	private static final long serialVersionUID = -8794647234630055510L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;

	@OneToMany(mappedBy = "candidate")
	private List<CandidateSlot> candidateSlots = new ArrayList<>();

	public Candidate() {
	}

	public Candidate(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CandidateSlot> getCandidateSlots() {
		return candidateSlots;
	}

	public void setCandidateSlots(List<CandidateSlot> candidateSlots) {
		this.candidateSlots = candidateSlots;
	}

}
