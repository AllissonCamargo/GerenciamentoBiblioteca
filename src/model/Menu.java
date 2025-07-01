package model;

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
            System.out.println("1 - Menu usuários (Aluno ou Professor)");
            System.out.println("2 - Menu livros");
            System.out.println("3 - Listar Livros");
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
                        cadastrarLivro();
                        break;
                    case 3:
                        biblioteca.listarLivros();
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
                    System.out.println("Digite o CPF do usuário no formato (xxx.xxx.xxx-xx): ");
                    String cpfBusca = scanner.nextLine();
                    biblioteca.buscarUsuarioPorCpf(cpfBusca);
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

    public void menuLivro(){
        int opcaoMenuLivro = -1;
        while (opcaoMenuLivro != 0){
            System.out.println("\n=== MENU USUÁRIOS ===");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Buscar por CPF");
            System.out.println("4 - Remover usuário");
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
                    String isbn = scanner.nextLine();
                    biblioteca.buscarLivro(isbn);
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
        System.out.println("Autor do livro: ");
        String autor = scanner.nextLine();

        Livro livro = new Livro(isbn, nome, genero, autor);
        biblioteca.adicionarLivro(livro);
        System.out.println("Livro cadastrado com sucesso.");
    }
}
