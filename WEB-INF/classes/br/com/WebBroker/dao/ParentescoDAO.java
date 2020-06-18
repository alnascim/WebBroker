
package br.com.WebBroker.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Parentesco;
import br.com.WebBroker.factory.ConexaoFactory;

public class ParentescoDAO {

	public ArrayList<Parentesco> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id_parent,tb_parent FROM tb_parent order by id_parent");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Parentesco> lista = new ArrayList<Parentesco>();

		while (resultado.next()) {
			Parentesco u = new Parentesco();
			u.setTb_id_parent(resultado.getLong("id_parent"));
			u.setTb_parent(resultado.getString("tb_parent"));
			lista.add(u);
		}
		comando.close();
		conexao.close();

		return lista;
	}

	public void salvar(Parentesco f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_parent ");
		sql.append("(tb_parent)");
		sql.append(" VALUES (?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setString(1, f.getTb_parent());

		comando.executeUpdate();
		comando.close();
		conexao.close();


	}

	public void editar(Parentesco f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tb_parent SET tb_parent = ? WHERE id_parent = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setString(1, f.getTb_parent());
		comando.setLong(2, f.getTb_id_parent());

		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

	public void excluir(Parentesco f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tb_parent WHERE id_parent = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setLong(1, f.getTb_id_parent());

		comando.executeUpdate();
		comando.close();
		conexao.close();


	}

}
