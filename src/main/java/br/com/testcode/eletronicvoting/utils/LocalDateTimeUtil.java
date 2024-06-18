package br.com.testcode.eletronicvoting.utils;

import br.com.testcode.eletronicvoting.models.entities.Subject;
import br.com.testcode.eletronicvoting.models.vos.SubjectSessionVO;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeUtil {

	public static LocalDateTime getCurrentDateTime() {
		return LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
	}

	public static LocalDateTime getSessionClosure(SubjectSessionVO subjectSessionVO) {
		long minutes = subjectSessionVO.getMinutes() == null ? 1L : subjectSessionVO.getMinutes();
		return getCurrentDateTime().plusMinutes(minutes);
	}

	public static boolean isSessionClosing(Subject subject) {
		return getCurrentDateTime().isAfter(subject.getClosingSession());
	}

	public static void main(String[] args) {
		System.out.println(getCurrentDateTime().toLocalTime());
	}

	public static String getLocalDateTimeFormated(LocalDateTime closingSession) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm");
		return closingSession.format(formatter);
	}
}
