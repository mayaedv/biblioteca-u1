package com.exemplo.biblioteca.controller;

import com.exemplo.biblioteca.model.Emprestimo;
import com.exemplo.biblioteca.service.EmprestimoService;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class EmprestimoController {

    private EmprestimoService emprestimoService;
    private final Scanner scanner;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
        this.scanner = new Scanner(System.in);
    }

    public void emprestar() {

        System.out.println("\n--- Novo Emprestimo ---");

        System.out.print("ID do Leitor: ");
        Long LeitorId = scanner.nextLong();

        System.out.print("ID do livro: ");
        Long LivroId = scanner.nextLong();

        emprestimoService.emprestar(
                LivroId,
                LeitorId
        );

        System.out.println(
                "Emprestimo realizado com sucesso."
        );
    }

    public void devolver() {

        System.out.println("\n--- Devolução ---");

        System.out.print("ID do Emprestimo: ");

        Long emprestimoId = scanner.nextLong();

        emprestimoService.devolver(
                emprestimoId
        );

        System.out.println(
                "Livro devolvido com sucesso."
        );
    }

    public void listar() {

        List<Emprestimo> emprestimos =
                emprestimoService.listarTodos();

        System.out.println("\n--- Aluguéis ---");

        for (Emprestimo emprestimo : emprestimos) {

            System.out.println(
                    "Aluguel: " + emprestimo.getId()
                            + " | Leitor: "
                            + emprestimo.getLeitor().getNome()
                            + " | Livro: "
                            + emprestimo.getLivro().getTitulo()

            );
        }
    }
    public void menu() {

        int opcao;

        do {
            System.out.println();
            System.out.println("========== EMPRÉSTIMOS ==========");
            System.out.println("1 - Realizar empréstimo");
            System.out.println("2 - Devolver livro");
            System.out.println("3 - Listar empréstimos");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    emprestar();
                    break;

                case 2:
                    devolver();
                    break;

                case 3:
                    listar();
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }
}
