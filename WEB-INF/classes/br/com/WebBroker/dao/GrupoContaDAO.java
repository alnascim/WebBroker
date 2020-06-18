package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.GrupoConta;
import br.com.WebBroker.factory.ConexaoFactory;

public class GrupoContaDAO {
	
	public ArrayList<GrupoConta> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
 		
		sql.append(" SELECT id_sq,name,Feesign ");
		sql.append(" FROM lemara_finance.grupocontaresutado order by id_sq");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();
		
		ArrayList<GrupoConta> lista = new ArrayList<GrupoConta>();

		while (resultado.next()) {
			
			GrupoConta f = new GrupoConta();
			f.setId(resultado.getInt("id_sq"));
			f.setName(resultado.getString("name"));			
			f.setSign(resultado.getInt("Feesign")); 
			lista.add(f);
		}
		comando.close();
		conexao.close();

		return lista;
	}	

	public void excluir(GrupoConta f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM lemara_finance.grupocontaresutado ");
		sql.append(" WHERE id_sq = ? ");
 		
		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar()
				.prepareStatement(sql.toString());
 		
		comando.setLong(1, f.getId());
 
		comando.executeUpdate();
		comando.close();
 

	}

	public void salvar(GrupoConta f) throws SQLException {
		StringBuilder sql = new StringBuilder();
				
		sql.append("INSERT INTO lemara_finance.grupocontaresutado (");
		sql.append("name,");
		sql.append("feesign ");

		sql.append(") VALUES (?,?) ");		
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, f.getName());
		comando.setLong(2, f.getSign());

		comando.executeUpdate();
		comando.close();
		conexao.close();


	}
	
	

}
