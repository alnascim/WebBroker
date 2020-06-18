package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import br.com.WebBroker.domain.ContasPagar;
import br.com.WebBroker.domain.ListaFatura;
import br.com.WebBroker.domain.Pfisica;
import br.com.WebBroker.factory.ConexaoFactory;

public class ListaFaturaDAO {
	
	private static double iSoma = 0;

	public ArrayList<ListaFatura> listarData(String d1, String d2) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("select ");
		sql.append("mid(a.nco_amd_cobranca,7,2) as DIA,");
		sql.append("mid(a.nco_amd_cobranca,5,2) as MES,");
		sql.append("mid(a.nco_amd_cobranca,1,4) as ANO,");
		sql.append("a.NCO_NR_PROPOSTA, ");
		sql.append("a.NCO_NM_SEGURADO, ");
		sql.append("a.NCO_RAMO, ");
		sql.append("a.NCO_APOL, ");
		sql.append("a.NCO_PREST, ");
		sql.append("a.NCO_fat_comis, ");
		sql.append("CONCAT(TB_CODSUC,' - ',TB_SUCURSAL) as nco_suc, ");
		sql.append("a.nco_endos, ");
		sql.append("a.nco_item, ");
		sql.append("a.nco_premio, ");

		sql.append("Case when a.nco_comis < 0 then nco_comis else 0 end as nco_comis_a ,");
		sql.append("Case when a.nco_comis >= 0 then nco_comis else 0 end as nco_comis_b ,");
		
		sql.append("replace(replace(replace(format(a.NCO_PERC,2), '.','|'),',','.'),'|',',') as NCO_PERC, ");
		sql.append(" replace(replace(replace(format(a.NCO_COMIS,2), '.','|'),',','.'),'|',',') as NCO_COMIS, ");
		sql.append(" replace(replace(replace(format(a.NCO_COMIS,2), '.','|'),',',''),'|',',') as NCO_COMIS_b, ");
		sql.append(" a.nse_nm_agencia, ");
		sql.append(" p.tb_pf_nome, ");
		sql.append(" seg.tb_segmento ");

		sql.append(" from tb_extrato_comissao  a ");

		sql.append(" inner join tb_sucursal suc" );
		sql.append(" on (suc.tb_codsuc=a.nco_suc)" );		
		
		sql.append(" INNER join tb_segmento seg ");
		sql.append(" on (seg.id = a.id_segmento) ");		

		sql.append(" inner join tb_apolice apol ");
		sql.append(" on ( apol.id_apolice = a.nco_apol) ");
		
		sql.append(" inner join tb_pessoafisica p ");
		sql.append(" on (p.idtb_pessoafisica = apol.idtb_pessoafisica) ");

