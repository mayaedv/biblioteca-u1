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

@Service
public class EmprestimoService {

    // limite máximo de empréstimos ativos por leitor
    private static final int LIMITE_EMPRESTIMOS = 3;

    private final LivroRepository livroRepository;
    private final LeitorRepository leitorRepository;
    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoService(
            LivroRepository livroRepository,
            LeitorRepository leitorRepository,
            EmprestimoRepository emprestimoRepository) {

        this.livroRepository = livroRepository;
        this.leitorRepository = leitorRepository;
        this.emprestimoRepository = emprestimoRepository;
    }

    public Emprestimo emprestar(Long livroId, Long leitorId) {

        // 1. buscar o livro
        Livro livro = livroRepository.buscarPorId(livroId);

        if (livro == null) {
            throw new IllegalArgumentException(
                    "Livro não encontrado."
            );
        }

        // 2. buscar o leitor
        Leitor leitor = leitorRepository.buscarPorId(leitorId);

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
                emprestimoRepository.listar()
                        .stream()
                        .filter(emprestimo ->
                                emprestimo.getLeitorId().equals(leitorId)
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
        Emprestimo emprestimo = new Emprestimo();

        emprestimo.setLivroId(livroId);
        emprestimo.setLeitorId(leitorId);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setAtivo(true);

        // 6. livro deixa de estar disponível
        livro.setDisponivel(false);

        // 7. salvar empréstimo
        emprestimoRepository.salvar(emprestimo);

        return emprestimo;
    }

    //devolução

    public Emprestimo devolver(Long emprestimoId) {

        // 1. buscar o empréstimo
        Emprestimo emprestimo =
                emprestimoRepository.buscarPorId(emprestimoId);

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
        Livro livro =
                livroRepository.buscarPorId(
                        emprestimo.getLivroId()
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
        livro.setDisponivel(true);

        return emprestimo;
    }


    public List<Emprestimo> listar() {
        return emprestimoRepository.listar();
    }

    //pendência = empréstimo que ainda está ativo.
    public List<Emprestimo> listarPendenciasDoLeitor(Long leitorId) {

        Leitor leitor = leitorRepository.buscarPorId(leitorId);

        if (leitor == null) {
            throw new IllegalArgumentException(
                    "Leitor não encontrado."
            );
        }

        return emprestimoRepository.listar()
                .stream()
                .filter(emprestimo ->
                        emprestimo.getLeitorId().equals(leitorId)
                                && emprestimo.isAtivo())
                .toList();
    }
}