package br.com.testcode.eletronicvoting.mappers;

import br.com.testcode.eletronicvoting.models.dtos.SubjectDTO;
import br.com.testcode.eletronicvoting.models.entities.Subject;
import org.springframework.stereotype.Component;

@Component
public class SubjectResponseMapper implements ResponseMapper<Subject, SubjectDTO> {

	@Override
	public SubjectDTO toResponse(Subject model) {
		return SubjectDTO.builder()
				.id(model.getId())
				.title(model.getTitle())
				.build();
	}

}
