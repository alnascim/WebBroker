package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Parent;
import br.com.WebBroker.factory.ConexaoFactory;

public class ParentDAO {
	public ArrayList<Parent> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		/* SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); */

		sql.append("SELECT ");
		sql.append(" id_parent, ");
		sql.append(" tb_parent ");
 
		sql.append(" from tb_parent ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Parent> lista = new ArrayList<Parent>();

		while (resultado.next()) {

			Parent f = new Parent();
			f.setId_parent(resultado.getLong("id_parent"));
			f.setTb_parent(resultado.getString("tb_parent"));

			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}
	public void salvar(Parent f) throws SQLException {

		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_parent ");
		sql.append("(tb_parent) values (?) ");
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getTb_parent());
		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

	public void editar(Parent f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tb_parent SET tb_parent = ? WHERE id_parent = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setString(1, f.getTb_parent());
		comando.setLong(2, f.getId_parent());
 

		comando.executeUpdate();
		comando.close();
		conexao.close();

	}
	public void excluir(Parent f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tb_parent WHERE id_parent = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setLong(1, f.getId_parent());

		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

}
