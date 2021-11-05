package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String curso;
	@OneToMany
	private List<Disciplina> disciplinas;
	
	public Curso() { }

	public Curso( String curso, ArrayList<Disciplina> disciplinas) {
		
		this.curso = curso;
		this.disciplinas = disciplinas;
		
	}
	
	public Curso(String curso) {
				
		this.curso = curso;
		this.disciplinas = new ArrayList<Disciplina>();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurso() {
		return curso;
	}

	public ArrayList<Disciplina> getDisciplinas() {
		return (ArrayList<Disciplina>) disciplinas;
	}

	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public void addDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}
	

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getNome() {
		
		return null;
	}
		
}
