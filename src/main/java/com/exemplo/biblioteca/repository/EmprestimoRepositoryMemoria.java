package com.exemplo.biblioteca.repository;

import com.exemplo.biblioteca.model.Emprestimo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmprestimoRepositoryMemoria implements EmprestimoRepository {

    private final List<Emprestimo> emprestimos = new ArrayList<>();
    private Long proximoId = 1L;

    @Override
    public Emprestimo salvar(Emprestimo emprestimo) {
        if (emprestimo.getId() == null) {
            // Se o emprestimo é novo, gera um ID e adiciona à lista
            Emprestimo novoEmprestimo = new Emprestimo(proximoId++, emprestimo.getLivro(), emprestimo.getLeitor());
            emprestimos.add(novoEmprestimo);
            return novoEmprestimo;
        } else {
            // Se já existe, remove o antigo e adiciona o atualizado
            emprestimos.removeIf(e -> e.getId() != null && e.getId().equals(emprestimo.getId()));
            emprestimos.add(emprestimo);
            return emprestimo;
        }
    }

    @Override
    public List<Emprestimo> listarTodos() {
        return new ArrayList<>(emprestimos);
    }

    @Override
    public Optional<Emprestimo> buscarPorId(Long id) {
        return emprestimos.stream()
                .filter(e -> e.getId() != null && e.getId().equals(id))
                .findFirst();
    }
}