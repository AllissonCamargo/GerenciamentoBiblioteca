package model.gerenciamento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Livro {
    private String isbn;
    private String nomeLivro;
    private String generoLivro;
    private String autor;
    private LocalDateTime inicioEmprestimo;
    private LocalDateTime fimEmprestimo;
    private boolean status;


    public Livro(String isbn, String nomeLivro, String generoLivro, String autor){
        this.isbn = isbn;
        this.nomeLivro = nomeLivro;
        this.generoLivro = generoLivro;
        this.autor = autor;
        this.inicioEmprestimo = inicioEmprestimo;
        this.fimEmprestimo = fimEmprestimo;
        this.status = true;
    }

    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


    @Override
    public String toString() {
        return nomeLivro + " (ISBN: " + isbn + ")";
    }

    public boolean isDisponivel(){
        return status;
    }


    public String getIsbn() {
        return isbn;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public String getGeneroLivro() {
        return generoLivro;
    }

    public String getAutor(){
        return autor;
    }

    public LocalDateTime getInicioEmprestimo() {
        return inicioEmprestimo;
    }

    public LocalDateTime getFimEmprestimo() {
        return fimEmprestimo;
    }

    public boolean getStatus() {
        return status;
    }

    public void emprestar(int prazoDias){
        this.status = false;
        this.inicioEmprestimo = LocalDateTime.now();
        this.fimEmprestimo = LocalDateTime.now().plusDays(prazoDias);
    }


    public void devolverLivro(){
        this.status = true;
        this.inicioEmprestimo = null;
        this.fimEmprestimo = null;
    }


    public void dadosLivro(){
        System.out.println("Nome: " + nomeLivro);
        System.out.println("Gênero: " + generoLivro);
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: " + isbn);
    }

    



}
