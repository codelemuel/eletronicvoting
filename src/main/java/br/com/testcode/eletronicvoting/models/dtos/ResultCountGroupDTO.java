package br.com.testcode.eletronicvoting.models.dtos;

import br.com.testcode.eletronicvoting.models.enums.VoteEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultCountGroupDTO {

	public VoteEnum voteEnum;
	public Integer quantity;

}
