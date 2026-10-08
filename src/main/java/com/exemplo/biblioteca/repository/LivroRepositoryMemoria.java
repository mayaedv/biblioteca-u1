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
        return livros.stream()
                .filter(livro -> livro.getId() != null && livro.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Livro> listarTodos() {
        return  new ArrayList<>(livros);
    }

    @Override
    public void deletarPorId(Long id) {
        Optional<Livro> livro = buscarPorId(id);

        if (livro.isPresent()) {
            livros.remove(livro.get());
        }
    }
}