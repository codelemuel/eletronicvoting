package br.com.testcode.eletronicvoting.models.interfaces;

import br.com.testcode.eletronicvoting.models.enums.VoteEnum;

public interface IResultCountGroup {

	VoteEnum getVoteEnum();
	Integer getQuantity();

}
