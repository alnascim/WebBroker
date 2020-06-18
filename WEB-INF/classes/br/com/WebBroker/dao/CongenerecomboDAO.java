package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Congenere_combo;
import br.com.WebBroker.factory.ConexaoFactory;

public class CongenerecomboDAO {
	
	public ArrayList<Congenere_combo> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
			
		sql.append("SELECT ");
		sql.append("a.tb_idpj,");		
		sql.append("Concat(ve.nome,'-',a.tb_Razao) as tb_Razao ");
		sql.append(" from tb_cliente_PJ a ");
		sql.append(" inner join lemara_schema.v_empresasgrupo ve ");
		sql.append(" on ve.id = a.tb_fk_empresagrupo" );
		sql.append(" where a.id_tipo_pj = 1 and a.DEL_LOGICA = 'N'");
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Congenere_combo> lista = new ArrayList<Congenere_combo>();

		while (resultado.next()) {
			
			Congenere_combo f = new Congenere_combo();
			f.setTb_idpj(resultado.getLong("tb_idpj"));
			f.setTb_razao(resultado.getString("tb_razao"));
 
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}
	
	

}
