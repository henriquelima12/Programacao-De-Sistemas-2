package br.mack.prof.api.resource;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import br.mack.prof.api.entity.Professor;
import br.mack.prof.api.entity.ProfessorDTO;
import br.mack.prof.api.entity.ProfessorDTO2;

@RestController
public class ProfessorResource {
	private List<Professor> profs;
	private int countIds;
	ModelMapper modelMapper = new ModelMapper();
	
	public ProfessorResource() {
		
		this.countIds = 0;
		
		Professor p1 = new Professor(this.countIds++, "Joaquim", "1130847", "Mobile");
		Professor p2 = new Professor(this.countIds++, "Cacique", "1234532", "Web");
		Professor p3 = new Professor(this.countIds++, "Basile", "3234212", "IA");
		
		
		this.profs = new ArrayList<>();
		this.profs.add(p1);
		this.profs.add(p2);
		this.profs.add(p3);
		
	}
	
	
	@PostMapping("/api/professores")
	public Professor create(@RequestBody ProfessorDTO2 novoProf) {
		Professor p = modelMapper.map(novoProf, Professor.class);
		p.setId(countIds++);
		profs.add(p);
		return p;
	}

	
	@GetMapping("/api/professores")
	public List<ProfessorDTO> readAll() {
		List<ProfessorDTO> dto = new ArrayList<>();
		for(Professor professor : profs) {
			ProfessorDTO pdto = modelMapper.map(professor, ProfessorDTO.class);
			dto.add(pdto);
		}
		return dto;
	}
	
	@GetMapping("/api/professores/{id}")
	public Professor readById(@PathVariable long id) {
		for(Professor p: this.profs) {
			if(p.getId() == id) {
				return p;
			}
		}
		
		return null;
	}
	
	@PutMapping("/api/professores/{id}")
	public Professor update(@RequestBody Professor pUpdate, @PathVariable long id) {
		for(Professor p: this.profs) {
			if(p.getId() == id) {
				String nome = pUpdate.getNome();
				String matricula = pUpdate.getMatricula();
				String area = pUpdate.getArea();
				
				if (nome != null) p.setNome(nome);
				if (matricula != null) p.setMatricula(matricula);
				if (area != null) p.setArea(area);
				
				return p;
			}
		}
		
		return null;
	}
	
	@DeleteMapping(value="/api/professores/{id}", produces = "application/json")
	public Professor delete(@PathVariable long id) {
		for(Professor p: this.profs) {
			if(p.getId() == id) {
				profs.remove(p);
				return p;
			}
		}
		return null;
	}
}
