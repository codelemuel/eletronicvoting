package br.com.testcode.eletronicvoting.validators;

import br.com.testcode.eletronicvoting.models.entities.Subject;
import br.com.testcode.eletronicvoting.utils.LocalDateTimeUtil;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

public class SubjectValidator {

	public static void validateDuplicity(Subject subject) {
		if (subject !=  null) {
			throw new EntityExistsException("Título da Pauta/Assunto já cadastrado na base!");
		}
	}

	public static Subject validateSubject(Subject subject) {
		if (subject == null) {
			throw new EntityNotFoundException("Pauta/Assunto não encontrado!");
		}
		return subject;
	}

	public static void validateSubjectOpened(Subject subject) {
		Subject subjectExist = validateSubject(subject);

		if (LocalDateTimeUtil.isSessionClosing(subjectExist)) {
			throw new IllegalCallerException("Pauta/Assunto já está fechado para votação.");
		}
	}

}
