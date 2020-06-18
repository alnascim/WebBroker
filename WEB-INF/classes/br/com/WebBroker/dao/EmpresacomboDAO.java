package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Empresa_combo;
import br.com.WebBroker.factory.ConexaoFactory;

public class EmpresacomboDAO {
	
	public ArrayList<Empresa_combo> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
			
		sql.append("SELECT ");
		sql.append("a.tb_idpj,UCASE(a.tb_razao ) as tb_razao ");
		sql.append(" from tb_cliente_PJ a where a.id_tipo_pj= 0 and a.DEL_LOGICA = 'N' ");

		sql.append(" order by UCASE(a.tb_razao ) DESC");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Empresa_combo> lista = new ArrayList<Empresa_combo>();

		while (resultado.next()) {
			
			Empresa_combo f = new Empresa_combo();
			f.setTb_idpj(resultado.getLong("tb_idpj"));
			f.setTb_razao(resultado.getString("tb_razao"));
 
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}
	
	

}
