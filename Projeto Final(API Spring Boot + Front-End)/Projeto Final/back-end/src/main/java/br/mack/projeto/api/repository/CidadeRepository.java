package br.mack.projeto.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.mack.projeto.api.entity.Cidade;

public interface CidadeRepository extends CrudRepository<Cidade, Long>{
	List<Cidade> findByNomeContaining(String nome);

}
