package com.interview.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.interview.domains.RecruiterSlot;
import com.interview.repositories.RecruiterSlotRepository;
import com.interview.services.exception.DataIntegrityException;
import com.interview.services.exception.ObjectNotFoundException;

@Service
public class RecruiterSlotService {

	@Autowired
	private RecruiterSlotRepository repo;

	@Autowired
	private ScheduleService scheduleService;

	@Transactional
	public RecruiterSlot insert(RecruiterSlot obj) {
		obj = repo.save(obj);
		scheduleService.verifyMatch(obj);
		return obj;
	}

	public List<RecruiterSlot> findAll() {
		return repo.findAll();
	}

	public RecruiterSlot update(RecruiterSlot obj) {
		RecruiterSlot newObj = find(obj.getId());
		return repo.save(newObj);
	}

	public RecruiterSlot find(Integer id) throws ObjectNotFoundException {
		Optional<RecruiterSlot> cat = repo.findById(id);
		return cat.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Object:  " + RecruiterSlot.class.getName()));
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("It's not possible remove a Recruiter with dependecy");
		}
	}

	public List<RecruiterSlot> findAllByTime(Date time) {
		return repo.findByTime(time);
	}

}
