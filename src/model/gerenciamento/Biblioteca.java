package model.gerenciamento;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.usuarios.Aluno;
import model.usuarios.Pessoa;
import model.usuarios.Professor;

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
        if (livros.isEmpty()){
            System.out.println();
            System.out.println("Nenhum livro cadastrado.");
        }
        for (Livro livro : livros){
            if (livro.isDisponivel()){
                System.out.println("------------------------------");
                livro.dadosLivro();
                System.out.println("-----------------------------");
            }else {
                System.out.println("Nenhum livro cadastrado.");
            }
        }
    }


   public void listarLivrosEmprestados(){
    if (livros.isEmpty()) {
        System.out.println("A lista de livros está vazia.");
        return;
    }
    for (Livro livro : livros){
        if (livro.getStatus() == false){
            System.out.println("------------------------------");
            livro.dadosLivro();
            System.out.println("-----------------------------");
        }
        return;
    }
   }




    public void adicionarUsuario(Pessoa usuario){
        usuarios.add(usuario);
        if (usuario instanceof Aluno aluno){
            alunos.add(aluno);
        } else if (usuario instanceof Professor professor) {
            professores.add(professor);
        }
    }

    public boolean removerUsuario(String cpf){
        System.out.println();
        for (Pessoa usuario : usuarios){
            if (usuario.getCpf().equals(cpf)){
                System.out.println();
                usuarios.remove(usuario);
                System.out.println("Usuário " + usuario.getNome() + " removido com sucesso.");
                return true;
            }
        }
        System.out.println();
        System.out.println("Usuário com o CPF " + cpf + " não encontrado.");
        return false;
    }

    public Pessoa buscarUsuarioPorCpf(String cpf) {
        for (Pessoa usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                System.out.println();
                return usuario;
            }
        }
        return null;

    }


    public void listarUsuarios(){
        if (usuarios.isEmpty()){
            System.out.println();
            System.out.println("Não existe usuários cadastrados.");
            return;
        }
        System.out.println();
        System.out.println("==================== USUÁRIOS =================");
        for (Pessoa usuario : usuarios){
            if (usuario instanceof Professor){
                System.out.println("Usuário Professor: " + usuario.getNome());
            } else {
                System.out.println("Usuário Aluno: " + usuario.getNome());
            }
        }
    }



    public void removerLivro(String isbn){
        if (livros.isEmpty()){
            System.out.println("Nenhum livro cadastrado.");
        }
        for (Livro livro : livros){
            if (livro.getIsbn().equals(isbn)){
                if (livro.isDisponivel()){
                    System.out.println(livro.getNomeLivro() + " removido com sucesso.");
                    livros.remove(livro);
                    break;
                }else {
                    System.out.println("Este livro está emprestado para um usuário ou não está mais disponível.");
                }
            }
        }
    }

    public Livro buscarLivroPorIsbn(String isbn){
        if (livros.isEmpty()){
            System.out.println();
            System.out.println("Nenhum livro cadastrado.");
        }
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
        System.out.println();
        livros.add(livro);
    }

    public void realizarEmprestimo(Pessoa usuario, Livro livro){
        if (!livro.isDisponivel()){
            System.out.println("Livro indisponível para emprestimo.");
            return;
        }
        if (usuario instanceof Aluno aluno){
            if (aluno.getLivrosEmprestadosAluno().size() < aluno.getLimiteLivrosEmprestimo()){
                livro.emprestar(aluno.getLimiteDiasEmprestimo());
                System.out.println();
                System.out.println("******* Livro emprestado com sucesso. *******");
                System.out.println();
                System.out.println("Data de emprestimo: " + livro.getInicioEmprestimo().format(formatter));
                System.out.println("Data de devolução: " + livro.getFimEmprestimo().format(formatter));
                ((Aluno) usuario).fazerEmprestimo(livro);
            }

            
        } else if (usuario instanceof Professor professor) {
            if (professor.getLivrosEmprestados().size() < professor.getLimiteLivrosProfessor()) {
                livro.emprestar(professor.getPrazoDiasEmprestimoProfessor());
                System.out.println();
                System.out.println("******* Livro emprestado com sucesso. *******");
                System.out.println();
                System.out.println("Data de emprestimo: " + livro.getInicioEmprestimo().format(formatter));
                System.out.println("Data de devolução: " + livro.getFimEmprestimo().format(formatter));
                ((Professor) usuario).fazerEmprestimo(livro);
            }

        }
    }



    public void realizarDevolucao(Pessoa usuario, Livro livro){
        livros.add(livro);
        if (usuario instanceof Aluno aluno){
            if (aluno.getLivrosEmprestadosAluno().remove(livro)){
                livro.devolverLivro();
                System.out.println("Livro devolvido com sucesso pelo aluno.");
                System.out.println("Dia da devolução: " + livro.getFimEmprestimo().format(formatter));
            } else {
                System.out.println("Este livro não está com esse aluno.");
            }
            
        } else if (usuario instanceof Professor professor) {
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
