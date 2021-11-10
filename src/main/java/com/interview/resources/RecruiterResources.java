package com.interview.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.interview.domains.Recruiter;
import com.interview.services.RecruiterService;

@RestController
@RequestMapping(value = "/recruites")
public class RecruiterResources {
	
	@Autowired
	private RecruiterService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> add(@RequestBody Recruiter obj) {

		Recruiter candidade = service.insert(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(candidade.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Recruiter>> findAll() {
		List<Recruiter> recruiters = service.findAll();
		return ResponseEntity.ok().body(recruiters);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Recruiter> find(@PathVariable Integer id) {
		Recruiter obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> get(@RequestBody Recruiter obj) {
		service.insert(obj);
		return ResponseEntity.noContent().build();
	}



}
