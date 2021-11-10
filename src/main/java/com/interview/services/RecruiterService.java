package com.interview.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.interview.domains.Recruiter;
import com.interview.repositories.RecruiterRepository;
import com.interview.services.exception.DataIntegrityException;
import com.interview.services.exception.ObjectNotFoundException;

@Service
public class RecruiterService {

	@Autowired
	private RecruiterRepository repo;

	@Transactional
	public Recruiter insert(Recruiter obj) {
		obj = repo.save(obj);
		return obj;
	}

	public List<Recruiter> findAll() {
		return repo.findAll();
	}

	public Recruiter update(Recruiter obj) {
		Recruiter newObj = find(obj.getId());
		return repo.save(newObj);
	}

	public Recruiter find(Integer id) throws ObjectNotFoundException {
		Optional<Recruiter> cat = repo.findById(id);
		return cat.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Object:  " + Recruiter.class.getName()));
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("It's not possible remove a Recruiter with dependecy");
		}
	}

	

}
