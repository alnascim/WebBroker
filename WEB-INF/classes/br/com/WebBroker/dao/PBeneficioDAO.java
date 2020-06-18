package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Beneficios;
import br.com.WebBroker.domain.Pfisica;
import br.com.WebBroker.factory.ConexaoFactory;

public class PBeneficioDAO {
	

	public void editar(Pfisica f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE lemara_schema.tb_relat_benef ");
		sql.append("   SET tb_num_carteira = ? ");
		sql.append(" WHERE id_pessoa = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setLong(1, f.getIdtb_pessoafisica());
		comando.setString(2, f.getTb_num_carteira());
		comando.executeUpdate();
		comando.close();
		conexao.close();
	}

	public void excluir(Pfisica f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM lemara_schema.tb_relat_benef WHERE id_pessoa = ?  ");
		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar().prepareStatement(
				sql.toString());

		comando.setLong(1, f.getId_beneficio());
		comando.executeUpdate();
		comando.close();

	}

	public void salvarRelac(Beneficios b) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO lemara_schema.tb_relat_benef(");
		sql.append("id_pessoa,");
		sql.append("tb_num_carteira ");
		sql.append(") VALUES (?,?) ");
		
		Connection conexao = ConexaoFactory.conectar();
		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar()
				.prepareStatement(sql.toString());
		
		comando.setLong(1,b.getId_apolice());		
		comando.setString(2, b.getNum_carteira());
		
//		comando.setLong(1, b.getId_pessoa());		
//		comando.setString(2, b.getNum_carteira());
		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

}
