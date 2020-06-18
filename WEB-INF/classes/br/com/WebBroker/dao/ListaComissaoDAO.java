package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.ListaComissao;
import br.com.WebBroker.factory.ConexaoFactory;

public class ListaComissaoDAO {
	
	public ArrayList<ListaComissao> listarData(String d1, String d2,String d3) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("select pj.tb_razao as Empresa,");
		sql.append("a.nco_apol as Apolice,");
		sql.append("apol.tb_ano_mes_prod as Producao,");
		sql.append("Case when left(seg.tb_segmento,1)='A' then 'AUTO'");
		sql.append("when left(seg.tb_segmento,1)='S' then 'SAÚDE'");
		sql.append("when left(seg.tb_segmento,1)='D' then 'DENTAL'");
		sql.append("when left(seg.tb_segmento,1)='V' then 'VIDA' else 'OUTROS' end as Implantacao,");
		sql.append("a.nse_nm_sucursal as Sucursal,");
		sql.append("a.nse_nm_agencia as Agencia,");
		sql.append("concat(a.nco_prest,'a Parc') as Parcela,");
		sql.append("Concat(right(a.nco_amd_cobranca ,2),'-',mid(a.nco_amd_cobranca ,5,2),'-',left(a.nco_amd_cobranca,4)) as Lanc_Site,");
		sql.append("replace(replace(replace(format(a.nco_perc,2), '.','|'),',','.'),'|',',') as PercSite100,");
		sql.append("100 as Perc_Lemara,");
		sql.append("replace(replace(replace(format(a.NCO_COMIS,2), '.','|'),',','.'),'|',',') as Lemara_Comiss,");
		sql.append("Case when a.net_comis is null then 0 else replace(replace(replace(format(a.net_comis,2), '.','|'),',','.'),'|',',') end as Angar_Comiss,");
		sql.append("p.tb_pf_nome");
		sql.append(" from tb_extrato_comissao  a ");
		sql.append(" inner join tb_segmento seg "); 
		sql.append(" on (seg.id = a.id_segmento) "); 
		sql.append(" inner join tb_apolice apol ");  
		sql.append(" on (apol.id_apolice = a.nco_apol) "); 
		sql.append(" inner join tb_cliente_PJ pj ");
		sql.append(" on pj.tb_idpj = apol.tb_idpj ");
		sql.append(" inner join tb_pessoafisica p ");
		sql.append(" on (p.idtb_pessoafisica = apol.idtb_pessoafisica)  ");
		
		sql.append(" where a.nco_prest in (1,2) and pj.DEL_LOGICA = 'N' "); 
		sql.append(" and a.nco_amd_cobranca >= ? and a.nco_amd_cobranca <= ? ");
//		sql.append(" and p.TB_PF_NOME = ? ");
        if (d3 != ""){
        	sql.append(" and p.TB_PF_NOME = ? ");
        }
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
	    comando.setString(1, d1);
		comando.setString(2, d2);
//		comando.setString(3, d3);
	        if (d3 != ""){
	    		comando.setString(3, d3);
	        }
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<ListaComissao> listadata = new ArrayList<ListaComissao>();
		while (resultado.next()) {

			ListaComissao f = new ListaComissao();
			
			f.setTb_Razao(resultado.getString("Empresa"));
			f.setNco_apol(resultado.getString("Apolice"));
			f.setNco_amd_cobranca(resultado.getString("Producao"));
			f.setSegmento(resultado.getString("implantacao"));
			f.setTb_surcursal(resultado.getString("Sucursal"));
			f.setNco_nm_segurado(resultado.getString("Agencia"));
			f.setNco_prest(resultado.getString("parcela"));
			f.setNco_ramo(resultado.getString("Lanc_Site"));
			f.setNco_perc(resultado.getString("PercSite100"));
			f.setNco_nr_proposta(resultado.getString("Perc_Lemara"));
			f.setNet_comis(resultado.getString("Lemara_Comiss"));
			f.setNco_comis(resultado.getString("Angar_Comiss"));
			f.setTb_pf_nome(resultado.getString("tb_pf_nome"));
			
			listadata.add(f);

		}

		comando.close();
		conexao.close();
		return listadata;

	}
	public ArrayList<ListaComissao> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select pj.tb_razao as Empresa,");
		sql.append("a.nco_apol as Apolice,");
		sql.append("apol.tb_ano_mes_prod as Producao,");
		sql.append("Case when left(seg.tb_segmento,1)='A' then 'AUTO'");
		sql.append("when left(seg.tb_segmento,1)='S' then 'SAÚDE'");
		sql.append("when left(seg.tb_segmento,1)='D' then 'DENTAL'");
		sql.append("when left(seg.tb_segmento,1)='V' then 'VIDA' else 'OUTROS' end as Implantacao,");
		sql.append("a.nse_nm_sucursal as Sucursal,");
		sql.append("a.nse_nm_agencia as Agencia,");
		sql.append("concat(a.nco_prest,'a Parc') as Parcela,");
		sql.append("Concat(right(a.nco_amd_cobranca ,2),'-',mid(a.nco_amd_cobranca ,5,2),'-',left(a.nco_amd_cobranca,4)) as Lanc_Site,");
		sql.append("replace(replace(replace(format(a.nco_perc,2), '.','|'),',','.'),'|',',') as PercSite100,");
		sql.append("100 as Perc_Lemara,");
		sql.append("replace(replace(replace(format(a.NCO_COMIS,2), '.','|'),',','.'),'|',',') as Lemara_Comiss,");
		sql.append("Case when a.net_comis is null then 0 else replace(replace(replace(format(a.net_comis,2), '.','|'),',','.'),'|',',') end as Angar_Comiss,");
		sql.append("p.tb_pf_nome");
		
		sql.append(" from tb_extrato_comissao  a ");
		sql.append(" inner join tb_segmento seg "); 
		sql.append(" on (seg.id = a.id_segmento) "); 
		sql.append(" inner join tb_apolice apol ");  
		sql.append(" on (apol.id_apolice = a.nco_apol) "); 
		sql.append(" inner join tb_cliente_PJ pj ");
		sql.append(" on pj.tb_idpj = apol.tb_idpj ");
		sql.append(" inner join tb_pessoafisica p ");
		sql.append(" on (p.idtb_pessoafisica = apol.idtb_pessoafisica)  ");
		
		sql.append(" where a.nco_prest in (1,2) "); 
