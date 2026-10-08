package com.exemplo.biblioteca.repository;

import com.exemplo.biblioteca.model.Leitor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LeitorRepositoryMemoria implements LeitorRepository {

    private final List<Leitor> leitores = new ArrayList<>();

    @Override
    public void salvar(Leitor leitor) {
        leitores.add(leitor);
    }

    @Override
    public List<Leitor> listarTodos() {
        return leitores;
    }

    @Override
    public Optional<Leitor> buscarPorId(Long id) {
        return leitores.stream()
                .filter(leitor -> leitor.getId() != null && leitor.getId().equals(id))
                .findFirst();
    }
}