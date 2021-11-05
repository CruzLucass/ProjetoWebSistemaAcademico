package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String matricula;
	/*private Curso curso;*/
	private String dataNascimento;
	private int periodo;
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	public Aluno() { }

	public Aluno(String nome, String matricula, /*Curso curso,*/ String dataNascimento, int periodo, Endereco endereco) {
		
		this.nome = nome;
		this.matricula = matricula;
		/*this.curso = curso;*/
		this.dataNascimento = dataNascimento;
		this.periodo = periodo;
		this.endereco = endereco;
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/*public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}*/

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", matricula=" + matricula /*+ ", curso=" + curso*/
				+ ", dataNascimento=" + dataNascimento + ", periodo=" + periodo + ", endereco=" + endereco + "]";
	}
	
	
	
}
