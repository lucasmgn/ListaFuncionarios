package br.com.listafuncionario.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao{
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/lista_funcionarios", "root", "auhpuk260202");
		}catch(Exception e) {
			throw new RuntimeException("Erro, recuperando conexão com o banco", e);
		}
	}

}
