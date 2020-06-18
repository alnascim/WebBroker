package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.SubGrupoConta;
import br.com.WebBroker.factory.ConexaoFactory;

public class SubGrupoContaDAO {
	
	public ArrayList<SubGrupoConta> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT ");
		sql.append(" a.ID_SQ,a.ID_SQ_FK,b.name,a.NameSub,a.id_subsegmento,case when c.tb_subsegmento is null then 'Não Relacionado com Ramo' Else c.tb_subsegmento end as tb_subsegmento ");
		sql.append(" from lemara_finance.SubGrupoContaResutado a ");
		sql.append(" inner join lemara_finance.GrupoContaResutado b on b.id_sq=a.ID_SQ_FK");
		sql.append(" left join lemara_schema.tb_subsegmento c on c.idsub = a.id_subsegmento");
		sql.append(" order by a.id_sq");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();
		
		ArrayList<SubGrupoConta> lista = new ArrayList<SubGrupoConta>();

		while (resultado.next()) {
			
			SubGrupoConta f = new SubGrupoConta();
			f.setId_sq(resultado.getInt("id_sq"));
			f.setId_sq_fk(resultado.getInt("id_sq_fk"));
			f.setName(resultado.getString("name"));
			f.setNamesub(resultado.getString("namesub"));
			f.setIb_subsegmento(resultado.getInt("id_subsegmento"));
			f.setSubsegmento(resultado.getString("tb_subsegmento"));
			
			lista.add(f);
		}
		comando.close();
		conexao.close();

		return lista;
	}	

	public void excluir(SubGrupoConta f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM lemara_finance.subgrupocontaresutado ");
		sql.append(" WHERE id_sq = ? ");
 		
		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar()
				.prepareStatement(sql.toString());
 		
		comando.setLong(1, f.getId_sq());
 
		comando.executeUpdate();
		comando.close();
 

	}

	public void salvar(SubGrupoConta f) throws SQLException {
		StringBuilder sql = new StringBuilder();
				
		sql.append("INSERT INTO lemara_finance.subgrupocontaresutado (");
		sql.append("id_sq_fk,namesub,id_subsegmento ");

		sql.append(") VALUES (?,?,?) ");		
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setInt(1, f.getGrupoconta_combo().getId());
		comando.setString(2, f.getNamesub());
		comando.setLong(3, f.getSubsegmento_combo().getIdsub());

		comando.executeUpdate();
		comando.close();
		conexao.close();


	}
	
	

}
