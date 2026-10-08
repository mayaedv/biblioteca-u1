# Sistema de Biblioteca

## Identificação

**Projeto:** Sistema de Biblioteca
**Disciplina:** Desenvolvimento Back-End
**Unidade:** 1
**Turma:** ADS 3P
**Professor:** Victor Brayner

## Integrantes

* Bruna Francisca da Silva
* Kamyla Vitória Chagas de Andrade
* Luísa Geórgia Bezerra Alves
* Maria Gabriella Silva de Lima
* Mayara Eduardo Dias Vieira
* Tarcilla Maria de Araújo Almeida
* Thais Vitória da Silva Nascimento

---

## Sobre o projeto

O Sistema de Biblioteca é uma aplicação Back-End desenvolvida em Java 21 com Spring Boot, com o objetivo de auxiliar no gerenciamento de livros, leitores e empréstimos de uma biblioteca.

O sistema permite realizar operações de cadastro e consulta de livros e leitores, além do controle de empréstimos e devoluções.

O projeto foi desenvolvido como atividade de avaliação da Unidade 1, aplicando conceitos de Programação Orientada a Objetos, organização em camadas, Modelo, Repositório, Serviço, Controlador, injeção de dependências e testes automatizados com JUnit.

A persistência dos dados é realizada em memória, utilizando estruturas como List e ArrayList.

---

## Problema

Uma biblioteca precisa manter o controle de seus livros, leitores e empréstimos.

O sistema foi desenvolvido para facilitar esse gerenciamento, permitindo acompanhar quais livros estão disponíveis, quais estão emprestados e quais empréstimos estão associados aos leitores.

---

## Funcionalidades

### Livros

* Cadastrar livro
* Listar livros
* Listar livros disponíveis

### Leitores

* Leitor de cadastro
* Consultar pendências de um leitor

### Emprestimos

* Realizar empréstimo de livro
* Registrador(a)
* Listar

---

## Regras de negócio

* O livro precisa estar cadastrado para que possa ser emprestado.
* O leitor precisa estar cadastrado para realizar um empréstimo.
* Um livro que já está emprestado, não pode ser emprestado novamente.
* O empréstimo deve estar associado a um livro e a um leitor válido.
* Não é possível registrar a devolução de um empréstimo inexistente.

As regras de negócio são verificadas na camada de serviço e testadas por meio de testes automatizados.

---

## Arquitetura

O projeto utiliza uma arquitetura dividida em camadas:

```text
┌──────────────────────┐
│    Controladores     │
└──────────┬───────────┘
           │
           ▼
┌──────────────────────┐
│       Serviços       │
└──────────┬───────────┘
           │
           ▼
┌──────────────────────┐
│     Repositórios     │
└──────────┬───────────┘
           │
           ▼
┌──────────────────────┐
│       Modelos        │
└──────────────────────┘
```

### Modelo

Representa as entidades utilizadas pelo sistema.

**Principais entidades:**

* Livro
* Leitor
* Emprestimo

### Controlador

Responsável por receber as comissões e realizar a comunicação com a aplicação.

**Controladores principais:**

* Controlador de Livros
* Controlador Leitor
* Controlador Emprestimo

### Serviço

Responsável pela implementação das regras de negócio da aplicação.

**Serviços principais:**

- LivroService
- LeitorService
- EmprestimoService

### Repositório

Responsável pelo armazenamento e recuperação dos dados.

A aplicação utiliza persistência em memória por meio de List e ArrayList.

**Principais Repositórios:**

* Repositório de livros
* Repositório Leitor
* EmprestimoRepository

---

## Injeção de Dependências

O projeto utiliza a injeção de dependências disponibilizadas pelo Spring.

Os Serviços recebem os Repositórios por meio do Construtor, evitando a criação manual das dependências.

**Exemplo:**

```java
@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }
}
```

---

## Às vezes preparado

* Java 21
* Maven
* Bota de mola
* JUnit
* Git
* GitHub

---

## Estrutura do projeto

```text
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
```

---

## Como executar

Com o projeto aberto no terminal, execute:

```bash
mvn spring-boot:run
```

Também é possível executar o projeto diretamente pela IDE utilizando a classe principal da aplicação.

---

## Como executar os testes

Para executar os testes automatizados:

```bash
mvn test
```

---

## Testes automatizados

O projeto utiliza JUnit para realização dos testes.

Entre os cenários testados estão:

* Cadastro de livro.
* Cadastro de leitor.
* Realização de licença.
* Tentativa de empréstimo de livro indisponível.
* Tentativa de empréstimo para leitor inexistente.
* Devolução de.

Os testes têm como objetivo verificar se as funcionalidades e regras de negócio estão funcionando corretamente.

