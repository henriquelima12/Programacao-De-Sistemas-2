package br.mack.projeto.api.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.mack.projeto.api.entity.Cidade;
import br.mack.projeto.api.dto.CidadeDTO;
import br.mack.projeto.api.repository.CidadeRepository;

@RestController
public class CidadeResource {
	@Autowired
	CidadeRepository cidadeRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	 
	@GetMapping("/api/cidades")
	 public List<CidadeDTO> getAllCidades(@RequestParam(required = false) String nome) {
		List<Cidade> cidades = (List<Cidade>) cidadeRepository.findAll();
		List<CidadeDTO> dto = new ArrayList<>();
		for(Cidade cidade : cidades) {
			CidadeDTO cdto = modelMapper.map(cidade, CidadeDTO.class);
			dto.add(cdto);
		}
		return dto;	
	   
	} 
	
	@GetMapping("/api/cidades/filter")
	public List<Cidade> findCidadeByNome(@RequestParam("nome")String nome){
		return this.cidadeRepository.findByNomeContaining(nome);
	}
	 
	@GetMapping("/api/cidades/{id}")
	  public ResponseEntity<Cidade> getCidadeById(@PathVariable long id) {
	    Optional<Cidade> cidadeData = cidadeRepository.findById(id);

	    if (cidadeData.isPresent()) {
	      return new ResponseEntity<>(cidadeData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	

	
	 @PostMapping("/api/cidades")
	  public ResponseEntity<Cidade> createCidade(@RequestBody Cidade cidade) {
	    try {
	      Cidade _cidade = cidadeRepository
	          .save(cidade);  
	      return new ResponseEntity<>(_cidade, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	 @PutMapping("/api/cidades/{id}")
	  public ResponseEntity<Cidade> updateCidade(@PathVariable long id, @RequestBody Cidade cidade) {
	    Optional<Cidade> cidadeData = cidadeRepository.findById(id);

	    if (cidadeData.isPresent()) {
	      Cidade _cidade = cidadeData.get();
	      _cidade.setNome(cidade.getNome());
	      _cidade.setEstado(cidade.getEstado());
	      _cidade.setPais(cidade.getPais());
	      _cidade.setPopulacao(cidade.getPopulacao());
	      return new ResponseEntity<>(cidadeRepository.save(_cidade), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	 @DeleteMapping("/api/cidades/{id}")
	  public Cidade deleteCidade(@PathVariable long id) {
		 try {
				Optional <Cidade> op = cidadeRepository.findById(id);
				if(op.isPresent()) {
					cidadeRepository.deleteById(id);
					return op.get();
				}
			}catch(Exception ex) {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Id nÃ£o encontrado");
			}
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	 }

}
