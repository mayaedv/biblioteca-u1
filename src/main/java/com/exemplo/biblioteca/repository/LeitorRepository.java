package com.exemplo.biblioteca.repository;

import com.exemplo.biblioteca.model.Leitor;
import java.util.List;
import java.util.Optional;

public interface LeitorRepository {
    Leitor salvar(Leitor leitor);
    List<Leitor> listarTodos();
    Optional<Leitor> buscarPorId(Long id);
}