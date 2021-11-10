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

import com.interview.domains.Candidate;
import com.interview.dto.CandidateSlotDTO;
import com.interview.services.CandidateService;

@RestController
@RequestMapping(value = "/candidates")
public class CandidateResources {

	@Autowired
	private CandidateService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> add(@RequestBody CandidateSlotDTO obj) {

		Candidate candidade = service.insert(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(candidade.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Candidate>> findAll() {
		List<Candidate> candidates = service.findAll();
		return ResponseEntity.ok().body(candidates);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Candidate> find(@PathVariable Integer id) {
		Candidate obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> get(@RequestBody CandidateSlotDTO obj) {
		service.insert(obj);
		return ResponseEntity.noContent().build();
	}

}
