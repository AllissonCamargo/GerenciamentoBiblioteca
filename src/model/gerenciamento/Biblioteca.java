package model.gerenciamento;

import model.usuarios.Aluno;
import model.usuarios.Pessoa;
import model.usuarios.Professor;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Pessoa> usuarios;
    private List<Professor> professores;
    private List<Aluno> alunos;
    private List<Livro> livros;


    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


    public Biblioteca(){
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.professores = new ArrayList<>();
    }






    public void listarLivros(){
        for (Livro livro : livros){
            if (livro.isDisponivel()){
                System.out.println("Livro: " + livro.getNomeLivro());
                System.out.println("Gênero: " + livro.getGeneroLivro());
                System.out.println("ISBN: " + livro.getIsbn());

            }
        }
    }


    public void adicionarUsuario(Pessoa usuario){
        usuarios.add(usuario);
        if (usuario instanceof Aluno){
            alunos.add((Aluno) usuario);
        } else if (usuario instanceof Professor) {
            professores.add((Professor) usuario);
        }
    }

    public boolean removerUsuario(String cpf){
        for (Pessoa usuario : usuarios){
            if (usuario.getCpf().equals(cpf)){
                usuarios.remove(usuario);
                System.out.println("Usuário" + usuario.getNome() + "removido com sucesso.");
                return true;
            }
        }
        System.out.println("Usuário com o CPF " + cpf + " não encontrado.");
        return false;
    }

    public Pessoa buscarUsuarioPorCpf(String cpf) {
        for (Pessoa usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        return null;
    }


    public boolean atualizarUsuario(String cpf, String novoNome, String novoEmail, int idade, String disciplina){
        for (Pessoa usuario : usuarios){
            if (usuario.getCpf().equals(cpf)){
                usuario.setNome(novoNome);
                usuario.setEmail(novoEmail);
                usuario.setIdade(idade);
                return true;
            }
        }
        return false;
    }

    public void listarUsuarios(){
        for (Pessoa usuario : usuarios){
            if (usuario instanceof Professor){
                System.out.println("Usuário Professor: " + usuario.getNome());
            } else {
                System.out.println("Usuário Aluno: " + usuario.getNome());
            }
        }
    }

    public void listarAlunosCadastrados(){
        for (Aluno aluno : alunos){
            System.out.println("Aluno: " + aluno);
        }
        System.out.println();
    }

    public void listarProfessoresCadastrados(){
        for (Professor professor : professores){
            System.out.println("Professor: " + professor);
        }
        System.out.println();
    }

    public void listarDadosProfessores(){
        for (Professor professor : professores){
            professor.exibirDados();
        }
    }

    public void removerLivro(String isbn){
        for (Livro livro : livros){
            if (livro.getIsbn().equals(isbn)){
                if (livro.isDisponivel()){
                    livros.remove(livro);
                }else {
                    System.out.println("Este livro está emprestado para um usuário ou não está mais disponível.");
                }
            }
        }
    }

    public Livro buscarLivroPorIsbn(String isbn){
        for (Livro livro : livros){
            if (livro.getIsbn().equals(isbn)){
                return livro;
            }else {
                System.out.println("Livro não encontrado.");
            }
        }
        return null;
    }

    public void adicionarLivro(Livro livro){
        livros.add(livro);
    }

    public void realizarEmprestimo(Pessoa usuario, Livro livro){
        if (!livro.isDisponivel()){
            System.out.println("Livro indisponível para emprestimo.");
            return;
        }


        if (usuario instanceof Aluno){
            Aluno aluno = (Aluno) usuario;
            if (aluno.getLivrosEmprestados().size() < aluno.getLimiteLivrosEmprestimo()){
                livro.emprestar(aluno.getLimiteDiasEmprestimo());
                System.out.println("Livro emprestado com sucesso.");
                System.out.println();
                System.out.println("Data de emprestimo: " + livro.getInicioEmprestimo().format(formatter));
                System.out.println("Data de devolução: " + livro.getFimEmprestimo().format(formatter));
            }
        }
    }




    public void realizarDevolucao(Pessoa usuario, Livro livro){
        if (usuario instanceof Aluno){
            Aluno aluno = (Aluno) usuario;
            if (aluno.getLivrosEmprestados().remove(livro)){
                livro.devolverLivro();
                System.out.println("Livro devolvido com sucesso pelo aluno.");
                System.out.println("Dia da devolução: " + livro.getFimEmprestimo().format(formatter));
            } else {
                System.out.println("Este livro não está com esse aluno.");
            }
        } else if (usuario instanceof Professor) {
            Professor professor = (Professor) usuario;
                if (professor.getLivrosEmprestados().remove(livro)){
                    livro.devolverLivro();
                    System.out.println("Livro devolvido com sucesso pelo professor.");
                    System.out.println("Dia da devolução: " + livro.getFimEmprestimo().format(formatter));
                } else {
                    System.out.println("Este livro não está com esse Professor.");
                }
            }
        }
}
