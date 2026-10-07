package com.exemplo.biblioteca.model;

import java.time.LocalDate;

public class Emprestimo {

    private final Long id;
    private final Livro livro;
    private final Leitor leitor;
    private final LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Long id, Livro livro, Leitor leitor) {

        if (livro == null) {
            throw new IllegalArgumentException("O livro é obrigatório!");
        }

        if (leitor == null) {
            throw new IllegalArgumentException("O leitor é obrigatório!");
        }

        livro.emprestar();

        this.id = id;
        this.livro = livro;
        this.leitor = leitor;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = null;
    }

    public void devolver() {

        if (dataDevolucao != null) {
            throw new IllegalStateException("O empréstimo já foi devolvido.");
        }

        livro.devolver();
        dataDevolucao = LocalDate.now();
    }

    public boolean estaPendente() {
        return dataDevolucao == null;
    }

    public Long getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
}