package model;

import java.util.List;

public class Professor extends Pessoa{
    private int idProfessor;
    private String disciplina;
    private int limiteLivrosProfessor = 5;
    private int prazoDiasEmprestimoProfessor;
    private List<Livro> livrosEmprestados;

    public Professor(String nome, int idade, String email, String cpf, int idProfessor, String disciplina,  int prazoDiasEmprestimoProfessor){

        super(nome, idade, email, cpf);
        this.idProfessor = idProfessor;
        this.disciplina = disciplina;
        this.prazoDiasEmprestimoProfessor = prazoDiasEmprestimoProfessor;
    }


    @Override
    public String toString(){
        return "Professor: " + getNome();
    }



    public int getIdProfessor(){
        return idProfessor;
    }

    public int setIdProfessor(int idProfessor){
        return this.idProfessor = idProfessor;
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


    @Override
    public void exibirDados(){
        System.out.println("Professor: " + getNome() + "\nID: " + getIdProfessor() + "\nDisciplina: " + getDisciplina() +
                "\nLimite de aluguel: " + limiteLivrosProfessor + "\nPrazo para devolução: " + getPrazoDiasEmprestimoProfessor() + " dias.");
    }

    public boolean fazerEmprestimo(Livro livro){
        if (livrosEmprestados.size() < limiteLivrosProfessor && livro.isDisponivel()){
            livro.emprestar(getPrazoDiasEmprestimoProfessor());
            livrosEmprestados.add(livro);
            return true;
        }
        return false;
    }







}
