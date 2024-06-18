package br.com.testcode.eletronicvoting.models.entities;

import br.com.testcode.eletronicvoting.models.enums.VoteEnum;
import br.com.testcode.eletronicvoting.utils.Audit;
import lombok.*;

import javax.persistence.*;

@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_voting")
public class Voting extends Audit {

	@Id
	@GeneratedValue(generator = "sq_voting", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "sq_voting", allocationSize = 1)
	@Column(name = "id_voting", nullable = false, updatable = false)
	private Integer id;

	@Column(name = "id_cpf", nullable = false, length = 11)
	private String cpf;

	@ManyToOne
	@JoinColumn(name = "id_subject", nullable = false)
	private Subject subject;

	@Column(name = "en_vote", nullable = false)
	private VoteEnum vote;

}
