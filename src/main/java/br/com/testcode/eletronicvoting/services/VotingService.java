package br.com.testcode.eletronicvoting.services;

import br.com.testcode.eletronicvoting.models.dtos.ResultCountGroupDTO;
import br.com.testcode.eletronicvoting.models.vos.VoteVO;

import java.util.List;

public interface VotingService {

	void computeVote(VoteVO voteVO);

	List<ResultCountGroupDTO> countsGroupsVotesBySubjectId(Integer subjectId);


	void validateVoting(VoteVO voteVO, String status);
}
