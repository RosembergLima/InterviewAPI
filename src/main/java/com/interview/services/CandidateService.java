package com.interview.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.interview.domains.Candidate;
import com.interview.domains.CandidateSlot;
import com.interview.dto.CandidateSlotDTO;
import com.interview.repositories.CandidateRepository;
import com.interview.services.exception.DataIntegrityException;
import com.interview.services.exception.ObjectNotFoundException;

@Service
public class CandidateService {

	@Autowired
	private CandidateRepository repo;

	@Autowired
	private CandidateSlotService candidateSlotService;

	@Transactional
	public Candidate insert(CandidateSlotDTO obj) {

		Candidate candidate = findByEmail(obj.getEmail());

		if (candidate == null)
			candidate = repo.save(new Candidate(obj.getCandidate(), obj.getEmail()));

		candidateSlotService.insert(new CandidateSlot(candidate, obj.getTimeStart(), obj.getTimeEnd(), obj.getTime()));
		return candidate;
	}

	public List<Candidate> findAll() {
		return repo.findAll();
	}

	public Candidate update(Candidate obj) {
		Candidate newObj = find(obj.getId());
		return repo.save(newObj);
	}

	public Candidate find(Integer id) throws ObjectNotFoundException {
		Optional<Candidate> cat = repo.findById(id);
		return cat.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Object:  " + Candidate.class.getName()));
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("It's not possible remove a Candidate with dependecy");
		}
	}

	private Candidate findByEmail(String email) {
		return repo.findByEmail(email);
	}

}