		sql.append(" where a.nco_amd_cobranca >= ? and a.nco_amd_cobranca <= ? ");
		sql.append(" order by a.nco_amd_cobranca asc,nco_suc,NCO_fat_comis");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, d1);
		comando.setString(2, d2);
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<ListaFatura> listadata = new ArrayList<ListaFatura>();
		while (resultado.next()) {

			ListaFatura f = new ListaFatura();
			f.setNco_amd_cobranca(resultado.getString("DIA") + '/'+resultado.getString("MES") + '/'+ resultado.getString("ANO"));
			f.setNco_nr_proposta(resultado.getString("NCO_NR_PROPOSTA"));
			f.setNco_nm_segurado(resultado.getString("NCO_NM_SEGURADO"));
			f.setNco_ramo(resultado.getString("NCO_RAMO"));
			f.setNco_apol(resultado.getString("NCO_APOL"));
			f.setNco_prest(resultado.getString("NCO_PREST"));
			f.setNco_perc(resultado.getString("NCO_PERC"));
			f.setNco_comis_b(resultado.getDouble("NCO_COMIS_b"));
			f.setNco_comis_a(resultado.getDouble("NCO_COMIS_a"));
			f.setTb_pf_nome(resultado.getString("tb_pf_nome"));
			f.setTb_Suc(resultado.getString("nco_suc"));
			f.setTb_Endo(resultado.getString("nco_endos"));
			f.setTb_Item(resultado.getString("nco_item"));
			f.setVl_premio(resultado.getDouble("nco_premio"));
			f.setSegmento(resultado.getString("tb_segmento"));
			f.setTb_nome_agencia(resultado.getString("nse_nm_agencia"));
			f.setTb_fatura(resultado.getString("NCO_fat_comis"));
			
			listadata.add(f);

		}
		comando.close();
		conexao.close();
		return listadata;

	}

	
	public ArrayList<ListaFatura> listar_faturamento_data(ListaFatura fp) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select ID_EXT,concat( ");
		sql.append(" mid(a.nco_amd_cobranca,7,2) ,'/',");
		sql.append(" mid(a.nco_amd_cobranca,5,2) ,'/',");
		sql.append(" mid(a.nco_amd_cobranca,1,4) ) as nco_amd_cobranca,");
		sql.append(" seg.tb_segmento,");
		sql.append("Case when a.nco_comis < 0 then nco_comis else 0 end as nco_comis_a ,");		
		sql.append(" a.nco_suc, ");
		sql.append(" a.nco_Fat_comis,");
		sql.append(" replace(replace(replace(format(a.NCO_COMIS,2), '.','|'),',','.'),'|',',') as NCO_COMIS, ");
		sql.append(" replace(replace(replace(format(a.nco_premio,2), '.','|'),',','.'),'|',',') as nco_premio");
		sql.append(" from tb_extrato_comissao  a ");
		sql.append(" INNER join tb_segmento seg ");
		sql.append(" on (seg.id = a.id_segmento) ");
		
		sql.append(" where DATE_FORMAT(a.nco_amd_cobranca_d, '%Y-%m-%d') between ? and ? ");
		sql.append(" and  a.Status_Conciliacao = 0 ");

		sql.append(" order by tb_segmento,nco_suc asc,a.nco_amd_cobranca asc,NCO_fat_comis asc");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		Date DateIni = null;
		try {
			DateIni = fp.getPf_DataIni();
			java.sql.Date sqlDateIni = new java.sql.Date(DateIni.getTime());
			comando.setDate(1, sqlDateIni);
		} catch (Exception e) {

			comando.setDate(1, null);
		}
		
		Date Datefim = null;
		try {
			Datefim = fp.getPf_DataFim();
			java.sql.Date sqlDateFim = new java.sql.Date(Datefim.getTime());
			comando.setDate(2, sqlDateFim);
		} catch (Exception e) {

			comando.setDate(2, null);
		}
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<ListaFatura> lista = new ArrayList<ListaFatura>();
		while (resultado.next()) {

			ListaFatura f = new ListaFatura();
			f.setID_EXT(resultado.getInt("id_ext"));	
			f.setNco_amd_cobranca(resultado.getString("nco_amd_cobranca"));
			f.setSegmento(resultado.getString("tb_segmento"));
			f.setTb_Suc(resultado.getString("nco_suc"));
			f.setTb_fatura(resultado.getString("NCO_fat_comis"));
			f.setNco_comis(resultado.getString("NCO_COMIS"));
			f.setNco_perc(resultado.getString("nco_premio"));
			f.setNco_comis_a(resultado.getDouble("nco_comis_a"));
						
			lista.add(f);

		}
		comando.close();
		conexao.close();


		return lista;
	}
	
	public ArrayList<ListaFatura> listar_faturamento() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select ID_EXT,concat( ");
		sql.append(" mid(a.nco_amd_cobranca,7,2) ,'/',");
		sql.append(" mid(a.nco_amd_cobranca,5,2) ,'/',");
		sql.append(" mid(a.nco_amd_cobranca,1,4) ) as nco_amd_cobranca,");
		sql.append(" seg.tb_segmento,");
		sql.append("Case when a.nco_comis < 0 then nco_comis else 0 end as nco_comis_a ,");		
		sql.append(" a.nco_suc, ");
		sql.append(" a.nco_Fat_comis,");
		sql.append(" replace(replace(replace(format(a.NCO_COMIS,2), '.','|'),',','.'),'|',',') as NCO_COMIS, ");
		sql.append(" replace(replace(replace(format(a.nco_premio,2), '.','|'),',','.'),'|',',') as nco_premio");
		sql.append(" from tb_extrato_comissao  a ");
		sql.append(" INNER join tb_segmento seg ");
		sql.append(" on (seg.id = a.id_segmento) ");
		
		sql.append(" where a.nco_amd_cobranca_d between ADDDATE(LAST_DAY(SUBDATE(CURDATE(), INTERVAL 1 MONTH)), 1) and LAST_DAY(CURDATE())  ");
		sql.append(" and  a.Status_Conciliacao = 0 ");
		sql.append(" order by tb_segmento,nco_suc asc,a.nco_amd_cobranca asc,NCO_fat_comis asc");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<ListaFatura> lista = new ArrayList<ListaFatura>();
		while (resultado.next()) {

			ListaFatura f = new ListaFatura();
			f.setID_EXT(resultado.getInt("id_ext"));	
			f.setNco_amd_cobranca(resultado.getString("nco_amd_cobranca"));
			f.setSegmento(resultado.getString("tb_segmento"));
			f.setTb_Suc(resultado.getString("nco_suc"));
			f.setTb_fatura(resultado.getString("NCO_fat_comis"));
			f.setNco_comis(resultado.getString("NCO_COMIS"));
			f.setNco_perc(resultado.getString("nco_premio"));
			f.setNco_comis_a(resultado.getDouble("nco_comis_a"));
						
			lista.add(f);

		}
		comando.close();
		conexao.close();


		return lista;
	}
	
	public ArrayList<ListaFatura> listar_inadimp() throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append("select concat(mid(replace(b.nco_amd_cobranca,'-',''),7,2 ),  '/',mid(replace(b.nco_amd_cobranca,'-',''),5,2 ),'/',left(replace(b.nco_amd_cobranca,'-',''),4) ) as nco_amd_cobranca, ");
		sql.append("b.nco_nm_segurado, ");
		sql.append("b.nco_apol,");
		sql.append("B.nco_prest,");
		sql.append("mid(b.nco_amd_cobranca,6,2) as MES,mid(b.nco_amd_cobranca,1,4) as ANO,");
		sql.append("concat(right(b.nco_amd_cobranca_int_next,2),'/', left(b.nco_amd_cobranca_int_next,4)) as nco_amd_cobranca_int_next,");
		sql.append("b.nco_prest_next ,");
		sql.append("b.NCO_COMIS ");
		sql.append("FROM lemara_schema.tb_inadimp b where ");
		sql.append(" nco_prest_received= 'N' order by b.nco_prest,b.nco_apol,b.nco_nm_segurado ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<ListaFatura> lista = new ArrayList<ListaFatura>();
		while (resultado.next()) {

			ListaFatura f = new ListaFatura();
			f.setNco_amd_cobranca(resultado.getString("nco_amd_cobranca"));
			f.setNco_nm_segurado(resultado.getString("NCO_NM_SEGURADO"));
			f.setNco_apol(resultado.getString("NCO_APOL"));
			f.setNco_prest(resultado.getString("NCO_PREST"));
			f.setNco_prest_next(resultado.getString("NCO_PREST_NEXT"));	
			f.setNco_amd_cobranca_int_next(resultado.getString("nco_amd_cobranca_int_next"));	
			f.setVl_premio(resultado.getDouble("nco_comis"));
			lista.add(f);

		}
		comando.close();
		conexao.close();


		return lista;
	}

	public ArrayList<ListaFatura> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append("select ");
		sql.append("mid(a.nco_amd_cobranca,7,2) as DIA,");
		sql.append("mid(a.nco_amd_cobranca,5,2) as MES,");
		sql.append("mid(a.nco_amd_cobranca,1,4) as ANO,");
		sql.append("a.NCO_NR_PROPOSTA, ");
		sql.append("a.NCO_NM_SEGURADO, ");
		sql.append("a.NCO_RAMO, ");
		sql.append("a.NCO_APOL, ");
		sql.append("a.NCO_PREST, ");

		sql.append("CONCAT(TB_CODSUC,' - ',TB_SUCURSAL) as nco_suc, ");
		sql.append("a.nco_endos, ");
		sql.append("a.nco_item, ");
		sql.append("a.nco_premio, ");
		sql.append(" a.nse_nm_agencia, ");
		sql.append("Case when a.nco_comis < 0 then nco_comis else 0 end as nco_comis_a ,");
		sql.append("Case when a.nco_comis >= 0 then nco_comis else 0 end as nco_comis_b ,");

		sql.append(" replace(replace(replace(format(a.NCO_PERC,2), '.','|'),',','.'),'|',',') as NCO_PERC, ");
		sql.append(" replace(replace(replace(format(a.NCO_COMIS,2), '.','|'),',','.'),'|',',') as NCO_COMIS, ");
		sql.append(" replace(replace(replace(format(a.NCO_COMIS,2), '.','|'),',',''),'|',',') as NCO_COMIS_b, ");
		sql.append("a.NCO_fat_comis, ");
		sql.append(" p.tb_pf_nome, ");
		sql.append(" seg.tb_segmento ");

		sql.append(" from tb_extrato_comissao  a ");

		sql.append(" inner join tb_sucursal suc" );
		sql.append(" on (suc.tb_codsuc=a.nco_suc) " );		
		
		sql.append(" INNER join tb_segmento seg ");
		sql.append(" on (seg.id = a.id_segmento) ");		

		sql.append(" inner join tb_apolice apol ");
		sql.append(" on (apol.id_apolice = a.nco_apol) ");
		
		sql.append(" inner join tb_pessoafisica p ");
		sql.append(" on (p.idtb_pessoafisica = apol.idtb_pessoafisica) ");		
		
