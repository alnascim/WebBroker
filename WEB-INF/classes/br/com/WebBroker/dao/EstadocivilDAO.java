package br.com.WebBroker.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Estadocivil;
import br.com.WebBroker.factory.ConexaoFactory;

public class EstadocivilDAO {

	public ArrayList<Estadocivil> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id_est_civ,tb_est_civ FROM tb_estadocivil order by id_est_civ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Estadocivil> lista = new ArrayList<Estadocivil>();

		while (resultado.next()) {
			Estadocivil u = new Estadocivil();
			u.setTb_id_estado(resultado.getLong("id_est_civ"));
			u.setTb_estado(resultado.getString("tb_est_civ"));
			lista.add(u);
		}
		comando.close();
		conexao.close();

		return lista;
	}

	public void salvar(Estadocivil f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_estadocivil ");
		sql.append("(tb_est_civ)");
		sql.append(" VALUES (?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setString(1, f.getTb_estado());

		comando.executeUpdate();
		comando.close();
		conexao.close();


	}

	public void editar(Estadocivil f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tb_estadocivil SET tb_est_civ = ? WHERE id_est_civ = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setString(1, f.getTb_estado());
		comando.setLong(2, f.getTb_id_estado());

		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

	public void excluir(Estadocivil f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tb_estadocivil WHERE id_est_civ = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setLong(1, f.getTb_id_estado());

		comando.executeUpdate();
		comando.close();
		conexao.close();


	}

}
