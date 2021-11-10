package com.interview.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.interview.domains.CandidateSlot;
import com.interview.domains.RecruiterSlot;
import com.interview.domains.Schedule;
import com.interview.repositories.ScheduleRepository;
import com.interview.services.exception.DataIntegrityException;
import com.interview.services.exception.IncorrectDataException;
import com.interview.services.exception.ObjectNotFoundException;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository repo;

	@Autowired
	private RecruiterSlotService recruiterSlotService;

	@Autowired
	private CandidateSlotService candidateSlotService;

	@Transactional
	public Schedule insert(Schedule obj) {
		obj = repo.save(obj);
		return obj;
	}

	public List<Schedule> findAll() {
		return repo.findAll();
	}

	public Schedule update(Schedule obj) {
		Schedule newObj = find(obj.getId());
		return repo.save(newObj);
	}

	public Schedule find(Integer id) throws ObjectNotFoundException {
		Optional<Schedule> cat = repo.findById(id);
		return cat.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Object:  " + Schedule.class.getName()));
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("It's not possible remove a Schedule with dependecy");
		}
	}

	public List<Schedule> findByTime(Integer ano, Integer mes, Integer dia) {
		Calendar cal = Calendar.getInstance();
		cal.set(ano, mes - 1, dia);
		return repo.findAllByTime(cal.getTime());
	}

	public void verifyMatch(CandidateSlot obj) {
		List<RecruiterSlot> recruiterSlots = recruiterSlotService.findAllByTime(obj.getTime());

		List<RecruiterSlot> matchSlots = recruiterSlots.stream()
				.filter(slot -> slot.getTimeStart() == obj.getTimeStart() && slot.getTimeEnd() == obj.getTimeEnd())
				.collect(Collectors.toList());

		matchSlots.forEach(slot -> insert(new Schedule(obj.getTimeStart(), obj.getTimeEnd(), obj.getTime(),
				slot.getRecruiter(), obj.getCandidate())));

	}

	public void verifyMatch(RecruiterSlot obj) {
		List<CandidateSlot> candidateSlots = candidateSlotService.findAllByTime(obj.getTime());

		List<CandidateSlot> matchSlots = candidateSlots.stream()
				.filter(slot -> slot.getTimeStart() == obj.getTimeStart() && slot.getTimeEnd() == obj.getTimeEnd())
				.collect(Collectors.toList());

		matchSlots.forEach(slot -> insert(new Schedule(obj.getTimeStart(), obj.getTimeEnd(), obj.getTime(),
				obj.getRecruiter(), slot.getCandidate())));

	}

	public List<Schedule> findByPeriod(String timesStart, String timesEnd) {
		List<Schedule> schedules = new ArrayList<Schedule>();
		try {
			Date start = new SimpleDateFormat("yyyy-MM-dd").parse(timesStart);
			Date end = new SimpleDateFormat("yyyy-MM-dd").parse(timesEnd);

			schedules.addAll(repo.findByTimeBetween(start, end));

		} catch (Exception e) {
			new IncorrectDataException("Incorret Data! Start Date: " + timesStart + ", End Date: " + timesEnd
					+ ", Data Format Expected: dd/MM/yyyy - " + "Object:  " + Schedule.class.getName());
		}

		return schedules;
	}

}
