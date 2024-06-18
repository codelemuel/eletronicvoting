package br.com.testcode.eletronicvoting.mappers;

import br.com.testcode.eletronicvoting.models.entities.Subject;
import br.com.testcode.eletronicvoting.models.vos.SubjectVO;
import org.springframework.stereotype.Component;

@Component
public class SubjectRequestMapper implements RequestMapper<Subject, SubjectVO> {

	@Override
	public Subject toModel(SubjectVO request) {
		return Subject.builder()
				.title(request.getTitle())
				.build();
	}

}
