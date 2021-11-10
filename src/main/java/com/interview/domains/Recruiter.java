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
public class Recruiter implements Serializable {

	private static final long serialVersionUID = -8352463266585025283L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	@OneToMany(mappedBy = "recruiter")
	private List<RecruiterSlot> recruiterSlots = new ArrayList<>();

	public Recruiter() {
	}
	
	public Recruiter(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	private String email;

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

	public List<RecruiterSlot> getRecruiterSlots() {
		return recruiterSlots;
	}

	public void setRecruiterSlots(List<RecruiterSlot> recruiterSlots) {
		this.recruiterSlots = recruiterSlots;
	}

}
