package br.com.testcode.eletronicvoting.mappers;

import br.com.testcode.eletronicvoting.models.entities.Subject;
import br.com.testcode.eletronicvoting.utils.LocalDateTimeUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class SubjectSessionResponseMapper implements ResponseMapper<Subject, String> {

	@Override
	public String toResponse(Subject model) {
		return StringUtils.replace("Sessão iniciada para votação, ficará aberta até {}",
				"{}",
				LocalDateTimeUtil.getLocalDateTimeFormated(model.getClosingSession()));
	}

}
