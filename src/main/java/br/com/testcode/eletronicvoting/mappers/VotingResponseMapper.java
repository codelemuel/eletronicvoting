package br.com.testcode.eletronicvoting.mappers;

import br.com.testcode.eletronicvoting.models.dtos.ResultCountGroupDTO;
import br.com.testcode.eletronicvoting.models.enums.VoteEnum;
import br.com.testcode.eletronicvoting.models.interfaces.IResultCountGroup;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class VotingResponseMapper implements ResponseMapper<List<IResultCountGroup>, List<ResultCountGroupDTO>> {

	@Override
	public List<ResultCountGroupDTO> toResponse(List<IResultCountGroup> models) {
		return models.stream()
				.map(i -> ResultCountGroupDTO.builder()
						.voteEnum(i.getVoteEnum())
						.quantity(i.getQuantity())
						.build())
				.collect(Collectors.toList());
	}

}
