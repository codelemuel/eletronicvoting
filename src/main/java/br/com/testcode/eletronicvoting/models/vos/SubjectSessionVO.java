package br.com.testcode.eletronicvoting.models.vos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectSessionVO {

	public Integer subjectId;
	public Integer minutes;

}
