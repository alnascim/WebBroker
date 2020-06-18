package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Titular_combo;
import br.com.WebBroker.factory.ConexaoFactory;

public class TitularcomboDAO {
	
	public ArrayList<Titular_combo> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
			
		sql.append("SELECT ");
		sql.append("idtb_pessoafisica,tb_pf_nome ");
		sql.append(" from tb_pessoafisica where id_tipo_pf = 1 order by tb_pf_nome");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Titular_combo> lista = new ArrayList<Titular_combo>();

		while (resultado.next()) {
			
			Titular_combo f = new Titular_combo();
			f.setIdtb_pessoafisica(resultado.getLong("idtb_pessoafisica"));
			f.setTb_pf_nome(resultado.getString("tb_pf_nome"));
 
			lista.add(f);

		}
		comando.close();
		conexao.close();


		return lista;
	}
	
	

}
