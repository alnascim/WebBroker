package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Produto;
import br.com.WebBroker.factory.ConexaoFactory;

public class SubSegmentoDAO {
	public ArrayList<Produto> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		/* SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); */

		sql.append("SELECT ");
		sql.append(" idsub, ");
		sql.append(" tb_subsegmento");
		sql.append(" from tb_subsegmento ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Produto> lista = new ArrayList<Produto>();

		while (resultado.next()) {
			
			Produto f = new Produto();
			f.setIdsub(resultado.getLong("idsub"));
			f.setTb_subsegmento(resultado.getString("tb_subsegmento"));

			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}
	public void salvar(Produto f) throws SQLException {

		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_subsegmento ");
		sql.append("(tb_subsegmento) values (?) ");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
 
		comando.setString(1, f.getTb_subsegmento());
 
		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

	public void editar(Produto f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tb_subsegmento SET tb_subsegmento = ? WHERE idsub = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setString(1, f.getTb_subsegmento());
		comando.setLong(2, f.getIdsub());

		comando.executeUpdate();
		comando.close();
		conexao.close();

	}
	public void excluir(Produto f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tb_subsegmento WHERE idsub = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setLong(1, f.getIdsub());

		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

}