//		sql.append(" where a.NCO_PERC <> 0.01 ");
		
		sql.append(" order by a.nco_amd_cobranca asc,nco_suc,NCO_fat_comis");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<ListaFatura> lista = new ArrayList<ListaFatura>();
		while (resultado.next()) {

			ListaFatura f = new ListaFatura();
			f.setNco_amd_cobranca(resultado.getString("DIA") + '/'+resultado.getString("MES") + '/'+ resultado.getString("ANO"));
			f.setNco_nr_proposta(resultado.getString("NCO_NR_PROPOSTA"));
			f.setNco_nm_segurado(resultado.getString("NCO_NM_SEGURADO"));
			f.setNco_ramo(resultado.getString("NCO_RAMO"));
			f.setNco_apol(resultado.getString("NCO_APOL"));
			f.setNco_prest(resultado.getString("NCO_PREST"));
			f.setNco_perc(resultado.getString("NCO_PERC"));
			f.setNco_comis_b(resultado.getDouble("NCO_COMIS_b"));
			f.setNco_comis_a(resultado.getDouble("NCO_COMIS_a"));
			f.setTb_pf_nome(resultado.getString("tb_pf_nome"));
			f.setTb_Suc(resultado.getString("nco_suc"));
			f.setTb_Endo(resultado.getString("nco_endos"));
			f.setTb_Item(resultado.getString("nco_item"));
			f.setVl_premio(resultado.getDouble("nco_premio"));
			f.setSegmento(resultado.getString("tb_segmento"));
			f.setTb_nome_agencia(resultado.getString("nse_nm_agencia"));
			f.setTb_fatura(resultado.getString("NCO_fat_comis"));
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}

	public void editar(Integer id_EXT) throws SQLException {
		Connection conexao = ConexaoFactory.conectar();
//		StringBuilder sqlremove = new StringBuilder();
//		sqlremove.append(" UPDATE lemara_schema.tb_extrato_comissao SET ");
//		sqlremove.append(" Status_Conciliacao = 0 ");
//		sqlremove.append(" WHERE Status_Conciliacao = 1 ");
//		PreparedStatement comando_remove = conexao.prepareStatement(sqlremove.toString());
//		comando_remove.executeUpdate();
//		comando_remove.close();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE lemara_schema.tb_extrato_comissao SET ");
		sql.append(" Status_Conciliacao = 1 ");
		sql.append(" WHERE id_ext = ? ");
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setInt(1, id_EXT);
		comando.executeUpdate();
		comando.close();
		conexao.close();
	}

	public void cancelar() throws SQLException {
		Connection conexao = ConexaoFactory.conectar();
		StringBuilder sqlremove = new StringBuilder();
		sqlremove.append(" UPDATE lemara_schema.tb_extrato_comissao SET ");
		sqlremove.append(" Status_Conciliacao = 0 ");
		sqlremove.append(" WHERE Status_Conciliacao = 1 ");
		PreparedStatement comando_remove = conexao.prepareStatement(sqlremove.toString());
		comando_remove.executeUpdate();
		comando_remove.close();
		
		conexao.close();
	}
	
	public void conciliar() throws SQLException {
		Connection conexao = ConexaoFactory.conectar();
		StringBuilder sqlremove = new StringBuilder();
		sqlremove.append(" UPDATE lemara_schema.tb_extrato_comissao SET ");
		sqlremove.append(" Status_Conciliacao = 2 ");
		sqlremove.append(" WHERE Status_Conciliacao = 1 ");
		PreparedStatement comando_remove = conexao.prepareStatement(sqlremove.toString());
		comando_remove.executeUpdate();
		comando_remove.close();
		
		conexao.close();
	}
	
	public double retorna_com() throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append("select sum(nco_comis) as nco_comis FROM lemara_schema.tb_extrato_comissao where Status_Conciliacao = 1");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		while (resultado.next()) {

			iSoma=resultado.getDouble("nco_comis");
 
		}
		comando.close();
		conexao.close();

		return iSoma;
	}
	

}
