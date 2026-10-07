package com.exemplo.biblioteca.model;

import com.exemplo.biblioteca.repository.*;
import com.exemplo.biblioteca.service.EmprestimoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LivroTest {

    //Regra de negocio: Emprestar tornar o livro indisponivel

    @Test
    void emprestarDeveTornarLivroIndisponivel(){

        //Arrange: cria um livro novo
        //Todo livro começa disponível
        Livro livro = new Livro(1L, "Dom Casmurro", "Machado de Assis");

        //Act: executa a acao que quero testar
        livro.emprestar();

        assertFalse(livro.estaDisponivel());
    }

    //Comportamento válido: livro novo começa disponivel
    @Test
    void livroNovoDeveComecarDisponivel(){

        //Arrange e Act: cria o livro e a acao que quero testar
        Livro livro = new Livro(1L, "Dom Casmurro", "Machado de Assis");

        //Assert: confiro o resultado
        assertTrue(livro.estaDisponivel());
    }

    //Excecao: não pode emprestar livro ja emprestado
    @Test
    void naoDevePermitirEmprestarLivroJaEmprestado() {

        //Arrange: cria o livro e empresta uma vez
        Livro livro = new Livro(1L,"Dom Casmurro","Machado de Assis");
        livro.emprestar();

        // Act e Assert: tento emprestar de novo
        assertThrows(IllegalStateException.class, () -> livro.emprestar());
    }

    @Test
    void deveFicarDisponivelAoDevolverLivro(){
        Livro livro = new Livro(1L, "Dom Casmurro", "Machado de Assis");

        livro.emprestar();
        livro.devolver();
        assertTrue(livro.estaDisponivel());
    }

}
