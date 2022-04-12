package br.com.listafuncionario.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


import br.com.listafuncionario.dao.DAOFactory;
import br.com.listafuncionario.dao.FuncionarioDAO;

public class JdbcDAOFactory extends DAOFactory {
	private Connection connection;
	
	public JdbcDAOFactory() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost/lista_funcionarios", "root", "auhpuk260202");
		}catch(Exception e) {
			throw new RuntimeException("Erro, recuperando conexão com o banco", e);
		}
	}

	@Override
	public FuncionarioDAO getFuncionarioDAO() {
		return new jdbcFuncionarioDAO(connection);
	}
}
