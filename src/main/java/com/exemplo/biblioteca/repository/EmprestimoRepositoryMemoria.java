package com.exemplo.biblioteca.repository;

import com.exemplo.biblioteca.model.Emprestimo;
import com.exemplo.biblioteca.model.Leitor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmprestimoRepositoryMemoria implements EmprestimoRepository {

    private final List<Emprestimo> emprestimos = new ArrayList<>();

    @Override
    public void salvar(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    @Override
    public Optional<Emprestimo> buscarPorId(Long id) {
        return emprestimos.stream()
                .filter(emprestimo ->
                        emprestimo.getId() != null &&
                                emprestimo.getId().equals(id)
                )
                .findFirst();
    }

    @Override
    public List<Emprestimo> listarTodos() {
        return new ArrayList<>(emprestimos);
    }
}