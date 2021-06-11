package br.mack.prof.api.entity;

import javax.validation.constraints.NotBlank;

public class ProfessorDTO2 {
	@NotBlank(message = "Name is mandatory")
	String nome;
	@NotBlank(message = "Mat is mandatory")
	String matricula;
	@NotBlank(message = "Area is mandatory")
	String area;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	

}
