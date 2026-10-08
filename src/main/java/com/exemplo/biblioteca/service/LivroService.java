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
        livroRepository.salvar(livro);
        return livro;
    }

    public void cadastrar(Long id, String titulo, String autor) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título do livro é obrigatório!");
        }

        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("O autor do livro é obrigatório!");
        }

        Livro livro = new Livro(id, titulo, autor);

        livroRepository.salvar(livro);
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