package com.interview.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.interview.domains.CandidateSlot;
import com.interview.repositories.CandidateSlotRepository;
import com.interview.services.exception.DataIntegrityException;
import com.interview.services.exception.ObjectNotFoundException;

@Service
public class CandidateSlotService {

	@Autowired
	private CandidateSlotRepository repo;

	@Autowired
	private ScheduleService scheduleService;

	@Transactional
	public CandidateSlot insert(CandidateSlot obj) {
		List<CandidateSlot> slots = generateSlots(obj);
		repo.saveAll(slots);
		slots.forEach(slot -> scheduleService.verifyMatch(slot));
		return obj;
	}

	private List<CandidateSlot> generateSlots(CandidateSlot obj) {
		List<CandidateSlot> slots = new ArrayList<CandidateSlot>();
		Integer interval = obj.getTimeEnd() - obj.getTimeStart();

		if (interval >= 1) {
			Integer start = obj.getTimeStart();

			for (int i = 0; i < interval; i++) {
				slots.add(new CandidateSlot(obj.getCandidate(), start, start + 1, obj.getTime()));
				start++;
			}
		}

		return slots;
	}

	public List<CandidateSlot> findAll() {
		return repo.findAll();
	}

	public CandidateSlot update(CandidateSlot obj) {
		CandidateSlot newObj = find(obj.getId());
		return repo.save(newObj);
	}

	public CandidateSlot find(Integer id) throws ObjectNotFoundException {
		Optional<CandidateSlot> cat = repo.findById(id);
		return cat.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Object:  " + CandidateSlot.class.getName()));
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("It's not possible remove a CandidateSlot with dependecy");
		}
	}

	public List<CandidateSlot> findAllByTime(Date time) {
		return repo.findAllByTime(time);
	}

}
