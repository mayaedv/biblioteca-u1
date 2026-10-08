package com.exemplo.biblioteca.repository;

import com.exemplo.biblioteca.model.Leitor;

import java.util.List;
import java.util.Optional;

public interface LeitorRepository {
    void salvar(Leitor Leitor);
    Optional<Leitor> buscarPorId(Long id);
    List<Leitor> listarTodos();
}