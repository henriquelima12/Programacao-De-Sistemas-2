package br.mack.ps2.api.repository;
import org.springframework.data.repository.CrudRepository;
import br.mack.ps2.api.entity.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Long>{

}
