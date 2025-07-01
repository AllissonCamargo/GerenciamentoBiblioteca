package model;

import java.util.List;

public class Aluno extends Pessoa{
	private String matricula;
	private String turno;
	private String curso;
	private List<Livro> livrosEmprestados;
	private int LimiteDiasEmprestimo;
	private int limiteLivrosEmprestimo = 3;

	
	
	public Aluno(String nome, int idade, String email, String cpf, String matricula, String turno, String curso, int limiteLivrosEmprestimo, int LimiteDiasEmprestimo) {
		super(nome, idade, email, cpf);
		this.matricula = matricula;
		this.turno = turno;
		this.curso = curso;
		this.livrosEmprestados = null;
		this.LimiteDiasEmprestimo = LimiteDiasEmprestimo;
	}


	@Override
    public String toString(){
        return "Aluno: " + getNome();
    }
	
	
	public String getMatricula() {
		return matricula;
	}

	public String setMatricula(String matricula){
		return this.matricula = matricula;
	}
	
	public String getTurno() {
		return turno;
	}

	public String setTurno(String turno){
		return this.turno = turno;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public String setCurso(String curso){
		return this.curso = curso;
	}

	public int getLimiteDiasEmprestimo(){
		return LimiteDiasEmprestimo;
	}


	@Override
	public void exibirDados() {
		System.out.println(" - Aluno: " + getNome() + " | Idade: " + getIdade() + " | CPF: " + getCpf() + " | Matricula: " + getMatricula() + " | Turno: " + getTurno()
		+ " | Curso: " + getCurso());
		
	}


	public boolean fazerEmprestimo(Livro livro) {
		if ( !livrosEmprestados.contains(livro) && livrosEmprestados.size()< limiteLivrosEmprestimo && livro.isDisponivel()){
			livro.emprestar(getLimiteDiasEmprestimo());
			livrosEmprestados.add(livro);
			return true;
		}
		return false;
		
	}


	public void devolverLivro(Livro livro){
		livrosEmprestados.remove(livro);
	}
	
	
}
