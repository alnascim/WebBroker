package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.BancoCombo;
import br.com.WebBroker.factory.ConexaoFactory;

public class BancoCarregarDAO {

	public ArrayList<BancoCombo> listar() throws SQLException {

		ArrayList<BancoCombo> lista = new ArrayList<BancoCombo>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT cod,banco FROM lemara_finance.tb_bancos order by cod ");

		Connection conexao = ConexaoFactory.conectar();

		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar().prepareStatement(
				sql.toString());

		ResultSet resultado = comando.executeQuery();
		while (resultado.next()) {

			BancoCombo u = new BancoCombo();

			u.setId(resultado.getInt("cod"));
			u.setBanco(resultado.getString("banco"));

			lista.add(u);

		}
		comando.close();
		conexao.close();

		return lista;
	}

}
