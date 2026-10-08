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
        leitorRepository.salvar(leitor);
        return leitor;
    }

    public void cadastrar(Long id, String nome, String email, String telefone, String cpf) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do leitor é obrigatório!");
        }

        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("O email do leitor é inválido!");
        }

        if (telefone == null) {
            throw new IllegalArgumentException("O telefone do leitor é obrigatório!");
        }

        String telefoneNumeros = telefone.replaceAll("\\D", "");

        if (telefoneNumeros.length() != 11) {
            throw new IllegalArgumentException(
                    "O telefone deve ter 11 dígitos com o DDD incluso."
            );
        }

        if (cpf == null) {
            throw new IllegalArgumentException("O CPF do leitor é obrigatório!");
        }

        String cpfNumeros = cpf.replaceAll("\\D", "");

        if (cpfNumeros.length() != 11) {
            throw new IllegalArgumentException("O CPF deve ter 11 dígitos!");
        }

        Leitor leitor = new Leitor(id, nome, email, telefone, cpf);

        leitorRepository.salvar(leitor);
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