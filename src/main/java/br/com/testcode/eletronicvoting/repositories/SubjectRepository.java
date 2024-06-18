package br.com.testcode.eletronicvoting.repositories;

import br.com.testcode.eletronicvoting.models.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

	Subject findByTitle(String title);

}
