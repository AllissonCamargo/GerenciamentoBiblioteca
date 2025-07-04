package model.usuarios;

import java.util.ArrayList;
import java.util.List;
import model.gerenciamento.Livro;

public class Aluno extends Pessoa {
	private String matricula;
	private String turno;
	private String curso;
	private List<Livro> livrosEmprestadosAluno;
	private int LimiteDiasEmprestimo = 3;
	private int limiteLivrosEmprestimo = 3;


	public Aluno(String nome, int idade, String email, String cpf, String matricula, String turno, String curso) {
		super(nome, idade, email, cpf);
		this.matricula = matricula;
		this.turno = turno;
		this.curso = curso;
		this.livrosEmprestadosAluno = new ArrayList<>();
		this.LimiteDiasEmprestimo = 3;
	}


	@Override
	public String toString() {
		return "Aluno: " + getNome();
	}


	public String getMatricula() {
		return matricula;
	}

	public String setMatricula(String matricula) {
		return this.matricula = matricula;
	}

	public String getTurno() {
		return turno;
	}

	public String setTurno(String turno) {
		return this.turno = turno;
	}

	public String getCurso() {
		return curso;
	}

	public String setCurso(String curso) {
		return this.curso = curso;
	}

	public int getLimiteDiasEmprestimo() {
		return LimiteDiasEmprestimo;
	}

	public int getLimiteLivrosEmprestimo() {
		return limiteLivrosEmprestimo;
	}

	public List<Livro> getLivrosEmprestadosAluno(){
		return livrosEmprestadosAluno;
	}

	

	

	@Override
	public void exibirDados() {
		System.out.println();
		System.out.println(" - Aluno: " + getNome() + "\n | Idade: " + getIdade() + "\n | CPF: " + getCpf() + "\n | Matricula: " + getMatricula() + "\n | Turno: " + getTurno()
				+ "\n | Curso: " + getCurso());
		System.out.println();
	}


	public boolean fazerEmprestimo(Livro livro) {
		if (livrosEmprestadosAluno.size() > limiteLivrosEmprestimo){
			System.out.println("Limite máximo de emprestimo atingido.");
		}
		if (!livrosEmprestadosAluno.contains(livro) && livro.isDisponivel()) {
			livrosEmprestadosAluno.add(livro);
			livro.emprestar(getLimiteDiasEmprestimo());
			return true;
		} 
		return false;

	}


	public void FazerDevolucaoLivro(Livro livro) {
		if (livrosEmprestadosAluno.contains(livro)){
			System.out.println("Livro devolvido.");
			livrosEmprestadosAluno.remove(livro);
			limiteLivrosEmprestimo += 1;
			livro.devolverLivro();
		} else {
			System.out.println("Este livro não foi emprestado.");
		}

	}

}
