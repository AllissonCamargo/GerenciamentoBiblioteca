package model;

import model.gerenciamento.Biblioteca;
import model.gerenciamento.Livro;
import model.usuarios.Aluno;
import model.usuarios.Pessoa;
import model.usuarios.Professor;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Biblioteca biblioteca = new Biblioteca();

    public void exibirMenuPrincipal() {
        int opcaoEscolha = -1;

        do {
            System.out.println();
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("1 - Gerenciar usuários");
            System.out.println("2 - Gerenciar livros");
            System.out.println("3 - Emprestimo");
            System.out.println("4 - Devolução");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {
                opcaoEscolha = scanner.nextInt();
                scanner.nextLine();
                switch (opcaoEscolha) {
                    case 1:
                        menuUsuarios();
                        break;
                    case 2:
                        menuLivros();
                        break;
                    case 3:
                        menuEmprestimo();
                        break;
                    case 0:
                        System.out.println("Encerrando...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
                scanner.nextLine();
            }

        } while (opcaoEscolha != 0);
    }

    public void menuUsuarios(){
        int opcaoMenuUsuarios = -1;
        while (opcaoMenuUsuarios != 0){
            System.out.println("\n=== MENU USUÁRIOS ===");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Buscar por CPF");
            System.out.println("4 - Remover usuário");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcaoMenuUsuarios = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoMenuUsuarios){
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    biblioteca.listarUsuarios();
                    break;
                case 3:
                    System.out.print("Digite o CPF do usuário no formato (xxx.xxx.xxx-xx): ");
                    String cpfBusca = scanner.nextLine();
                    Pessoa usuarioBusca = biblioteca.buscarUsuarioPorCpf(cpfBusca);
                    usuarioBusca.exibirDados();
                    break;
                case 4:
                    System.out.println("Digite o CPF no formato 'xxx.xxx.xxx-xx' para remover um usuário: ");
                    String cpfRemocao = scanner.nextLine();
                    boolean success = biblioteca.removerUsuario(cpfRemocao);
                    if (!success){
                        System.out.println("A remoção falhou.");
                    }
                    break;
                case 0:
                    System.out.println("Voltando para o menu anterior...");
                    break;
            }
        }
    }

    public void menuLivros(){
        int opcaoMenuLivro = -1;
        while (opcaoMenuLivro != 0){
            System.out.println("\n=== MENU USUÁRIOS ===");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Buscar por ISBN");
            System.out.println("4 - Remover livro");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcaoMenuLivro = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoMenuLivro){
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    biblioteca.listarLivros();
                    break;
                case 3:
                    System.out.println("Digite o ISBN do livre para buscar: ");
                    String isbnBusca = scanner.nextLine();
                    biblioteca.buscarLivroPorIsbn(isbnBusca);
                    break;
                case 4:
                    System.out.println("Digite o ISBN do livro a ser removido.");
                    String isbnRemocao = scanner.nextLine();
                    biblioteca.removerLivro(isbnRemocao);
                    break;
            }
        }
    }

    public void menuEmprestimo(){
        int opcaoMenuEmprestimo = -1;
        while (opcaoMenuEmprestimo != 0){
            System.out.println("\n===== MENU DE EMPRÉSTIMOS =====");
            System.out.println("1 - Realizar empréstimo");
            System.out.println("2 - Devolver livro");
            System.out.println("3 - Listar livros emprestados por usuário");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcaoMenuEmprestimo = scanner.nextInt();
            scanner.nextLine();
            switch (opcaoMenuEmprestimo){
                case 1:
                    realizarEmprestimo();
                    break;
                case 2:
                    devolverLivro();
                    break;
                case 3:
                    listarLivrosEmprestadoPorUsuario();
                    break;
                case 0:
                    System.out.println("Voltando para o menu principal...");
                    break;
            }
        }


    }

    private void cadastrarUsuario() {
        System.out.print("Tipo de usuário (1 - Aluno | 2 - Professor): ");
        int tipoUsuario = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        if (tipoUsuario == 1) {
            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine();
            System.out.print("Turno: ");
            String turno = scanner.nextLine();
            System.out.print("Curso: ");
            String curso = scanner.nextLine();

            Aluno aluno = new Aluno(nome, idade, email, cpf, matricula, turno, curso);
            biblioteca.adicionarUsuario(aluno);
            System.out.println("\nAluno cadastrado com sucesso!");
            aluno.exibirDados();

        } else if (tipoUsuario == 2) {
            System.out.print("ID do professor: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Disciplina: ");
            String disciplina = scanner.nextLine();

            Professor prof = new Professor(nome, idade, email, cpf, id, disciplina);
            biblioteca.adicionarUsuario(prof);
            System.out.println("\nProfessor cadastrado com sucesso!");
            prof.exibirDados();
        } else {
            System.out.println("Tipo de usuário inválido.");
        }
    }

    private void cadastrarLivro() {
        System.out.print("Nome do livro: ");
        String nome = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
        System.out.print("Autor do livro: ");
        String autor = scanner.nextLine();

        Livro livro = new Livro(isbn, nome, genero, autor);
        biblioteca.adicionarLivro(livro);
        System.out.println("Livro cadastrado com sucesso.");
    }

    private void realizarEmprestimo(){
        System.out.println("Digite o CPF do usuário que irá realizar o emprestimo: ");
        String cpfEmprestimo = scanner.nextLine();

        Pessoa usuario = biblioteca.buscarUsuarioPorCpf(cpfEmprestimo);
        if (usuario == null){
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.println("ISBN do livro a ser emprestado: ");
        String isbnEmprestimo = scanner.nextLine();
        Livro livro = biblioteca.buscarLivroPorIsbn(isbnEmprestimo);

        if (livro == null){
            System.out.println("Livro não encontrado.");
            return;
        }

        if (!livro.isDisponivel()){
            System.out.println("Livro não está disponível.");
            return;
        }

        biblioteca.realizarEmprestimo(usuario, livro);
    }

    private void devolverLivro(){
        System.out.println("CPF do usuário: ");
        String cpfDevolucao = scanner.nextLine();


        Pessoa usuario = biblioteca.buscarUsuarioPorCpf(cpfDevolucao);

        if (usuario == null){
            System.out.println("Usuário não encontrado.");
            return;
        }


        System.out.println("ISBN do livro: ");
        String isbnDevolucao = scanner.nextLine();


        Livro livro = biblioteca.buscarLivroPorIsbn(isbnDevolucao);
        if (livro == null){
            System.out.println("Livro não encontrado.");
            return;
        }

        livro.devolverLivro();
    }




    public void listarLivrosEmprestadoPorUsuario(){
        System.out.print("Digite o CPF do usuário no formato (xxx.xxx.xxx-xx): ");
        String cpfBusca = scanner.nextLine();
        Pessoa usuario = biblioteca.buscarUsuarioPorCpf(cpfBusca);
        if (usuario != null) {
            System.out.println("\nUsuário encontrado: " + usuario.getNome());
            usuario.listarLivrosEmprestados();
            return;
        } else {
            System.out.println("\nUsuário não encontrado.");
        }
        return;
    }












}

