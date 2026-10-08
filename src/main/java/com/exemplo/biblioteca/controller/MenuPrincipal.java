package com.exemplo.biblioteca.controller;

import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class MenuPrincipal {

    private final LeitorController leitorController;
    private final EmprestimoController emprestimoController;

    public MenuPrincipal(LeitorController leitorController, EmprestimoController emprestimoController) {
        this.leitorController = leitorController;
        this.emprestimoController = emprestimoController;
    }

    public void iniciar(Scanner scanner) {

        int opcao;

        do {
            System.out.println();
            System.out.println("========== BIBLIOTECA ==========");
            System.out.println("1 - Livros");
            System.out.println("2 - Leitores");
            System.out.println("3 - Empréstimos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("Menu de livros ainda não conectado.");
                    break;

                case 2:
                    leitorController.menu(scanner);
                    break;

                case 3:
                    emprestimoController.menu();
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }
}