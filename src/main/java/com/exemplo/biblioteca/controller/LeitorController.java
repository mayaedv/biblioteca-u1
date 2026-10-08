package com.exemplo.biblioteca.controller;

import com.exemplo.biblioteca.model.Leitor;
import com.exemplo.biblioteca.service.LeitorService;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class LeitorController {

    private final LeitorService leitorService;

    private long proximoId = 1;

    public LeitorController(LeitorService leitorService) {
        this.leitorService = leitorService;
    }

    public void menu(Scanner scanner) {
        int opcao;

        do {
            System.out.println();
            System.out.println("========== LEITORES ==========");
            System.out.println("1 - Cadastrar leitor");
            System.out.println("2 - Listar leitores");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarLeitor(scanner);
                    break;
                case 2:
                    listarLeitores();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void cadastrarLeitor(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Telefone (com DDD): ");
        String telefone = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        try {
            Leitor leitor = new Leitor(proximoId++, nome, email, telefone, cpf);
            leitorService.cadastrar(leitor);
            System.out.println("Leitor cadastrado com sucesso!");
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void listarLeitores() {
        List<Leitor> leitores = leitorService.listarTodos();

        if (leitores.isEmpty()) {
            System.out.println("Nenhum leitor cadastrado.");
            return;
        }

        for (Leitor leitor : leitores) {
            System.out.println(leitor.getId() + " - " + leitor.getNome()
                    + " | " + leitor.getEmail()
                    + " | " + leitor.getTelefone());
        }
    }
}