package br.com.testcode.eletronicvoting.services.impl;

import br.com.testcode.eletronicvoting.mappers.RequestMapper;
import br.com.testcode.eletronicvoting.mappers.ResponseMapper;
import br.com.testcode.eletronicvoting.models.dtos.ResultCountGroupDTO;
import br.com.testcode.eletronicvoting.models.entities.Subject;
import br.com.testcode.eletronicvoting.models.entities.Voting;
import br.com.testcode.eletronicvoting.models.interfaces.IResultCountGroup;
import br.com.testcode.eletronicvoting.models.vos.VoteVO;
import br.com.testcode.eletronicvoting.repositories.VotingRepository;
import br.com.testcode.eletronicvoting.services.VotingService;
import br.com.testcode.eletronicvoting.validators.VotingValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotingServiceImpl implements VotingService {

	private final VotingRepository repository;
	private final RequestMapper<Voting, VoteVO> requestMapper;
	private final ResponseMapper<List<IResultCountGroup>, List<ResultCountGroupDTO>> responseMapper;

	@Autowired
	public VotingServiceImpl(VotingRepository repository,
	                         RequestMapper<Voting, VoteVO> requestMapper,
	                         ResponseMapper<List<IResultCountGroup>, List<ResultCountGroupDTO>> responseMapper) {
		this.repository = repository;
		this.requestMapper = requestMapper;
		this.responseMapper = responseMapper;
	}

	@Override
	public void computeVote(VoteVO voteVO) {
		repository.save(requestMapper.toModel(voteVO));
	}

	@Override
	public List<ResultCountGroupDTO> countsGroupsVotesBySubjectId(Integer subjectId) {
		List<IResultCountGroup> resultCountGroups = repository.getCountBySubjectId(subjectId);
		VotingValidator.validateVotes(resultCountGroups);
		return responseMapper.toResponse(resultCountGroups);
	}

	public void validateVoting(VoteVO voteVO, String status) {
		Voting voting = repository.getByIdCpfAndSubjectId(voteVO.getCpf(), voteVO.getSubjectId());
		VotingValidator.validateVoting(voting, status);
	}

}
