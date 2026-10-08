package com.exemplo.biblioteca.service;

import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro cadastrar(Livro livro) {
        return livroRepository.salvar(livro);
    }

    public List<Livro> listarTodos() {
        return livroRepository.listarTodos();
    }

    public Livro buscarPorId(Long id) {
        return livroRepository.buscarPorId(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Livro não encontrado."
                        )
                );
    }

    public List<Livro> listarDisponiveis() {
        return livroRepository.listarTodos()
                .stream()
                .filter(Livro::estaDisponivel)
                .toList();
    }

    public void deletarPorId(Long id) {
        buscarPorId(id);
        livroRepository.deletarPorId(id);
    }
}