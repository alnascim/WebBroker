
package br.com.WebBroker.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Pagencia;
import br.com.WebBroker.factory.ConexaoFactory;

public class PagenciaDAO {

	public ArrayList<Pagencia> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
			sql.append(" id, ");
			sql.append(" tb_cod_agencia, ");
			sql.append(" tb_nome_agencia ");
	 
			sql.append(" from tb_agencias");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());

			ResultSet resultado = comando.executeQuery();

			ArrayList<Pagencia> lista = new ArrayList<Pagencia>();

			while (resultado.next()) {

				Pagencia f = new Pagencia();
				f.setId_agencia(resultado.getLong("id"));
				f.setTb_cod_agencia(resultado.getLong("tb_cod_agencia"));
				f.setTb_nome_agencia(resultado.getString("tb_nome_agencia"));

				lista.add(f);

			}
		comando.close();
		conexao.close();

		return lista;
	}

	public void salvar(Pagencia f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_agencias ");
		sql.append("(tb_cod_agencia,tb_nome_agencia) values (?,?) ");
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getTb_cod_agencia());
		comando.setString(2, f.getTb_nome_agencia());
		
		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

	public void editar(Pagencia f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tb_agencias SET tb_nome_agencia = ? WHERE id = ?");

		Connection conexao = ConexaoFactory.conectar();

		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar()
				.prepareStatement(sql.toString());

		comando.setString(1, f.getTb_nome_agencia());
		comando.setLong(2, f.getId_agencia());
		
 

		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

	public void excluir(Pagencia f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tb_agencias WHERE id = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setLong(1, f.getId_agencia());

		comando.executeUpdate();
		comando.close();
		conexao.close();


	}

}
