
# 📚 Sistema de Gerenciamento de Biblioteca

Este é um sistema Java básico para gerenciamento de uma biblioteca escolar ou universitária. Ele permite o cadastro e controle de empréstimos de livros por alunos e professores, aplicando conceitos de orientação a objetos como **herança**, **polimorfismo**, **encapsulamento** e **listas dinâmicas**.

---

## ✅ Funcionalidades

- Cadastro de alunos e professores (`Pessoa`)
- Cadastro de livros com status de disponibilidade
- Empréstimo e devolução de livros
- Listagem de usuários e livros
- Atualização de dados de usuários
- Controle de datas com `LocalDateTime`
- Organização por meio da classe `Biblioteca` (Gerenciamento central)

---

## 🧱 Estrutura de Classes

```java
Pessoa (abstract)
├── Aluno
├── Professor

Livro

Biblioteca (Gerenciamento do sistema)
Main (classe de execução)
```

---

## 🧠 Conceitos utilizados

- **Herança**: `Aluno` e `Professor` herdam de `Pessoa`
- **Polimorfismo**: Métodos que aceitam objetos do tipo `Pessoa`, podendo ser aluno ou professor
- **Encapsulamento**: Uso de `private` com `getters` e `setters`
- **Collections**: Uso de `ArrayList` para armazenar usuários e livros
- **Datas**: Uso de `LocalDateTime` para controlar prazos de empréstimo

---

## 🚀 Como executar

1. Clone ou baixe o repositório
2. Importe em sua IDE (Eclipse, IntelliJ, VSCode com Java)
3. Compile e execute a classe `Main.java`

---

## 📄 Exemplo de uso

```java
Biblioteca biblioteca = new Biblioteca();

Aluno aluno = new Aluno("Ana", 18, "ana@email.com", "123", "2023A1", "Manhã", "Informática");
Livro livro = new Livro("978-1234567890", "POO com Java", "Tecnologia", null, null, true);

biblioteca.adicionarUsuario(aluno);
biblioteca.adicionarLivro(livro);

aluno.realizarEmprestimo(livro);
```

---

## 📁 Organização sugerida dos arquivos

```
├── model/
│   ├── Pessoa.java
│   ├── Aluno.java
│   ├── Professor.java
│   ├── Livro.java
│   └── Biblioteca.java
├── Main.java
└── README.md
```

---

## 👨‍💻 Autor

- Desenvolvido por **Allisson de Camargo**
- Projeto educacional para praticar **POO em Java**
