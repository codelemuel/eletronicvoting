package br.com.testcode.eletronicvoting.models.vos;

import br.com.testcode.eletronicvoting.models.enums.VoteEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoteVO {

	@NotBlank(message = "O identificador CPF não pode estar VAZIO")
	public String cpf;

	@NotNull(message = "O identificador da pauta/assunto não pode estar NULO")
	public Integer subjectId;

	@NotNull(message = "O voto não pode estar NULO")
	@NotBlank(message = "O voto não pode estar VAZIO")
	public String vote;

}
