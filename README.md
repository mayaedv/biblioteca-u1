# Sistema de Biblioteca

## Identificação
* **Projeto:** Sistema de Biblioteca
* **Disciplina:** Desenvolvimento Back-End | **Unidade:** 1
* **Turma:** ADS 3P
* **Professor:** Victor Brayner

### Integrantes
* Bruna Francisca da Silva
* Kamyla Vitória Chagas de Andrade
* Luísa Geórgia Bezerra Alves
* Maria Gabriella Silva de Lima
* Mayara Eduarda Dias Vieira
* Tarcilla Maria de Araújo Almeida
* Thais Vitória da Silva Nascimento

---

## Sobre o projeto
O **Sistema de Biblioteca** é uma aplicação Back-End desenvolvida em Java 21 com Spring Boot, com o objetivo de auxiliar no gerenciamento de livros, leitores e empréstimos de uma biblioteca.

O sistema permite realizar operações de cadastro e consulta de livros e leitores, além do controle de empréstimos e devoluções.

O projeto foi desenvolvido como atividade de avaliação da Unidade 1, aplicando conceitos de Programação Orientada a Objetos, organização em camadas (Modelo, Repositório, Serviço e Controlador), injeção de dependências e testes automatizados com JUnit.

A persistência dos dados é realizada em memória, utilizando estruturas como `List` e `ArrayList`.

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
* Cadastrar leitor
* Consultar pendências de um leitor

### Empréstimos
* Realizar empréstimo de livro
* Registrar devolução
* Listar empréstimos

---

## Regras de negócio
* O livro precisa estar cadastrado para que possa ser emprestado.
* O leitor precisa estar cadastrado para realizar um empréstimo.
* Um livro que já está emprestado não pode ser emprestado novamente.
* O empréstimo deve estar associado a um livro e a um leitor válido.
* Não é possível registrar a devolução de um empréstimo inexistente.
* As regras de negócio são verificadas na camada de serviço e testadas por meio de testes automatizados.

---

## Arquitetura
O projeto utiliza uma arquitetura dividida em camadas:

`Controlador` | `Serviço` | `Repositório`

### Modelo
Representa as entidades utilizadas pelo sistema.
* **Principais entidades:** `Livro`, `Leitor`, `Emprestimo`.

### Controlador
Responsável por receber as requisições e realizar a comunicação com a aplicação.
* **Controladores principais:** `LivroController`, `LeitorController`, `EmprestimoController`.

### Serviço
Responsável pela implementação das regras de negócio da aplicação.
* **Serviços principais:** `LivroService`, `LeitorService`, `EmprestimoService`.

### Repositório
Responsável pelo armazenamento e recuperação dos dados. A aplicação utiliza persistência em memória por meio de `List` e `ArrayList`.
* **Principais Repositórios:** `LivroRepository`, `LeitorRepository`, `EmprestimoRepository`.

---

## Injeção de Dependências
O projeto utiliza a injeção de dependências disponibilizada pelo Spring. Os Serviços recebem os Repositórios por meio do construtor, evitando a criação manual das dependências.

Exemplo:
```java
@Service 
public class LivroService { 
    private final LivroRepository repository; 
    
    public LivroService(LivroRepository repository) { 
        this.repository = repository; 
    } 
}

---

## Tecnologias Utilizadas
* Java 21
* Maven
* Spring Boot
* JUnit
* Git
* GitHub

---

## Estrutura do projeto

```text
src/
├── main/
│   └── java/
│       └── com/
│           └── exemplo/
│               └── biblioteca/
│                   ├── controller/
│                   │   ├── EmprestimoController.java
│                   │   ├── LeitorController.java
│                   │   └── LivroController.java
│                   ├── model/
│                   │   ├── Emprestimo.java
│                   │   ├── Leitor.java
│                   │   └── Livro.java
│                   ├── repository/
│                   │   ├── EmprestimoRepository.java
│                   │   ├── EmprestimoRepositoryMemoria.java
│                   │   ├── LeitorRepository.java
│                   │   ├── LeitorRepositoryMemoria.java
│                   │   ├── LivroRepository.java
│                   │   └── LivroRepositoryMemoria.java
│                   ├── service/
│                   │   ├── EmprestimoService.java
│                   │   ├── LeitorService.java
│                   │   └── LivroService.java
│                   └── BibliotecaApplication.java
└── test/
    └── java/
        └── com/
            └── exemplo/
                └── biblioteca/
                    └── service/
                        ├── EmprestimoServiceTest.java
                        ├── LeitorServiceTest.java
                        └── LivroServiceTest.java

pom.xml
README.md
