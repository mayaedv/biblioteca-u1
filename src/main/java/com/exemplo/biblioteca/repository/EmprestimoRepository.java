package com.exemplo.biblioteca.repository;

import com.exemplo.biblioteca.model.Emprestimo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface EmprestimoRepository {
    void salvar(Emprestimo emprestimo);
    Optional<Emprestimo>buscarPorId(Long id);
    List<Emprestimo> listarTodos();
}