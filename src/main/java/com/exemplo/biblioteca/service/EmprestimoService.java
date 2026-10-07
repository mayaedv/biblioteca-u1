package com.exemplo.biblioteca.service;

import com.exemplo.biblioteca.model.Emprestimo;
import com.exemplo.biblioteca.model.Leitor;
import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.repository.EmprestimoRepository;
import com.exemplo.biblioteca.repository.LeitorRepository;
import com.exemplo.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    // limite máximo de empréstimos ativos por leitor
    private static final int LIMITE_EMPRESTIMOS = 3;

    private final LivroRepository LivroRepository;
    private final LeitorRepository LeitorRepository;
    private final EmprestimoRepository EmprestimoRepository;

    public EmprestimoService(
            LivroRepository LivroRepository,
            LeitorRepository LeitorRepository,
            EmprestimoRepository EmprestimoRepository) {

        this.LivroRepository = LivroRepository;
        this.LeitorRepository = LeitorRepository;
        this.EmprestimoRepository = EmprestimoRepository;
    }

    public Emprestimo emprestar(Long livroId, Long leitorId) {

        // 1. buscar o livro
        Livro livro = LivroRepository
                .buscarPorId(livroId)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));

        if (livro == null) {
            throw new IllegalArgumentException(
                    "Livro não encontrado."
            );
        }

        // 2. buscar o leitor
        Leitor leitor = LeitorRepository.buscarPorId(leitorId)
                .orElseThrow(() -> new IllegalArgumentException("Leitor não encontrado"));

        if (leitor == null) {
            throw new IllegalArgumentException(
                    "Leitor não encontrado."
            );
        }

        // 3. verificar se o livro está disponível
        if (!livro.isDisponivel()) {
            throw new IllegalStateException(
                    "Livro não está disponível para empréstimo."
            );
        }

        // 4. Contar empréstimos ativos do leitor
        long quantidadeEmprestimosAtivos =
                EmprestimoRepository.listarTodos()
                        .stream()
                        .filter(emprestimo ->
                                emprestimo.getLeitor().getId().equals(leitorId)
                                        && emprestimo.isAtivo())
                        .count();

        // verificar limite de empréstimos
        if (quantidadeEmprestimosAtivos >= LIMITE_EMPRESTIMOS) {
            throw new IllegalStateException(
                    "Leitor atingiu o limite de "
                            + LIMITE_EMPRESTIMOS
                            + " empréstimos ativos."
            );
        }

        // 5. criar novo empréstimo
        Emprestimo emprestimo = new Emprestimo(livro, leitor);

        // 6. livro deixa de estar disponível
        livro.setDisponivel(false);

        // 7. salvar empréstimo
        EmprestimoRepository.salvar(emprestimo);

        return emprestimo;
    }

    //devolução

    public Emprestimo devolver(Long emprestimoId) {

        // 1. buscar o empréstimo
        Emprestimo emprestimo =
                EmprestimoRepository.buscarPorId(emprestimoId)
                        .orElseThrow(() ->
                                new IllegalArgumentException("Empréstimo não encontrado"));

        if (emprestimo == null) {
            throw new IllegalArgumentException(
                    "Empréstimo não encontrado."
            );
        }

        // 2. verificar se o empréstimo ainda está ativo
        if (!emprestimo.isAtivo()) {
            throw new IllegalStateException(
                    "Empréstimo já foi devolvido."
            );
        }

        // 3. buscar o livro relacionado ao empréstimo
        Livro livro = LivroRepository.buscarPorId(
                emprestimo.getLivro().getId()
        ).orElseThrow(() ->
                new IllegalStateException(
                        "Livro relacionado ao empréstimo não foi encontrado."
                )
        );

        if (livro == null) {
            throw new IllegalStateException(
                    "Livro relacionado ao empréstimo não foi encontrado."
            );
        }

        // 4. encerrar o empréstimo
        emprestimo.setAtivo(false);

        // registrar a data da devolução
        emprestimo.setDataDevolucao(LocalDate.now());

        // 5. liberar o livro
        livro.devolver();

        return emprestimo;
    }


    public List<Emprestimo> listar() {
        return EmprestimoRepository.listarTodos();
    }

    //pendência = empréstimo que ainda está ativo.
    public List<Emprestimo> listarPendenciasDoLeitor(Long leitorId) {

        Leitor leitor = LeitorRepository.buscarPorId(leitorId)
                .orElseThrow(() -> new IllegalArgumentException("Leitor não encontrado"));

        if (leitor == null) {
            throw new IllegalArgumentException(
                    "Leitor não encontrado."
            );
        }

        return EmprestimoRepository.listarTodos()
                .stream()
                .filter(emprestimo ->
                        emprestimo.getLeitor().equals(leitorId)
                                && emprestimo.isAtivo())
                .toList();
    }
}