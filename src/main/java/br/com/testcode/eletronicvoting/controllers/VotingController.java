package br.com.testcode.eletronicvoting.controllers;

import br.com.testcode.eletronicvoting.business.VotingBusiness;
import br.com.testcode.eletronicvoting.models.vos.VoteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/voting")
public class VotingController {

	private final VotingBusiness business;

	@Autowired
	public VotingController(VotingBusiness business) {
		this.business = business;
	}

	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody @Valid VoteVO voteVO) {
		business.registerVote(voteVO);
	}

	@GetMapping(path = "/calculate-votes/{subjectId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> calculateVotes(@PathVariable Integer subjectId) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(business.getCountResult(subjectId));
	}
}
