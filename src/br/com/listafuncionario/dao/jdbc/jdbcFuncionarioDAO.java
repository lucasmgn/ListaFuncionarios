package br.com.listafuncionario.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

import br.com.listafuncionario.Model.Funcionario;
import br.com.listafuncionario.dao.DAOException;
import br.com.listafuncionario.dao.FuncionarioDAO;

public class jdbcFuncionarioDAO implements FuncionarioDAO {

	private Connection connection;

	public jdbcFuncionarioDAO(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public void cadastrandoFuncionario(Funcionario funcionarios) {

		StringBuilder sql = new StringBuilder(
				"insert " + "into listaSalva (nome,cargo,dataNascimento)" + " values(?, ?, ?)");

		try {
			PreparedStatement ps = this.connection.prepareStatement(sql.toString());
			ps.setString(1, funcionarios.getNome());
			// ps.setInt(2, funcionarios.getMatricula());
			ps.setString(2, funcionarios.getCargo());
			ps.setString(3, funcionarios.getDataNascimento());

			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Erro salvando funcionario", e);
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
			}
		}

	}

	public void excluindoFuncionarios(int matriulaRemocao) {

		StringBuilder sql = new StringBuilder("delete from listaSalva where matricula = ?");
		try {
			PreparedStatement ps = this.connection.prepareStatement(sql.toString());
			ps.setInt(1, matriulaRemocao);
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Funcionario> extraindoFuncionario() {

		StringBuilder sql = new StringBuilder("select * from listasalva");

		List<Funcionario> funcionariosExtract = new ArrayList<>();

		try {
			PreparedStatement ps = this.connection.prepareStatement(sql.toString());
			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					String nome = rs.getString(1);
					int matricula = rs.getInt(2);
					String cargo = rs.getString(3);
					String dataNascimento = rs.getString(4);

					funcionariosExtract.add(new Funcionario(nome, matricula, cargo, dataNascimento));

				}

				return funcionariosExtract;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return funcionariosExtract;

	}

}
