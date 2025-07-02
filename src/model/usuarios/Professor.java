package model;

import model.gerenciamento.Livro;
import model.usuarios.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {
    private int idProfessor;
    private String disciplina;
    private int limiteLivrosProfessor = 5;
    private int prazoDiasEmprestimoProfessor;
    private List<Livro> livrosEmprestados;

    public Professor(String nome, int idade, String email, String cpf, int idProfessor, String disciplina){
        super(nome, idade, email, cpf);
        this.idProfessor = idProfessor;
        this.disciplina = disciplina;
        this.prazoDiasEmprestimoProfessor = prazoDiasEmprestimoProfessor;
        this.livrosEmprestados = new ArrayList<>();
    }


    @Override
    public String toString(){
        return "Professor: " + getNome();
    }



    public int getIdProfessor(){
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor){
        this.idProfessor = idProfessor;
    }


    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getLimiteLivrosProfessor(){
        return limiteLivrosProfessor;
    }


    public int getPrazoDiasEmprestimoProfessor(){
        return prazoDiasEmprestimoProfessor;
    }

    public List<Livro> getLivrosEmprestados(){
        return livrosEmprestados;
    }


    @Override
    public void exibirDados(){
        System.out.println("Professor: " + getNome() + "\nID: " + getIdProfessor() + "\nDisciplina: " + getDisciplina() +
                "\nLimite de livros para alugar: " + limiteLivrosProfessor + "\nPrazo de dias para devolução: " + getPrazoDiasEmprestimoProfessor() + " dias.");
    }


    public void fazerEmprestimo(Livro livro){
        if (!livrosEmprestados.contains(livro) && limiteLivrosProfessor > livrosEmprestados.size()){
            livro.emprestar(prazoDiasEmprestimoProfessor);
            this.livrosEmprestados.add(livro);
            this.limiteLivrosProfessor -= 1;
        } else {
            System.out.println("Você já emprestou esse livro.");
        }
    }

    public void listarLivrosEmprestados() {
        if (livrosEmprestados.isEmpty()){
            System.out.println("Nenhum livro foi emprestado para este usuário.");
        } else {
            System.out.println();
            System.out.println("Professor(a): " + this.getNome());
            System.out.println("============= LIVROS EMPRESTADOS ============");
            System.out.println();
            for (Livro livro : livrosEmprestados){
                System.out.println("Nome: " + livro.getNomeLivro());
                System.out.println("Gênero: " + livro.getGeneroLivro());
                System.out.println("ISBN: " + livro.getIsbn());
                System.out.println("Data de empréstimo: " + livro.getInicioEmprestimo().format(livro.formatter));
                System.out.println("Data de devolução: " + livro.getFimEmprestimo().format(livro.formatter));
                System.out.println("-------------------------------");
                System.out.println();
            }
        }
    }







}
