package br.mack.ps2.api.resource;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import br.mack.ps2.api.entity.Professor;
import br.mack.ps2.api.repository.ProfessorRepository;

@RestController
public class ProfessorResource {
	
	@Autowired
	private ProfessorRepository repository;
	
	
	@PostMapping("/api/professores")
	public Professor create(@RequestBody Professor novoProf) {
		if(novoProf.getNome() == null || novoProf.getMatricula() == null || 
		   novoProf.getArea() == null || novoProf.getArea().trim().equals("")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Todos os dados devem ser preenchidos");
		}
		try {
			return repository.save(novoProf);
		}catch(Exception ex){
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao inserir professor");
		}


	}
	
	@GetMapping("/api/professores")
	public Iterable<Professor> readAll() {
		return repository.findAll();
	}
	
	@GetMapping("/api/professores/{id}")
	public Professor readById(@PathVariable long id) {
		try {
			Optional <Professor> op = repository.findById(id);
			if(op.isPresent()) {
				return op.get();
			}
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Id não encontrado");
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("api/professores/{id}")
	public Professor update(@RequestBody Professor pUpdate, @PathVariable long id) {
		try {
			Optional <Professor> op = repository.findById(id);
			if(op.isPresent()) {
				Professor p = op.get();
				String nome = pUpdate.getNome();
				String matricula = pUpdate.getMatricula();
				String area = pUpdate.getArea();
				
				if(nome!=null)p.setNome(nome);
				if(matricula!=null)p.setMatricula(matricula);
				if(area!=null)p.setArea(area);
				repository.save(p);
				return p;
			}
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Id não encontrado");
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "api/professores/{id}", produces = "application/json")
	public Professor delete(@PathVariable long id) {
		try {
			Optional <Professor> op = repository.findById(id);
			if(op.isPresent()) {
				repository.deleteById(id);
				return op.get();
			}
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Id não encontrado");
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	
}
