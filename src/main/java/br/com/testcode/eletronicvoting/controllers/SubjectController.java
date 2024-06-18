package br.com.testcode.eletronicvoting.controllers;

import br.com.testcode.eletronicvoting.models.dtos.SubjectDTO;
import br.com.testcode.eletronicvoting.models.vos.SubjectSessionVO;
import br.com.testcode.eletronicvoting.models.vos.SubjectVO;
import br.com.testcode.eletronicvoting.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/subject")
public class SubjectController {

	private final SubjectService subjectService;

	@Autowired
	public SubjectController(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SubjectDTO> create(@RequestBody @Valid SubjectVO subjectVO) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(subjectService.newSubject(subjectVO));
	}

	@PostMapping(path = "/start-session", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> startSession(@RequestBody @Valid SubjectSessionVO subjectSessionVO) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(subjectService.startVotingSession(subjectSessionVO));
	}
}
