package com.interview.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.interview.domains.Schedule;
import com.interview.dto.ScheduleDTO;
import com.interview.services.ScheduleService;

@RestController
@RequestMapping(value = "/schedules")
public class ScheduleResources {

	@Autowired
	private ScheduleService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ScheduleDTO>> findAll() {
		List<Schedule> schedules = service.findAll();

		List<ScheduleDTO> schedulesDto = schedules.stream().map(obj -> new ScheduleDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(schedulesDto);
	}

	@RequestMapping(value = "/{timesStart}/{timesEnd}", method = RequestMethod.GET)
	public ResponseEntity<List<ScheduleDTO>> find(@PathVariable String timesStart, @PathVariable String timesEnd) {
		List<Schedule> schedules = service.findByPeriod(timesStart, timesEnd);
		List<ScheduleDTO> schedulesDto = schedules.stream().map(obj -> new ScheduleDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(schedulesDto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ScheduleDTO> find(@PathVariable Integer id) {
		Schedule obj = service.find(id);
		return ResponseEntity.ok().body(new ScheduleDTO(obj));
	}

}
