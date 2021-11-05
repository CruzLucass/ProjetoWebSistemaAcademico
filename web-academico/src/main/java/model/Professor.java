package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Professor {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String titulacao;

public Professor() {
	super();	
}

public Professor(String nome, String titulacao) {
	super();
	this.nome = nome;
	this.titulacao = titulacao;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getTitulacao() {
	return titulacao;
}

public void setTitulacao(String titulacao) {
	this.titulacao = titulacao;
}
}
