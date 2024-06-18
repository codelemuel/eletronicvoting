package br.com.testcode.eletronicvoting.mappers;

import br.com.testcode.eletronicvoting.models.entities.Subject;
import br.com.testcode.eletronicvoting.models.vos.SubjectSessionVO;
import br.com.testcode.eletronicvoting.utils.LocalDateTimeUtil;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubjectSessionRequestMapper implements RequestMapper<Subject, List<Object>> {

	public Subject toModel(List<Object> objects) {
		Subject subject = (Subject) objects.get(0);
		SubjectSessionVO subjectSessionVO = (SubjectSessionVO) objects.get(1);

		return Subject.builder()
				.id(subject.getId())
				.title(subject.getTitle())
				.openSession(LocalDateTimeUtil.getCurrentDateTime())
				.closingSession(LocalDateTimeUtil.getSessionClosure(subjectSessionVO))
				.build();
	}

}
