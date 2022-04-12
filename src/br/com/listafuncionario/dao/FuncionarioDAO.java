package br.com.listafuncionario.dao;

import java.util.List;

import br.com.listafuncionario.Model.Funcionario;

public interface FuncionarioDAO {

	public void cadastrandoFuncionario(Funcionario funcionarios);

	public List<Funcionario> extraindoFuncionario();
	
	public void excluindoFuncionarios(int matriulaRemocao); 

}
