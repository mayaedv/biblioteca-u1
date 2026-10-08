package com.exemplo.biblioteca.repository;

import com.exemplo.biblioteca.model.Livro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LivroRepositoryMemoria implements LivroRepository {

    private final List<Livro> livros = new ArrayList<>();
    private Long proximoId = 1L;

    @Override
    public void salvar(Livro livro) {
        livros.add(livro);
    }

    @Override
    public Optional<Livro> buscarPorId(Long id) {
       for(Livro livro : livros){
           if(livro.getId() != null && livro.getId().equals(id)) {
               return Optional.of(livro);
           }

       }
       return null;
    }

    @Override
    public List<Livro> listarTodos() {
        return  new ArrayList<>(livros);
    }
}