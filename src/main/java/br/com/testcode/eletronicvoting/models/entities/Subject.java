package br.com.testcode.eletronicvoting.models.entities;

import br.com.testcode.eletronicvoting.utils.Audit;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_subject")
public class Subject extends Audit {

	@Id
	@GeneratedValue(generator = "sq_subject", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "sq_subject", allocationSize = 1)
	@Column(name = "id_subject", nullable = false, updatable = false)
	public Integer id;

	@Column(name = "st_title", nullable = false, length = 100)
	private String title;

	@Column(name = "dt_open_session")
	private LocalDateTime openSession;

	@Column(name = "dt_closing_session")
	private LocalDateTime closingSession;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subject", targetEntity = Voting.class)
	private Set<Voting> votings;

}
