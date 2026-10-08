package com.exemplo.biblioteca.repository;

import com.exemplo.biblioteca.model.Livro;
import java.util.List;
import java.util.Optional;

public interface LivroRepository {
    List<Livro> listarTodos();
    Optional<Livro> buscarPorId(Long id);
    void salvar(Livro livro);
}