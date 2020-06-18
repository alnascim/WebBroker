package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Sucursal_combo;
import br.com.WebBroker.factory.ConexaoFactory;

public class SucursalcomboDAO {
	
	public ArrayList<Sucursal_combo> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
	
		
		sql.append("SELECT ");
		sql.append("id,concat(tb_codsuc,'-',tb_sucursal) as tb_sucursal ");
		sql.append("from tb_sucursal order by tb_sucursal");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Sucursal_combo> lista = new ArrayList<Sucursal_combo>();

		while (resultado.next()) {
			
			Sucursal_combo f = new Sucursal_combo();
			f.setId_suc(resultado.getLong("id"));
			f.setTb_sucursal(resultado.getString("tb_sucursal"));
			lista.add(f);

		}
		comando.close();
		conexao.close();
		return lista;
	}
	
	
}
