package br.com.testcode.eletronicvoting.mappers;

import br.com.testcode.eletronicvoting.models.entities.Subject;
import br.com.testcode.eletronicvoting.models.entities.Voting;
import br.com.testcode.eletronicvoting.models.enums.VoteEnum;
import br.com.testcode.eletronicvoting.models.vos.VoteVO;
import org.springframework.stereotype.Component;

@Component
public class VotingRequestMapper implements RequestMapper<Voting, VoteVO> {

	@Override
	public Voting toModel(VoteVO request) {
		return Voting.builder()
				.cpf(request.getCpf())
				.subject(Subject.builder().id(request.getSubjectId()).build())
				.vote(VoteEnum.getType(request.getVote()))
				.build();
	}

}
