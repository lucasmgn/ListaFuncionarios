package br.com.listafuncionario;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.listafuncionario.Model.Funcionario;
import br.com.listafuncionario.dao.DAOFactory;
import br.com.listafuncionario.dao.FuncionarioDAO;
import br.com.listafuncionario.dao.jdbc.Conexao;
import br.com.listafuncionario.dao.jdbc.jdbcFuncionarioDAO;

public class Main {
	private static int listagem = 0;

	public static void main(String[] args) throws Exception {
		System.out
				.println("===========================================================================================");
		System.out.println("Bem vindo ao Formulário de funcionários da ByteBank !");
		System.out
				.println("===========================================================================================");
		System.out.println(" Opcoes :                                  ");
		System.out.println("        1. Cadastrar Funcionário               ");
		System.out.println("        2. Remover Funcionarios                   ");
		System.out.println("        3. Ver Funcionários ");
		System.out.println("        4. Exit  ");
		System.out
				.println("===========================================================================================");
		System.out.print(" Selecione uma opcao: ");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<Funcionario> funcionarios = new ArrayList<>();
		int n = 0;

		while (n != 4) {
			if (n != 0) {
				System.out.println(
						"===========================================================================================");
				System.out.println("        1. Cadastrar Funcionário               ");
				System.out.println("        2. Remover Funcionarios                   ");
				System.out.println("        3. Ver Funcionários ");
				System.out.println("        4. Exit  ");
				System.out.println(
						"===========================================================================================");
				System.out.print(" Selecione uma opcao: ");
			}
			String opcao = reader.readLine();
			n = Integer.parseInt(opcao);

			switch (n) {
			case 1:
				cadastrandoFuncionario(reader, funcionarios);
				break;
			case 2:
				removendoFuncionario(funcionarios);
				break;

			case 3:
				mostrandoLista(funcionarios);
				break;

			case 4:
				System.out.println(" ");
				System.out.println("Obrigado por realizar o cadastro");
				break;

			default:
				System.out.println("Insira uma opção correta");

			}
		}
	}

	private static void cadastrandoFuncionario(BufferedReader reader, List<Funcionario> funcionarios) throws Exception {
		try {

			System.out.println(" ");
			System.out.println("-- Cadastrando Funcionário --");
			System.out.println(" ");

			// Atribuindo nome completo
			@SuppressWarnings("resource")
			Scanner input1 = new Scanner(System.in);
			System.out.print("Digite o nome completo do funcionário: ");
			String nome1 = input1.nextLine();

			// Atribuindo matricula
			listagem++;

			// Atribuindo cargo
			System.out.println(" ");
			System.out.print("Digite o cargo do funcionário: ");
			String cargo = input1.nextLine();

			// Atribuindo data de nascimento
			System.out.println(" ");
			System.out.print("Digite a data de nascimento do funcionário (dd/MM/yyyy): ");
			String data1 = input1.nextLine();

			// Criando novo funcionário
			Funcionario f = new Funcionario(nome1, listagem, cargo, data1);
			funcionarios.add(f);

			System.out.println(" ");
			System.out.println(
					"-------------------------------- Funcionário(a) cadastrado com sucesso!!--------------------------------");
			System.out.println(" ");

			// Salvando no BD o novo cliente
			FuncionarioDAO funcionarioDAO = DAOFactory.getDAODaoFactory().getFuncionarioDAO();
			funcionarioDAO.cadastrandoFuncionario(f);
			System.out.println(
					"--------------------------------\nCliente Salvo no banco de dados\n--------------------------------");

		} catch (Exception e) {
			throw new Exception("A matricula do funcionário precisar ser número válido");
		}

	}

	private static void removendoFuncionario(List<Funcionario> funcionarios) {

		System.out.println(" ");
		System.out.println("-- Removendo Funcionário --");
		System.out.println(" ");

		// Pegando a matricula do funcionario que será removido
		@SuppressWarnings("resource")
		Scanner input2 = new Scanner(System.in);
		System.out.print("Digite a matricula(listagem) do funcionário que você deseja remover: ");
		int matriculaRemocao = input2.nextInt();

		if (matriculaRemocao != 1) {
			matriculaRemocao -= 1;

		}
		
		FuncionarioDAO funcionarioDAO = new jdbcFuncionarioDAO(Conexao.getConnection());
		funcionarioDAO.excluindoFuncionarios(matriculaRemocao);

		// Removendo funcionário
		System.out.println(
				"\n-------------------------------- Funcionário foi removido -------------------------------------------------\n");

	}

	private static void mostrandoLista(List<Funcionario> funcionarios) {

		System.out.println(" ");
		System.out.println("-- Lista de Funcionários --");
		System.out.println(" ");

		FuncionarioDAO funcionarioDAO = new jdbcFuncionarioDAO(Conexao.getConnection());
		System.out.println(funcionarioDAO.extraindoFuncionario());

	}
}
