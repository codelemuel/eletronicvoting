package br.com.testcode.eletronicvoting.models.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum VoteEnum {

	NAO(0, "Não"),
	SIM(1, "Sim");

	private final int id;
	private final String description;

	VoteEnum(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public static VoteEnum getType(String vote) {
		return Arrays.stream(VoteEnum.values())
				.filter(ve -> vote.equalsIgnoreCase(ve.toString()) || vote.equalsIgnoreCase(ve.getDescription()))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Voto implementado não segue o padrão, utilize como resposta 'Sim' ou 'Não'"));
	}
}
