package br.com.testcode.eletronicvoting.models.vos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectVO {

	@NotBlank(message = "Titulo da pauta/assunto não pode estar VAZIO")
	private String title;

}
