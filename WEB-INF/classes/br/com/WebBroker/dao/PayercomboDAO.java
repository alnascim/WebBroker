package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Payer_combo;
import br.com.WebBroker.factory.ConexaoFactory;

public class PayercomboDAO {
	
	public ArrayList<Payer_combo> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT ");
		sql.append("id,account_name ");
		sql.append(" from lemara_finance.tb_account_payer ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Payer_combo> lista = new ArrayList<Payer_combo>();

		while (resultado.next()) {
			
			Payer_combo f = new Payer_combo();
			f.setId(resultado.getInt("id"));
			f.setPayer_name(resultado.getString("account_name"));
 
			lista.add(f);

		}
		comando.close();
		conexao.close();
		return lista;
	}

	
	

}
