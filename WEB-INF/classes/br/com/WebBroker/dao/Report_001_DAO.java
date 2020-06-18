package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Report_001;
import br.com.WebBroker.domain.Report_002;
import br.com.WebBroker.factory.ConexaoFactory;

public class Report_001_DAO {

	public ArrayList<Report_001> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select ");
		sql.append(" mid(a.nco_amd_cobranca,1,4) as ANO,	");
		sql.append(" mid(a.nco_amd_cobranca,5,2) as MES,");
		sql.append(" seg.tb_segmento as tb_segmento,");
		sql.append(" CONCAT(SUC.TB_CODSUC,' - ',SUC.TB_SUCURSAL) as tb_sucursal,");
		sql.append(" p.tb_pf_nome as tb_pf_nome,");
 
		sql.append(" a.nco_premio as nco_premio, ");
		sql.append(" a.NCO_COMIS as NCO_COMIS");
		 
		sql.append(" from tb_extrato_comissao  a ");

		sql.append(" inner join tb_segmento seg ");
		sql.append(" on (seg.id = a.id_segmento) ");		

		sql.append(" inner join tb_cliente_PJ j ");
		sql.append(" on (j.tb_numapo = a.nco_apol and j.id_segmento = seg.id) ");
		
		sql.append(" inner join tb_pessoafisica p ");
		sql.append(" on (p.idtb_pessoafisica = j.id_angariador) ");
		
		sql.append(" inner join tb_sucursal suc ");
		sql.append(" on(suc.tb_codsuc = nco_suc) ");
		sql.append(" where j.del_logica='N' ");
		sql.append("order by 1,2,3,4,5");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Report_001> lista = new ArrayList<Report_001>();
		while (resultado.next()) {

			Report_001 f = new Report_001();
			f.setField_01(resultado.getString("ANO") );
			f.setField_02(resultado.getString("MES") );
			f.setField_03(resultado.getString("tb_segmento") );
			f.setField_04(resultado.getString("tb_sucursal") );
			f.setField_05(resultado.getString("tb_pf_nome") );
			f.setField_06(resultado.getDouble("nco_premio") );
			f.setField_07(resultado.getDouble("NCO_COMIS") );
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}
	
	public ArrayList<Report_002> listar_002() throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select ");
		sql.append(" J.TB_RAZAO AS RAZAO,	");
		sql.append(" J.TB_CNPJ AS CNPJ,");
		sql.append(" J.TB_NUMAPO AS APO,");
		sql.append(" P.tb_pf_nome AS ANGARIADOR,");
		sql.append(" J.TB_SENHA_ACESSO AS SENHA,");
		sql.append(" J.tb_vidas as vidas ");
  	 
		sql.append(" from tb_cliente_PJ j  ");

		sql.append(" inner join tb_segmento seg ");
		sql.append(" on (seg.id = J.id_segmento) ");		
 
		sql.append(" inner join tb_pessoafisica p ");
		sql.append(" on (p.idtb_pessoafisica = j.id_angariador) ");
		sql.append(" where j.del_logica='N' ");
		sql.append("ORDER BY J.TB_IDPJ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Report_002> lista = new ArrayList<Report_002>();
		
		while (resultado.next()) {

			Report_002 f = new Report_002();
			f.setField_01(resultado.getString("RAZAO") );
			f.setField_02(resultado.getString("CNPJ") );
			f.setField_03(resultado.getString("APO") );
			f.setField_04(resultado.getString("ANGARIADOR") );
			f.setField_05(resultado.getString("SENHA") );
			f.setField_06(resultado.getString("vidas") );
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}
	public ArrayList<Report_001> listar_rpt4() throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select ");
		sql.append(" mid(a.nco_amd_cobranca,1,4) as ANO,	");
		sql.append(" mid(a.nco_amd_cobranca,5,2) as MES,");
		sql.append(" seg.tb_segmento as tb_segmento,");
		sql.append(" CONCAT(SUC.TB_CODSUC,' - ',SUC.TB_SUCURSAL) as tb_sucursal,");
		sql.append(" age.tb_nome_agencia,");
		sql.append(" p.tb_pf_nome as tb_pf_nome,");
 
		sql.append(" a.nco_premio as nco_premio, ");
		sql.append(" a.NCO_COMIS as NCO_COMIS");
		 
		sql.append(" from tb_extrato_comissao  a ");

		sql.append(" inner join tb_segmento seg ");
		sql.append(" on (seg.id = a.id_segmento) ");		

		sql.append(" inner join tb_cliente_PJ j ");
		sql.append(" on (j.tb_numapo = a.nco_apol and j.id_segmento = seg.id) ");
		
		sql.append(" inner join tb_pessoafisica p ");
		sql.append(" on (p.idtb_pessoafisica = j.id_angariador) ");
		
		sql.append(" inner join lemara_schema.tb_sucursal suc ");
		sql.append(" on(suc.tb_codsuc = nco_suc) ");

		sql.append(" left join lemara_schema.tb_agencias age ");
		sql.append(" on(age.id = j.tb_cod_agencia) ");
		sql.append(" where  j.del_logica='N' ");
		
		sql.append("order by 1,2,3,4,5");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Report_001> lista = new ArrayList<Report_001>();
		while (resultado.next()) {

			Report_001 f = new Report_001();
			f.setField_01(resultado.getString("ANO") );
			f.setField_02(resultado.getString("MES") );
			f.setField_03(resultado.getString("tb_segmento") );
			f.setField_04(resultado.getString("tb_sucursal") );
			f.setField_05(resultado.getString("tb_pf_nome") );
			f.setField_06(resultado.getDouble("nco_premio") );
			f.setField_07(resultado.getDouble("NCO_COMIS") );
			f.setField_08(resultado.getString("tb_nome_agencia") );
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}

}
