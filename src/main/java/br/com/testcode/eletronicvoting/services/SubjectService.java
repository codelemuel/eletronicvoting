package br.com.testcode.eletronicvoting.services;

import br.com.testcode.eletronicvoting.models.dtos.SubjectDTO;
import br.com.testcode.eletronicvoting.models.entities.Subject;
import br.com.testcode.eletronicvoting.models.vos.SubjectSessionVO;
import br.com.testcode.eletronicvoting.models.vos.SubjectVO;
import br.com.testcode.eletronicvoting.models.vos.VoteVO;

public interface SubjectService {

	SubjectDTO newSubject(SubjectVO subjectVO);

	String startVotingSession(SubjectSessionVO sessionVO);

	void validateSession(Integer subjectId);
}
