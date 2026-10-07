package com.exemplo.biblioteca.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LivroTest {

    //Testa emprestar um livro que está disponível.

    @Test
    void emprestarDeveTornarLivroIndisponivel(){

        //Arrange: cria um livro novo
        //Todo livro começa disponível
        Livro livro = new Livro(1L, "Dom Casmurro", "Machado de Assis");

        //Act: executa a acao que quero testar
        livro.emprestar();

        assertFalse(livro.estaDisponivel());
    }

    @Test
    void naoDevePermitirEmprestarLivroJaEmprestado() {

        //Arrange: cria o livro e empresta uma vez
        Livro livro = new Livro(1L,"Dom Casmurro","Machado de Assis");
        livro.emprestar();

        // Act e Assert: tento emprestar de novo
        assertThrows(IllegalStateException.class, () -> livro.emprestar());
    }
}