//		sql.append("select replace(replace(replace(format(g.tb_perccomis,2), '.','|'),',','.'),'|',',') as tb_perccomis, ");
//		sql.append("mid(a.nco_amd_cobranca,5,2) as mes,");
//		sql.append("mid(a.nco_amd_cobranca,1,4) as ano,");
//		sql.append("a.NCO_NM_SEGURADO, ");
//		sql.append("a.NCO_PREST, ");
//		sql.append(" replace(replace(replace(format(a.NCO_COMIS,2), '.','|'),',','.'),'|',',') as NCO_COMIS, ");
//		sql.append(" replace(replace(replace(format(sum(a.NET_COMIS),2), '.','|'),',','.'),'|',',') as NET_COMIS, ");
//
//		sql.append(" p.tb_pf_nome, ");
//		sql.append(" seg.tb_segmento ");
//
//		sql.append("from tb_extrato_comissao  a ");
//
//		sql.append("inner join tb_segmento seg ");
//		sql.append("on (seg.id = a.id_segmento) ");
//
//		sql.append(" inner join tb_apolice apol  ");
//		sql.append(" on (apol.id_apolice = a.nco_apol) ");
//
//
//		sql.append(" inner join tb_gradecomis g ");
//		sql.append(" on (g.id_angariador = p.idtb_pessoafisica ");
//		sql.append(" and g.id_segmento = a.id_segmento ");
//		sql.append(" and g.id_parcela = a.nco_prest) ");
//
//		sql.append(" where a.nco_prest in (1,2,3) and a.NCO_perc in (100,50) ");

//		sql.append(" group by g.tb_perccomis,left(a.nco_amd_cobranca,6) ,a.NCO_PREST,p.tb_pf_nome,seg.tb_segmento ");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<ListaComissao> lista = new ArrayList<ListaComissao>();
		while (resultado.next()) {

			ListaComissao f = new ListaComissao();
			
			f.setTb_Razao(resultado.getString("Empresa"));
			f.setNco_apol(resultado.getString("Apolice"));
			f.setNco_amd_cobranca(resultado.getString("Producao"));
			f.setSegmento(resultado.getString("implantacao"));
			f.setTb_surcursal(resultado.getString("Sucursal"));
			f.setNco_nm_segurado(resultado.getString("Agencia"));
			f.setNco_prest(resultado.getString("parcela"));
			f.setNco_ramo(resultado.getString("Lanc_Site"));
			f.setNco_perc(resultado.getString("PercSite100"));
			f.setNco_nr_proposta(resultado.getString("Perc_Lemara"));
			f.setNet_comis(resultado.getString("Lemara_Comiss"));
			f.setNco_comis(resultado.getString("Angar_Comiss"));
			f.setTb_pf_nome(resultado.getString("tb_pf_nome"));
			
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}
	public ArrayList<ListaComissao> listarResumo() throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append("select ");
		sql.append(" COMISS, ");
		sql.append(" TB_SEGMENTO,");
		sql.append(" mid(nco_amd_cobranca,5,2) as MES,");
		sql.append(" mid(nco_amd_cobranca,1,4) as ANO,");
		sql.append(" TITULO ");
						
		sql.append(" from v_ResumoComiss order by LEFT(nco_amd_cobranca,6) DESC,R_ID ");
 
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<ListaComissao> lista = new ArrayList<ListaComissao>();
		while (resultado.next()) {

			ListaComissao f = new ListaComissao();
			f.setNco_amd_cobranca(resultado.getString("MES")+'/'+resultado.getString("ANO"));
	 		f.setNco_comis(resultado.getString("COMISS"));
			f.setSegmento(resultado.getString("tb_segmento"));
			f.setTb_surcursal(resultado.getString("TITULO"));
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}
	public static void main(String[] args) {
		
		 ListaComissaoDAO udao = new ListaComissaoDAO();
		 
		 try { ArrayList<ListaComissao> lista = udao.listar();
		 
		 for(ListaComissao u : lista){ System.out.println("Resulado: " + u);
		 
		 }
		 
		 
		 } catch (SQLException e) { System.out.println("Erro ao lista");
		 e.printStackTrace(); }


	}
	
	

}
