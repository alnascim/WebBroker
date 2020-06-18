package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Angariador_combo;
import br.com.WebBroker.domain.Empresa_combo;
import br.com.WebBroker.factory.ConexaoFactory;

public class AngariadorcomboDAO {
	
	public ArrayList<Angariador_combo> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
	
		
		sql.append("SELECT ");
		sql.append("idtb_pessoafisica,tb_pf_nome ");
		sql.append(" from tb_pessoafisica where id_tipo_pf = 4 order by tb_pf_nome");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Angariador_combo> lista = new ArrayList<Angariador_combo>();

		while (resultado.next()) {
			
			Angariador_combo f = new Angariador_combo();
			f.setIdtb_pessoafisica(resultado.getLong("idtb_pessoafisica"));
			f.setTb_pf_nome(resultado.getString("tb_pf_nome"));
 
			lista.add(f);

		}
		comando.close();
		conexao.close();
		return lista;
	}
	
	public ArrayList<Empresa_combo> listard() throws SQLException {
		StringBuilder sql1 = new StringBuilder();
	
		
		sql1.append("SELECT ");
		sql1.append("tb_idpj,tb_razao ");
		sql1.append(" from tb_cliente_PJ WHERE DEL_LOGICA = 'N' order by tb_razao");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql1.toString());

		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Empresa_combo> listad = new ArrayList<Empresa_combo>();

		while (resultado.next()) {
			
			Empresa_combo f = new Empresa_combo();
			f.setTb_idpj(resultado.getLong("tb_idpj"));
			f.setTb_razao(resultado.getString("tb_razao"));
 
			listad.add(f);

		}
		comando.close();
		conexao.close();

		return listad;
		
	}
	
	
	

}
