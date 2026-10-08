package com.exemplo.biblioteca.service;

import com.exemplo.biblioteca.model.Leitor;
import com.exemplo.biblioteca.repository.LeitorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeitorService {

    private final LeitorRepository leitorRepository;

    public LeitorService(LeitorRepository leitorRepository) {
        this.leitorRepository = leitorRepository;
    }

    public Leitor cadastrar(Leitor leitor) {
        return leitorRepository.salvar(leitor);
    }

    public List<Leitor> listarTodos() {
        return leitorRepository.listarTodos();
    }

    public Leitor buscarPorId(Long id) {
        return leitorRepository.buscarPorId(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Leitor não encontrado."
                        )
                );
    }
}