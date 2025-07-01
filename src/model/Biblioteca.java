package model;

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

    public Pessoa buscarUsuarioPorCpf(String cpf){
        for (Pessoa usuario : usuarios){
            if (usuario.getCpf().equals(cpf)){
                return usuario;
            }else {
                System.out.println("Usuário não encontrado.");
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

    public void removerLivro(Livro livro){
        if (livros.contains(livro)){
            livros.remove(livro);
        } else {
            System.out.println("Não existe esse livro na lista.");
        }
    }

    public void buscarLivro(String isbn){
        for (Livro livro : livros){
            if (livro.getIsbn().equals(isbn)){
                System.out.println("Livro encontrado.");
                System.out.println();
                System.out.println("Nome: " + livro.getNomeLivro());
                System.out.println("Gênero: " + livro.getGeneroLivro());
                System.out.println("Autor: " + livro.getAutor());
            }else {
                System.out.println("Livro não encontrado.");
            }
        }

    }

    public void adicionarLivro(Livro livro){
        livros.add(livro);
    }




}
