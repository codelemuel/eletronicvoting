package br.com.testcode.eletronicvoting.validators;

import br.com.testcode.eletronicvoting.models.entities.Subject;
import br.com.testcode.eletronicvoting.models.entities.Voting;
import br.com.testcode.eletronicvoting.models.interfaces.IResultCountGroup;
import br.com.testcode.eletronicvoting.utils.CpfUtil;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

public class VotingValidator {

	public static void validateVotes(List<IResultCountGroup> resultCountGroups) {
		if (resultCountGroups.isEmpty()) {
			throw new EntityNotFoundException("Sem votos para calcular resultado da assembléia.");
		}
	}

	public static void validateVoting(Voting voting, String status) {
		if (voting != null) {
			throw new EntityExistsException("Voto já computado para associado do cpf "
					+ CpfUtil.format(voting.getCpf()) + ".");
		}

		if (status.equals("UNABLE_TO_VOTE")) {
			throw new EntityExistsException("o cpf não é válido para efetuar voto.");
		}
	}
}
