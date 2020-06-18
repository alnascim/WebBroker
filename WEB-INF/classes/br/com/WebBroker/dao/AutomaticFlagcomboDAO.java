package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.AutomaticFlag_combo;
import br.com.WebBroker.factory.ConexaoFactory;

public class AutomaticFlagcomboDAO {
	
	public ArrayList<AutomaticFlag_combo> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ID, Name from lemara_finance.vorigem");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();
		
		ArrayList<AutomaticFlag_combo> lista = new ArrayList<AutomaticFlag_combo>();

		while (resultado.next()) {
			
			AutomaticFlag_combo f = new AutomaticFlag_combo();
			f.setId(resultado.getInt("id"));
			f.setName(resultado.getString("name"));
 
			lista.add(f);

		}
		comando.close();
		conexao.close();
		return lista;
	}
	

}
