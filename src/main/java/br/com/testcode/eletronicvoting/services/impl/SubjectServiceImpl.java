package br.com.testcode.eletronicvoting.services.impl;

import br.com.testcode.eletronicvoting.mappers.RequestMapper;
import br.com.testcode.eletronicvoting.mappers.ResponseMapper;
import br.com.testcode.eletronicvoting.models.dtos.SubjectDTO;
import br.com.testcode.eletronicvoting.models.entities.Subject;
import br.com.testcode.eletronicvoting.models.vos.SubjectSessionVO;
import br.com.testcode.eletronicvoting.models.vos.SubjectVO;
import br.com.testcode.eletronicvoting.models.vos.VoteVO;
import br.com.testcode.eletronicvoting.repositories.SubjectRepository;
import br.com.testcode.eletronicvoting.validators.SubjectValidator;
import br.com.testcode.eletronicvoting.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

	private final SubjectRepository repository;
	private final ResponseMapper<Subject, SubjectDTO> responseMapper;
	private final RequestMapper<Subject, SubjectVO> requestMapper;
	private final RequestMapper<Subject, List<Object>> sessionRequestMapper;
	private final ResponseMapper<Subject, String> sessionResponseMapper;

	@Autowired
	public SubjectServiceImpl(SubjectRepository repository,
	                          ResponseMapper<Subject, SubjectDTO> responseMapper,
	                          RequestMapper<Subject, SubjectVO> requestMapper,
	                          RequestMapper<Subject, List<Object>> sessionRequestMapper,
	                          ResponseMapper<Subject, String> sessionResponseMapper) {
		this.repository = repository;
		this.responseMapper = responseMapper;
		this.requestMapper = requestMapper;
		this.sessionRequestMapper = sessionRequestMapper;
		this.sessionResponseMapper = sessionResponseMapper;
	}

	@Override
	public SubjectDTO newSubject(SubjectVO subjectVO) {
		SubjectValidator.validateDuplicity(repository.findByTitle(subjectVO.getTitle()));

		Subject subject = requestMapper.toModel(subjectVO);

		return responseMapper.toResponse(repository.save(subject));
	}

	@Override
	public String startVotingSession(SubjectSessionVO subjectSessionVO) {
		Subject subject = SubjectValidator.validateSubject(repository.findById(subjectSessionVO.getSubjectId()).orElse(null));

		subject = sessionRequestMapper.toModel(Arrays.asList(subject, subjectSessionVO));

		return sessionResponseMapper.toResponse(repository.save(subject));
	}

	@Override
	public void validateSession(Integer subjectId) {
		Subject subject = repository.findById(subjectId).orElse(null);
		SubjectValidator.validateSubjectOpened(subject);
	}

}
