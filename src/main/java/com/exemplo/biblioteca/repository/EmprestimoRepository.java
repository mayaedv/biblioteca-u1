package com.exemplo.biblioteca.repository;

import com.exemplo.biblioteca.model.Emprestimo;
import java.util.List;
import java.util.Optional;

public interface EmprestimoRepository {
    Emprestimo salvar(Emprestimo emprestimo);
    List<Emprestimo> listarTodos();
    Optional<Emprestimo> buscarPorId(Long id);
}