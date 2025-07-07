package model;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.gerenciamento.Biblioteca;

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
            System.out.println("3 - Emprestimo");;
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {
                opcaoEscolha = scanner.nextInt();
                scanner.nextLine();
                switch (opcaoEscolha) {
                    case 1:
                    case 2:
                    case 3:
                    case 0:
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
                case 2:
                case 3:
                case 4:
                case 0:
            }
        }
    }
    public void menuLivros(){
        int opcaoMenuLivro = -1;
        while (opcaoMenuLivro != 0){
            System.out.println("\n=== MENU LIVROS ===");
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
                case 2:
                case 3:
                case 4:
            }
        }
    }


    public void menuEmprestimo(){
        int opcaoMenuEmprestimo = -1;
        while (opcaoMenuEmprestimo != 0){
            System.out.println("\n===== MENU DE EMPRÉSTIMOS =====");
            System.out.println("1 - Realizar empréstimo");
            System.out.println("2 - Devolver livro");
            System.out.println("3 - Listar livros emprestados");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcaoMenuEmprestimo = scanner.nextInt();
            scanner.nextLine();
            switch (opcaoMenuEmprestimo){
                case 1:
                case 2:
                case 3:
                case 0:
            }
        }
    }






























}

