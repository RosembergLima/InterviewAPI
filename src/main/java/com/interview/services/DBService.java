package com.interview.services;

import java.text.ParseException;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.domains.Candidate;
import com.interview.domains.CandidateSlot;
import com.interview.domains.Recruiter;
import com.interview.domains.RecruiterSlot;
import com.interview.repositories.CandidateRepository;
import com.interview.repositories.CandidateSlotRepository;
import com.interview.repositories.RecruiterRepository;
import com.interview.repositories.RecruiterSlotRepository;

@Service
public class DBService {

	@Autowired
	private RecruiterRepository recruiterRepo;

	@Autowired
	private RecruiterSlotRepository recruiterSlotRepo;

	@Autowired
	private CandidateRepository candidateRepo;

	@Autowired
	private CandidateSlotRepository candidateSlotRepo;
	
	@Autowired
	private CandidateSlotService candidateSlotService;

	public void instanciateTestDatabase() throws ParseException {

		Candidate carl = new Candidate("Carl Batista", "carl.batista@gmail.com");
		candidateRepo.save(carl);

		Recruiter ines = new Recruiter("Ines Matilde", "ines.matilde@xgeeks.com");
		recruiterRepo.save(ines);

		Recruiter ingrid = new Recruiter("Ingrid Maria", "ingrid.maria@xgeeks.com");
		recruiterRepo.save(ingrid);

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		cal.set(2021, 10, 8); // Monday
//		candidateSlotRepo.save(new CandidateSlot(carl, 9, 10, cal.getTime()));

		recruiterSlotRepo.save(new RecruiterSlot(ines, 9, 10, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 10, 11, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 11, 12, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 12, 13, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 13, 14, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 14, 15, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 15, 16, cal.getTime()));
		
		recruiterSlotRepo.save(new RecruiterSlot(ingrid, 12, 13, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ingrid, 13, 14, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ingrid, 14, 15, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ingrid, 15, 16, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ingrid, 16, 17, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ingrid, 17, 18, cal.getTime()));
		
		candidateSlotService.insert(new CandidateSlot(carl, 9, 10, cal.getTime()));

		cal.set(2021, 10, 9); // Tuesday
//		candidateSlotRepo.save(new CandidateSlot(carl, 9, 10, cal.getTime()));

		recruiterSlotRepo.save(new RecruiterSlot(ines, 9, 10, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 10, 11, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 11, 12, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 12, 13, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 13, 14, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 14, 15, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 15, 16, cal.getTime()));
		
		recruiterSlotRepo.save(new RecruiterSlot(ingrid, 9, 10, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ingrid, 10, 11, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ingrid, 11, 12, cal.getTime()));
		
		candidateSlotService.insert(new CandidateSlot(carl, 9, 10, cal.getTime()));

		cal.set(2021, 10, 10); // Wednesday
//		candidateSlotRepo.save(new CandidateSlot(carl, 9, 12, cal.getTime()));

		recruiterSlotRepo.save(new RecruiterSlot(ines, 9, 10, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 10, 11, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 11, 12, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 12, 13, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 13, 14, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 14, 15, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 15, 16, cal.getTime()));
		
		recruiterSlotRepo.save(new RecruiterSlot(ingrid, 12, 13, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ingrid, 13, 14, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ingrid, 14, 15, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ingrid, 15, 16, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ingrid, 16, 17, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ingrid, 17, 18, cal.getTime()));
		
		candidateSlotService.insert(new CandidateSlot(carl, 9, 10, cal.getTime()));

		cal.set(2021, 10, 11); // Thursday
//		candidateSlotRepo.save(new CandidateSlot(carl, 9, 10, cal.getTime()));

		recruiterSlotRepo.save(new RecruiterSlot(ines, 9, 10, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 10, 11, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 11, 12, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 12, 13, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 13, 14, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 14, 15, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 15, 16, cal.getTime()));
		
		recruiterSlotRepo.save(new RecruiterSlot(ingrid, 9, 10, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ingrid, 10, 11, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ingrid, 11, 12, cal.getTime()));
		
		candidateSlotService.insert(new CandidateSlot(carl, 9, 10, cal.getTime()));

		cal.set(2021, 10, 12); // Friday
//		candidateSlotRepo.save(new CandidateSlot(carl, 9, 10, cal.getTime()));

		recruiterSlotRepo.save(new RecruiterSlot(ines, 9, 10, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 10, 11, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 11, 12, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 12, 13, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 13, 14, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 14, 15, cal.getTime()));
		recruiterSlotRepo.save(new RecruiterSlot(ines, 15, 16, cal.getTime()));
		
		candidateSlotService.insert(new CandidateSlot(carl, 9, 10, cal.getTime()));

	}

}
