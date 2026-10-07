package com.exemplo.biblioteca.repository;

import com.exemplo.biblioteca.model.Leitor;

import java.util.List;
import java.util.Optional;

public class LeitorRepositoryMemoria implements LeitorRepository{

    @Override
    public Leitor salvar(Leitor leitor) {
        return null;
    }

    @Override
    public List<Leitor> listarTodos() {
        return List.of();
    }

    @Override
    public Optional<Leitor> buscarPorId(Long id) {
        return Optional.empty();
    }
}
