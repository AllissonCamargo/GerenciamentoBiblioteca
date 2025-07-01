package model;

public class Main {

	public static void main(String[] args) {
		Biblioteca gerenciamento = new Biblioteca();

		// Livros
		Livro l1 = new Livro("123", "Java para inicantes", "Tecnologia", null, null, true);



		// 								============ usuários ==========
		// Professores
		Professor ShirleyDaCostaMonteiro = new Professor("Shirey Shirley da Costa Monteiro", 25,
				"shirley.monteiro@ifap.edu.br", "892.015.870-31",
				3441128, "Programação Orientada a Objetos - Graduação",  7);

		ShirleyDaCostaMonteiro.fazerEmprestimo(l1);

		// Alunos




		gerenciamento.adicionarUsuario(ShirleyDaCostaMonteiro);


		// métodos nos livros
		gerenciamento.adicionarLivro(l1);
		gerenciamento.listarLivros();
		gerenciamento.listarUsuarios();
		gerenciamento.listarAlunosCadastrados();
		gerenciamento.listarProfessoresCadastrados();


		gerenciamento.atualizarUsuario("892.015.870-31", "Shirley da Costa Monteiro", "novo shirley.monteiro@ifap.edu.br", 28, "Programação orientada a objetos");



		gerenciamento.listarDadosProfessores();










	}
}
