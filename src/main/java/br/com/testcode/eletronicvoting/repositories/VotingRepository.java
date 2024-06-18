package br.com.testcode.eletronicvoting.repositories;

import br.com.testcode.eletronicvoting.models.entities.Voting;
import br.com.testcode.eletronicvoting.models.interfaces.IResultCountGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotingRepository extends JpaRepository<Voting, Integer> {


	@Query("select vote as voteEnum, count(*) as quantity " +
			"from Voting " +
			"where subject.id = :subjectId " +
			"group by vote ")
	List<IResultCountGroup> getCountBySubjectId(@Param("subjectId") Integer subjectId);

	@Query("select v " +
			"from Voting v " +
			"where v.cpf = :cpfId and v.subject.id = :subjectId ")
	Voting getByIdCpfAndSubjectId(@Param("cpfId") String cpfId, @Param("subjectId") Integer subjectId);

}
