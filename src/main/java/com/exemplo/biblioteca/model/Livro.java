package com.exemplo.biblioteca.model;

public class Livro {
    private final Long id;
    private final String titulo;
    private final String autor;
    private boolean disponivel;

    public Livro(Long id, String titulo, String autor) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título do livro é obrigatório!");
        }

        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("O autor do livro é obrigatório!");
        }

        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public void emprestar() {
        if(!disponivel) {
            throw new IllegalStateException("O livro já está emprestado.");
        }
        this.disponivel = false;
    }

    public void devolver() {
        if(disponivel){
            throw new IllegalStateException("O livro já está disponível!");
        }
        this.disponivel = true;
    }

    public boolean estaDisponivel() {
        return disponivel;
    }

    public Long getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }
}
