package com.exemplo.biblioteca.service;

import com.exemplo.biblioteca.model.Emprestimo;
import com.exemplo.biblioteca.model.Leitor;
import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.repository.EmprestimoRepository;
import com.exemplo.biblioteca.repository.LeitorRepository;
import com.exemplo.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final LeitorRepository leitorRepository;

    public EmprestimoService(
            EmprestimoRepository emprestimoRepository,
            LivroRepository livroRepository,
            LeitorRepository leitorRepository) {

        this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
        this.leitorRepository = leitorRepository;
    }

    public Emprestimo emprestar(Long livroId, Long leitorId) {
        Livro livro = livroRepository.buscarPorId(livroId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Livro não encontrado."
                        )
                );

        Leitor leitor = leitorRepository.buscarPorId(leitorId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Leitor não encontrado."
                        )
                );

        Emprestimo emprestimo = new Emprestimo(livro, leitor);

        return emprestimoRepository.salvar(emprestimo);
    }

    public Emprestimo devolver(Long emprestimoId) {
        Emprestimo emprestimo = emprestimoRepository
                .buscarPorId(emprestimoId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Empréstimo não encontrado."
                        )
                );

        emprestimo.devolver();

        return emprestimo;
    }

    public List<Emprestimo> listarTodos() {
        return emprestimoRepository.listarTodos();
    }

    public List<Emprestimo> listarPendenciasDoLeitor(Long leitorId) {

        leitorRepository.buscarPorId(leitorId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Leitor não encontrado."
                        )
                );

        return emprestimoRepository.listarTodos()
                .stream()
                .filter(emprestimo ->
                        emprestimo.getLeitor().getId().equals(leitorId)
                                && emprestimo.estaPendente()
                )
                .toList();
    }
}