---

## Git e GitHub

O desenvolvimento do projeto utiliza Git para controle de versão e GitHub para armazenamento de código.

Foram utilizados ramos para organizar as etapas de desenvolvimento.

**Exemplo de organização:**

```text
principal
│
├── recurso/
│   ├── modelos/
│   ├── repositórios/
│   ├── serviços/
│   ├── controladores/
│   └── testes/
```

**Exemplos de commits:**

```text
feat: cria entidades do sistema
feat: implementa repositories
feat: implementa regras de empréstimo
feat: cria controllers
test: adiciona testes do sistema
docs: atualizações README
```

O histórico de commits representa as etapas de desenvolvimento do projeto.

---

## Histórico do desenvolvimento

O desenvolvimento do projeto foi dividido nas seguintes etapas:

* Definição do problema e das entidades.
* Criação dos Modelos.
* Implementação dos Repositórios.
* Implementação dos Serviços.
* Implementação das regras de negócio.
* Implementação dos Controladores.
* Configuração do Spring Boot e Maven.
* Criação dos testes automatizados.
* Organização do repositório.
* Documentação do projeto.

---

## Participação dos integrantes

### Bruna Francisca da Silva

Responsável pela implementação da camada de Repositórios em memória (LivroRepository, LeitorRepository e EmprestimoRepository), criando as interfaces e suas respetivas implementações com List e ArrayList para salvar, buscar por ID e listar os dados da aplicação.

### Kamyla Vitória Chagas de Andrade

Responsável pela implementação dos testes automatizados utilizando JUnit, em conjunto com Mayara Eduarda Dias Vieira.

### Luísa Geórgia Bezerra Alves

Responsável pelo desenvolvimento dos Controladores, responsável pela comunicação e entrada e saída de dados da aplicação.

### Maria Gabriella Silva de Lima

Responsável pela documentação do projeto e pela elaboração e organização do README no GitHub, junto com Luísa Geórgia Bezerra Alves.

### Mayara Eduardo Dias Vieira

Responsável pelo desenvolvimento dos Modelos, em conjunto com Tarcilla Maria de Araújo Almeida, e pela implementação dos testes automatizados utilizando JUnit, em conjunto com Kamyla Vitória Chagas de Andrade.

### Tarcilla Maria de Araújo Almeida

Responsável pelo desenvolvimento dos Modelos, em conjunto com Mayara Eduarda Dias Vieira.

### Thais Vitória da Silva Nascimento

Responsável pelo desenvolvimento do Serviço, incluindo a implementação das regras de negócio e das funcionalidades relacionadas aos empréstimos.

---

## Uso de Inteligência Artificial

Durante o desenvolvimento do projeto, a Inteligência Artificial foi utilizada como ferramenta de apoio.

Uma ferramenta utilizada foi o ChatGPT, principalmente para auxiliar na compreensão dos conteúdos, esclarecimento de dúvidas, identificação de possíveis erros e organização da documentação.

O código utilizado no projeto foi detalhado e adaptado pelos integrantes de acordo com as necessidades da aplicação.

**Exemplos de prompts utilizados como apoio:**

* “Explique como funciona a organização em camadas de um projeto Spring Boot, utilizando Model, Repository, Service e Controller.”
* “Explique como implementar um repositório em memória utilizando List e ArrayList em Java.”
* “Explique como realizar testes unitários utilizando JUnit em uma aplicação Java.”
* “Verifique possíveis erros na implementação das regras de negócio de um sistema de biblioteca.”
* “Explique como funciona a injeção de dependências utilizando construtor no Spring Boot.”

---

## t.

Durante a apresentação do projeto serão demonstrados:

* O problema que o sistema busca resolve.
* Uma solução.
* Como principais funcionalidades.
* A arquitetura utilizada.
* As regras de negócio.
* A execução da aplicação.
* Os testes automatizados.
* O ó não GitHub.
* O histórico de desenvolvimento.

---

## Observações

Este projeto foi desenvolvido com foco nos conteúdos estudados durante a *Unidade 1*, priorizando:

* Programação Orientada a Objetos;
* organização em camadas;
* separação de responsabilidades;
* Repository;
* Services;
* Controllers;
* injeção de dependências;
* persistência em memória;
* testes automatizados;
* Maven;
* Spring Boot;
* Git e GitHub.


A persistência dos dados é realizada na memória, não sendo necessário utilizar banco de dados para este projeto.

---

# Projeto de Avaliação — Unidade 1

**Disciplina:** Back-End
**Turma:** ADS 3P
**Professor:** Victor Brayner
**Tecnologias:** Java 21, Maven, Spring Boot e JUnit
