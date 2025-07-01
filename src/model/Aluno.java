package model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
	private String matricula;
	private String turno;
	private String curso;
	private List<Livro> livrosEmprestados;
	private int LimiteDiasEmprestimo;
	private int limiteLivrosEmprestimo = 3;


	public Aluno(String nome, int idade, String email, String cpf, String matricula, String turno, String curso) {
		super(nome, idade, email, cpf);
		this.matricula = matricula;
		this.turno = turno;
		this.curso = curso;
		this.livrosEmprestados = new ArrayList<>();
		this.LimiteDiasEmprestimo = LimiteDiasEmprestimo;
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


	@Override
	public void exibirDados() {
		System.out.println(" - Aluno: " + getNome() + "\n | Idade: " + getIdade() + "\n | CPF: " + getCpf() + "\n | Matricula: " + getMatricula() + "\n | Turno: " + getTurno()
				+ "\n | Curso: " + getCurso());

	}


	public boolean fazerEmprestimo(Livro livro) {
		if (!livrosEmprestados.contains(livro) && livrosEmprestados.size() < limiteLivrosEmprestimo && livro.isDisponivel()) {
			livro.emprestar(getLimiteDiasEmprestimo());
			livrosEmprestados.add(livro);
			limiteLivrosEmprestimo -= 1;
			return true;
		} else {
			System.out.println("Não é possível emprestar mais nenhum livro.");
		}
		return false;

	}


	public void FazerDevolucaoLivro(Livro livro) {
		if (livrosEmprestados.contains(livro)){
			System.out.println("Livro devolvido.");
			livrosEmprestados.remove(livro);
			limiteLivrosEmprestimo += 1;
			livro.devolverLivro();
		} else {
			System.out.println("Este livro não foi emprestado.");
		}

	}

	public void listarLivrosEmprestados() {
		if (livrosEmprestados.isEmpty()) {
			System.out.println("Nenhum livro foi emprestado para este usuário.");
		} else {
			System.out.println("============= LIVROS EMPRESTADOS ============");
			System.out.println("Aluno(a): " + this.getNome());
			System.out.println();
			for (Livro livro : livrosEmprestados) {
				System.out.println("Nome: " + livro.getNomeLivro());
				System.out.println("Gênero: " + livro.getGeneroLivro());
				System.out.println("ISBN: " + livro.getIsbn());
				System.out.println("-------------------------------");
				System.out.println();
			}
		}
	}
}
