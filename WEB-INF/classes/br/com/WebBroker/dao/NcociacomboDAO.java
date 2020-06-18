package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Ncocia_combo;
import br.com.WebBroker.factory.ConexaoFactory;

public class NcociacomboDAO {
	
	public ArrayList<Ncocia_combo> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
			
		sql.append("SELECT ");
		sql.append("concat(b.tb_razao,'-',a.tb_subsegmento) as produto,a.nco_cia,a.idsub ");
		sql.append(" from tb_subsegmento a");
//		sql.append(" inner join tb_segmento seg on a.idsub = seg.id");
		sql.append(" inner join tb_cliente_PJ b on b.tb_idpj=a.tb_idpj where b.DEL_LOGICA = 'N'" );
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Ncocia_combo> lista = new ArrayList<Ncocia_combo>();

		while (resultado.next()) {
			
			Ncocia_combo f = new Ncocia_combo();
			f.setTb_produto(resultado.getString("produto"));
			f.setNco_cia(resultado.getInt("nco_cia"));
			f.setIdsub(resultado.getInt("idsub"));
 
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}
	
	

}
