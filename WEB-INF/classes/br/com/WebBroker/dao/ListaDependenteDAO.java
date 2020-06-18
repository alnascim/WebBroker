package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Papolice;
import br.com.WebBroker.domain.Pdepend;
import br.com.WebBroker.domain.Pfisica;
import br.com.WebBroker.factory.ConexaoFactory;

public class ListaDependenteDAO {
	
	public ArrayList<Pdepend> buscaDepend(Pfisica fisica) throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT ");
		sql.append(" d.idtb_dependente, ");
		sql.append(" d.idtb_pessoafisica, ");
		sql.append(" d.tb_pf_nome, ");
		sql.append(" t.tb_pf_nome as tb_pf_nome_t, ");
		sql.append(" d.tb_pf_datanasc, ");
		sql.append(" d.tb_pf_cpf, ");
		sql.append(" d.tb_pf_nro_docto ");		

		sql.append(" From tb_dependente d ");
		sql.append(" join tb_pessoafisica t on (d.idtb_pessoafisica = t.idtb_pessoafisica) ");		
		
		sql.append(" Where t.idtb_pessoafisica = ?  order by d.tb_pf_nome");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
	
		try {
			
			comando.setLong(1,fisica.getIdtb_pessoafisica() );
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ResultSet resultado = comando.executeQuery();

		ArrayList<Pdepend> lista = new ArrayList<Pdepend>();

		while (resultado.next()) {

			Pdepend item = new Pdepend();

			item.setIdtb_dependente(resultado.getLong("idtb_dependente"));
			item.setIdtb_pessoafisica(resultado.getLong("idtb_pessoafisica"));
			item.setTb_pf_nome(resultado.getString("tb_pf_nome"));
			item.setTb_pf_datanasc(resultado.getString("tb_pf_datanasc"));
			item.setTb_pf_cpf(resultado.getString("tb_pf_cpf"));

			lista.add(item);

		}
		comando.close();
		conexao.close();

		return lista;
	}
	
	
	
}
