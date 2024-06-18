package br.com.testcode.eletronicvoting.business;

import br.com.testcode.eletronicvoting.clients.CpfValidClient;
import br.com.testcode.eletronicvoting.models.dtos.ResultCountGroupDTO;
import br.com.testcode.eletronicvoting.models.enums.VoteEnum;
import br.com.testcode.eletronicvoting.models.vos.VoteVO;
import br.com.testcode.eletronicvoting.services.SubjectService;
import br.com.testcode.eletronicvoting.services.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VotingBusiness {

	private final VotingService votingService;
	private final SubjectService subjectService;
	private final CpfValidClient cpfValidClient;

	@Autowired
	public VotingBusiness(VotingService votingService,
	                      SubjectService subjectService,
	                      CpfValidClient cpfValidClient) {
		this.votingService = votingService;
		this.subjectService = subjectService;
		this.cpfValidClient = cpfValidClient;
	}

	public void registerVote(VoteVO voteVO) {
		subjectService.validateSession(voteVO.getSubjectId());
		//TODO: url testada em postman, porém não está alterando os valores de retorno, está mantendo sempre 404
//		votingService.validateVoting(voteVO, cpfValidClient.getStatusCpf(Long.getLong(voteVO.getCpf())).getStatus());
		votingService.validateVoting(voteVO, "ABLE_TO_VOTE");
		votingService.computeVote(voteVO);
	}


	public String getCountResult(Integer subjectId) {
		List<ResultCountGroupDTO> votingGroup = votingService.countsGroupsVotesBySubjectId(subjectId);
		return calculateCountResult(votingGroup);
	}

	private String calculateCountResult(List<ResultCountGroupDTO> votingGroup) {
		int yesQuantity = getQuantityByEnum(votingGroup, VoteEnum.SIM);
		int noQuantity = getQuantityByEnum(votingGroup, VoteEnum.NAO);

		return convertToString(Integer.compare(yesQuantity, noQuantity));
	}

	private int getQuantityByEnum(List<ResultCountGroupDTO> votingGroup, VoteEnum voteEnum) {
		Optional<ResultCountGroupDTO> votes = votingGroup.stream()
				.filter(i -> i.getVoteEnum().equals(voteEnum))
				.findFirst();
		return votes.isEmpty() ? 0 : votes.get().getQuantity();
	}

	private String convertToString(int comparedResult) {
		String message = "Após contagem dos votos, a pauta/assunto está {}.";
		return message.replace("{}", switchCompared(comparedResult));
	}

	private String switchCompared(int comparedResult) {
		switch (comparedResult) {
			case 1:
				return "APROVADA";
			case -1:
				return "REPROVADA";
			default:
				return "EMPATADA";
		}
	}

}
