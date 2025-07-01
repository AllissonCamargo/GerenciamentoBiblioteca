package model;

import java.time.LocalDateTime;

public class Livro {
    private String isbn;
    private String nomeLivro;
    private String generoLivro;
    private LocalDateTime inicioEmprestimo;
    private LocalDateTime fimEmprestimo;
    private boolean status;


    public Livro(String isbn, String nomeLivro, String generoLivro, LocalDateTime inicioEmprestimo, LocalDateTime fimEmprestimo, boolean status){
        this.isbn = isbn;
        this.nomeLivro = nomeLivro;
        this.generoLivro = generoLivro;
        this.inicioEmprestimo = inicioEmprestimo;
        this.fimEmprestimo = fimEmprestimo;
        this.status = status;
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



}
