# biblioteca-u1
Sistema de Biblioteca

Identificação

Projeto: Sistema de Biblioteca

Disciplina: Desenvolvimento Back-End
Unidade: 1

Turma: ADS 3P

Professor: Victor Brayner

Integrantes

* Bruna Francisca da Silva
* Kamyla Vitória Chagas de Andrade
* Luísa Geórgia Bezerra Alves
* Maria Gabriella Silva de Lima
* Mayara Eduarda Dias Vieira
* Tarcilla Maria de Araújo Almeida
* Thais Vitória da Silva Nascimento

⸻

Sobre o projeto

O Sistema de Biblioteca é uma aplicação Back-End desenvolvida em Java 21 com Spring Boot, com o objetivo de auxiliar no gerenciamento de livros, leitores e empréstimos de uma biblioteca.

O sistema permite realizar operações de cadastro e consulta de livros e leitores, além do controle de empréstimos e devoluções.

O projeto foi desenvolvido como atividade de avaliação da Unidade 1, aplicando conceitos de Programação Orientada a Objetos, organização em camadas, Model, Repository, Service, Controller, injeção de dependências e testes automatizados com JUnit.

A persistência dos dados é realizada em memória, utilizando estruturas como List e ArrayList.

⸻

Problema

Uma biblioteca precisa manter o controle dos seus livros, leitores e empréstimos.

O sistema foi desenvolvido para facilitar esse gerenciamento, permitindo acompanhar quais livros estão disponíveis, quais estão emprestados e quais empréstimos estão associados aos leitores.

⸻

Funcionalidades

Livros

* Cadastrar livro
* Listar livros
* Listar livros disponíveis

Leitores

* Cadastrar leitor
* Consultar pendências de um leitor

Empréstimos

* Realizar empréstimo de livro
* Registrar devolução
* Listar empréstimos

⸻

Regras de negócio

1. O livro precisa estar cadastrado para que possa ser emprestado.
2. O leitor precisa estar cadastrado para realizar um empréstimo.
3. Um livro que já esteja emprestado não pode ser emprestado novamente.
4. O empréstimo deve estar associado a um livro e a um leitor válidos.
5. Não é possível registrar a devolução de um empréstimo inexistente.

As regras de negócio são verificadas na camada Service e testadas por meio de testes automatizados.

⸻

Arquitetura

O projeto utiliza uma arquitetura dividida em camadas:

Controller
    |
    v
Service
    |
    v
Repository

Model

Representa as entidades utilizadas pelo sistema.

Principais entidades:

* Livro
* Leitor
* Emprestimo

Controller

Responsável por receber as solicitações e realizar a comunicação com a aplicação.

Principais Controllers:

* LivroController
* LeitorController
* EmprestimoController

Service

Responsável pela implementação das regras de negócio da aplicação.

Principais Services:

* LivroService
* LeitorService
* EmprestimoService

Repository

Responsável pelo armazenamento e recuperação dos dados.

A aplicação utiliza persistência em memória por meio de List e ArrayList.

Principais Repositories:

* LivroRepository
* LeitorRepository
* EmprestimoRepository

⸻

Injeção de dependências

O projeto utiliza a injeção de dependências disponibilizada pelo Spring.

Os Services recebem os Repositories por meio do construtor, evitando a criação manual das dependências.

Exemplo:

@Service
public class LivroService {
    private final LivroRepository repository;
    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }
}

⸻

Tecnologias utilizadas

* Java 21
* Maven
* Spring Boot
* JUnit
* Git
* GitHub

⸻

Estrutura do projeto

src/
├── main/
│   └── java/
│       ├── controller/
│       │   ├── LivroController.java
│       │   ├── LeitorController.java
│       │   └── EmprestimoController.java
│       │
│       ├── model/
│       │   ├── Livro.java
│       │   ├── Leitor.java
│       │   └── Emprestimo.java
│       │
│       ├── repository/
│       │   ├── LivroRepository.java
│       │   ├── LeitorRepository.java
│       │   └── EmprestimoRepository.java
│       │
│       ├── service/
│       │   ├── LivroService.java
│       │   ├── LeitorService.java
│       │   └── EmprestimoService.java
│       │
│       └── Main.java
│
├── test/
│   └── java/
│       └── service/
│           ├── LivroServiceTest.java
│           ├── LeitorServiceTest.java
│           └── EmprestimoServiceTest.java
│
├── pom.xml
└── README.md

⸻

Como executar

Com o projeto aberto no terminal, execute:

mvn spring-boot:run

