package br.com.listafuncionario.dao;

import br.com.listafuncionario.dao.jdbc.JdbcDAOFactory;

public abstract class DAOFactory {
	public static DAOFactory getDAODaoFactory() {
		return new JdbcDAOFactory();
	}
	
	public abstract FuncionarioDAO getFuncionarioDAO();
}
