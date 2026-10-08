package com.exemplo.biblioteca.repository;

import com.exemplo.biblioteca.model.Emprestimo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmprestimoRepositoryMemoria implements EmprestimoRepository {

    private final List<Emprestimo> emprestimos = new ArrayList<>();

    @Override
    public Emprestimo salvar(Emprestimo emprestimo) {
        emprestimos.removeIf(e ->
                e.getId().equals(emprestimo.getId())
        );

        emprestimos.add(emprestimo);

        return emprestimo;
    }

    @Override
    public Optional<Emprestimo> buscarPorId(Long id) {
        return emprestimos.stream()
                .filter(e -> e.getId() != null && e.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Emprestimo> listarTodos() {
        return new ArrayList<>(emprestimos);
    }
}