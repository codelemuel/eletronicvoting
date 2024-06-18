package br.com.testcode.eletronicvoting.exceptions;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ErrorSummary {

	private final List<String> messages;
	private final String details;
	private final LocalDateTime timestamp;

	public ErrorSummary(List<String> messages, String details, LocalDateTime timestamp) {
		super();
		this.messages = messages;
		this.details = details;
		this.timestamp = timestamp;
	}
}
