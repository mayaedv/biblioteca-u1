package com.exemplo.biblioteca.repository;

import com.exemplo.biblioteca.model.Livro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LivroRepositoryMemoria implements LivroRepository {

    private final List<Livro> livros = new ArrayList<>();
    private Long proximoId = 1L;

    @Override
    public Livro salvar(Livro livro) {
        if (livro.getId() == null) {
            Livro novoLivro = new Livro(proximoId++, livro.getTitulo(), livro.getAutor());
            livros.add(novoLivro);
            return novoLivro;
        } else {
            deletarPorId(livro.getId());
            livros.add(livro);
            return livro;
        }
    }

    @Override
    public List<Livro> listarTodos() {
        return new ArrayList<>(livros);
    }

    @Override
    public Optional<Livro> buscarPorId(Long id) {
        return livros.stream()
                .filter(l -> l.getId() != null && l.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deletarPorId(Long id) {
        livros.removeIf(l -> l.getId() != null && l.getId().equals(id));
    }
}