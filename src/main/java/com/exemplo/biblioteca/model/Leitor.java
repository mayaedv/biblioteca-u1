package com.exemplo.biblioteca.model;

public class Leitor {
    private final Long id;
    private final String nome;
    private final String email;
    private final String telefone;
    private final String cpf;

    public Leitor (Long id, String nome, String email, String telefone, String cpf){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }
}
