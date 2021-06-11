package br.mack.prof.api.entity;

public class Professor {
	long id;
	String nome;
	String matricula;
	String area;
	
	public Professor() {}
	
	
	public Professor(long id, String nome, String matricula, String area) {
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.area = area;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


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