Também é possível executar o projeto diretamente pela IDE utilizando a classe principal da aplicação.

⸻

Como executar os testes

Para executar os testes automatizados:

mvn test

⸻

Testes automatizados

O projeto utiliza JUnit para realização dos testes.

Entre os cenários testados estão:

* Cadastro de livro.
* Cadastro de leitor.
* Realização de empréstimo.
* Tentativa de empréstimo de livro indisponível.
* Tentativa de empréstimo para leitor inexistente.
* Devolução de empréstimo.

Os testes têm como objetivo verificar se as funcionalidades e regras de negócio estão funcionando corretamente.

⸻

Git e GitHub

O desenvolvimento do projeto utiliza Git para controle de versão e GitHub para armazenamento do código.

Foram utilizadas branches para organizar as etapas de desenvolvimento.

Exemplo de organização:

main
|
├── feature/modelos
├── feature/repositories
├── feature/services
├── feature/controllers
└── feature/testes

Exemplos de commits:

feat: cria entidades do sistema
feat: implementa repositories
feat: implementa regras de empréstimo
feat: cria controllers
test: adiciona testes do sistema
docs: atualiza README

O histórico de commits representa as etapas de desenvolvimento do projeto.

⸻

Histórico do desenvolvimento

O desenvolvimento do projeto foi dividido nas seguintes etapas:

1. Definição do problema e das entidades.
2. Criação dos Models.
3. Implementação dos Repositories.
4. Implementação dos Services.
5. Implementação das regras de negócio.
6. Implementação dos Controllers.
7. Configuração do Spring Boot e Maven.
8. Criação dos testes automatizados.
9. Organização do repositório.
10. Documentação do projeto.

⸻

Participação dos integrantes

Bruna Francisca da Silva

Responsável pelo desenvolvimento do Repository, trabalhando na parte de armazenamento e recuperação dos dados da aplicação.

Kamyla Vitória Chagas de Andrade

Responsável pela implementação dos testes automatizados utilizando JUnit, em conjunto com Mayara Eduarda Dias Vieira.

Luísa Geórgia Bezerra Alves

Responsável pelo desenvolvimento dos Controllers, responsáveis pela comunicação e entrada e saída de dados da aplicação.

Maria Gabriella Silva de Lima

Responsável pela documentação do projeto e pela elaboração e organização do README no GitHub, junto com Luísa Geórgia Bezerra Alves.

Mayara Eduarda Dias Vieira

Responsável pelo desenvolvimento dos Models, em conjunto com Tarcilla Maria de Araújo Almeida, e pela implementação dos testes automatizados utilizando JUnit, em conjunto com Kamyla Vitória Chagas de Andrade.

Tarcilla Maria de Araújo Almeida

Responsável pelo desenvolvimento dos Models, em conjunto com Mayara Eduarda Dias Vieira.

Thais Vitória da Silva Nascimento

Responsável pelo desenvolvimento do Service, incluindo a implementação das regras de negócio e das funcionalidades relacionadas aos empréstimos.

⸻

Uso de Inteligência Artificial

Durante o desenvolvimento do projeto, a Inteligência Artificial foi utilizada como ferramenta de apoio.

A ferramenta utilizada foi o ChatGPT, principalmente para auxiliar na compreensão dos conteúdos, esclarecimento de dúvidas, identificação de possíveis erros e organização da documentação.

O código utilizado no projeto foi analisado e adaptado pelos integrantes de acordo com as necessidades da aplicação.

⸻

Apresentação

Durante a apresentação do projeto serão demonstrados:

* O problema que o sistema busca resolver.
* A solução desenvolvida.
* As principais funcionalidades.
* A arquitetura utilizada.
* As regras de negócio.
* A execução da aplicação.
* Os testes automatizados.
* O repositório no GitHub.
* O histórico de desenvolvimento.

⸻

Observações

O projeto foi desenvolvido com foco nos conteúdos da Unidade 1, utilizando:

* Programação Orientada a Objetos;
* Classes e objetos;
* Encapsulamento;
* Interfaces;
* Collections;
* Packages;
* Repository;
* Service;
* Controller;
* Injeção de dependências;
* Maven;
* Spring Boot;
* JUnit;
* Git e GitHub.

A persistência dos dados é realizada em memória, não sendo necessário utilizar banco de dados para este projeto.

⸻

Projeto de Avaliação — Unidade 1

Disciplina: Back-End
Turma: ADS 3P
Professor: Victor Brayner

Tecnologias: Java 21, Maven, Spring Boot e JUnit
