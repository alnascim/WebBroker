package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.WebBroker.domain.Papolice;
import br.com.WebBroker.domain.Pfisica;
import br.com.WebBroker.domain.Segmento;
import br.com.WebBroker.factory.ConexaoFactory;

public class PapoliceDAO {

	public ArrayList<Segmento> getprodfromciaEdit(Papolice ap) throws SQLException {
		StringBuilder sql = new StringBuilder();
 		Long Tb_idpj=ap.getCongenere_combo().getTb_idpj();
				
		sql.append("SELECT ");
		sql.append(" a.id, ");
		sql.append(" a.tb_segmento, ");
		sql.append(" a.id_subsegmento, a.nco_cia,");
		sql.append(" a.tb_sigla, ");
		sql.append(" concat(a.nco_cia,' - ',b.tb_razao ,' - ',c.tb_subsegmento) as tb_razao,");
		sql.append(" concat(a.nco_cia,' - ',b.tb_razao ,' - ',c.tb_subsegmento,' Ramo - ',a.tb_sigla) as segmento");

		sql.append(" from tb_segmento a ");
		sql.append(" inner join tb_subsegmento c on a.id_subsegmento = c.idsub ");
		sql.append(" inner join tb_cliente_PJ b on c.tb_idpj=b.tb_idpj ");				
		sql.append(" where b.tb_idpj = " + Tb_idpj);
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Segmento> lista = new ArrayList<Segmento>();

		while (resultado.next()) {
			Segmento f = new Segmento();
			f.setId(resultado.getLong("id"));
			f.setTb_segmento(resultado.getString("segmento"));
			f.setTb_sigla(resultado.getString("tb_sigla"));
			f.setNco_cia(resultado.getInt("nco_cia"));
			f.setTb_razao(resultado.getString("tb_razao"));
			
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
		
	}
	public ArrayList<Segmento> getprodfromcia(Papolice ap) throws SQLException {
		StringBuilder sql = new StringBuilder();
 		Long Tb_idpj=ap.getCongenere_combo().getTb_idpj();
				
		sql.append("SELECT ");
		sql.append(" a.id, ");
		sql.append(" a.tb_segmento, ");
		sql.append(" a.id_subsegmento, a.nco_cia,");
		sql.append(" a.tb_sigla, ");
		sql.append(" concat(a.nco_cia,' - ',b.tb_razao ,' - ',c.tb_subsegmento) as tb_razao,");
		sql.append(" concat(a.nco_cia,' - ',b.tb_razao ,' - ',c.tb_subsegmento,' Ramo - ',a.tb_sigla) as segmento");

		sql.append(" from tb_segmento a ");
		sql.append(" inner join tb_subsegmento c on a.id_subsegmento = c.idsub ");
		sql.append(" inner join tb_cliente_PJ b on c.tb_idpj=b.tb_idpj ");				
		sql.append(" where b.tb_idpj = " + Tb_idpj);
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Segmento> lista = new ArrayList<Segmento>();

		while (resultado.next()) {
			Segmento f = new Segmento();
			f.setId(resultado.getLong("id"));
			f.setTb_segmento(resultado.getString("segmento"));
			f.setTb_sigla(resultado.getString("tb_sigla"));
			f.setNco_cia(resultado.getInt("nco_cia"));
			f.setTb_razao(resultado.getString("tb_razao"));
			
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
		
	}
	public void redo_cgn_combo(Pfisica f) throws SQLException {
		FacesContext context = FacesContext.getCurrentInstance();
		Connection conexao = ConexaoFactory.conectar();
 
 		StringBuilder sql = new StringBuilder();
		String sCPF =  f.getTb_pf_cpf();
		sql.append("SELECT tb_pf_cpf from v_verifycpf where tb_pf_cpf = ?");
 
		try {
 
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());
			comando.setString(1, sCPF);

			ResultSet resultado = comando.executeQuery();
		 
			if (resultado.next()) {
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "CPF Já Cadastrado ! [ "
								+ sCPF + "]", ""));
			} else {
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "CPF Não Cadastrado ! [ "
								+ sCPF + "]", ""));
			}

		} catch (SQLException e) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Erro ao localizar registro. Mensagem: " + e.getMessage(),
					""));

		} finally {
			try {
			 
				 
				conexao.close();
			} catch (Throwable e) {
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Erro ao fechar operação de Localização. Mensagem: "
								+ e.getMessage(), ""));
			}
		}

	}
	public void localizar(Papolice f) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		FacesContext context = FacesContext.getCurrentInstance();
		Connection conexao = ConexaoFactory.conectar();
		 
		sql.append("SELECT d.CITY,d.DISTRICT,d.STREET_ZIPCODE,d.STREET_NAME,t.street_types as 	STREET_TYPE,x.state_name as state  FROM T_CTS_INT_ZIPCODE_DATA d");
		 
		sql.append(" inner join t_cts_streettype t");
		sql.append(" on (t.id = d.street_type)");
		
		sql.append(" inner join t_state x");
		sql.append(" on (x.state_id = d.state)");		
		
		sql.append(" where STREET_ZIPCODE = ?");
		
 		try {
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, f.getSTREET_ZIPCODE());
 
			ResultSet resultado = comando.executeQuery();
			
			if (resultado.next()) {
				f.setSTREET_NAME(resultado.getString("STREET_NAME"));
				f.setCITY(resultado.getString("CITY"));
				f.setDISTRICT(resultado.getString("DISTRICT"));
				f.setSTREET_ZIPCODE(resultado.getString("STREET_ZIPCODE"));
				f.setSTATE(resultado.getString("state"));
				f.setSTREET_TYPE(resultado.getString("STREET_TYPE"));
			} else {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"CEP   Inexistente", ""));
				 
			}
		} catch (SQLException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro ao localizar CEP. Mensagem: " + e.getMessage(), ""));
		
		} finally {
			try {
 
				conexao.close();
			} catch (Throwable e) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro ao fechar operação de Localização. Mensagem: " + e.getMessage(), ""));
				
			}
		}
		
	}
	public ArrayList<Papolice> listarData(String d1, String d2) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT ");
		sql.append("a.id_apolice,");
		sql.append("a.tb_ano_mes_prod,");
		sql.append("a.id_segmento,");
		sql.append("a.id_congenere,");
		sql.append("b.tb_segmento,");
		sql.append("a.tb_IDPJ,");
		sql.append("a.tb_StatusApo,");
		sql.append("a.tb_DataIniVig,");
		sql.append("a.nome_agencia,");
		sql.append("a.tb_DataFimVig,");
		sql.append("a.tb_vl_premio,");
		sql.append("a.tb_vidas,");
		sql.append("a.tb_DataCCB,");
		sql.append("a.tb_DataCorretora,");
		sql.append("a.estipulante,");
		sql.append("a.produtor,");
		sql.append("concat(suc.tb_codsuc,' - ',suc.tb_sucursal) as sucursal,"); 
		sql.append("a.tb_DataSeguradora ");
		
		sql.append(" from tb_apolice a ");
		sql.append(" inner join tb_segmento b on (b.id=a.id_segmento) ");
		sql.append(" inner join tb_sucursal suc on (suc.id=a.id_sucursal) ");
		
		sql.append(" where a.nco_amd_cobranca >= ? and a.nco_amd_cobranca <= ? ");

//		sql.append(" AND a.NCO_PERC <> 0.01 ");
		
		sql.append(" order by a.nco_amd_cobranca,a.nco_apol,NCO_NM_SEGURADO,NCO_PREST");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		

//		Date utilDate1 = fat.getPf_dtinifat();
//		java.sql.Date sqlDate1 = (java.sql.Date) new java.util.Date(utilDate1.getTime());
////		
//		SimpleDateFormat data1 = new SimpleDateFormat("yyyymmdd");
//		int data_1 = Integer.parseInt(data1.format(sqlDate1));	
//		System.out.println(data_1);
		
		
//		Date utilDate2=fatselec.getPf_dtfimfat();
//		java.sql.Date sqlDate2 = (java.sql.Date) new java.util.Date(utilDate2.getTime());
//		
//		SimpleDateFormat data2 = new SimpleDateFormat("yyyymmdd");
//		int data_2 = Integer.parseInt(data2.format(sqlDate2));
//		
		comando.setString(1, d1);
		comando.setString(2, d2);
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Papolice> listadata = new ArrayList<Papolice>();
		while (resultado.next()) {

			Papolice f = new Papolice();
			f.setId_apolice(resultado.getString("id_apolice"));
			f.setId_segmento(resultado.getLong("id_segmento"));
			f.setTb_IDPJ(resultado.getLong("tb_IDPJ"));
			f.setTb_StatusApo(resultado.getString("tb_StatusApo"));
			f.setSegmento(resultado.getString("tb_segmento"));
			f.setPf_DataIniVig(resultado.getDate("tb_DataIniVig"));
			f.setPf_DataFimVig(resultado.getDate("tb_DataFimVig"));
			f.setTb_vl_premio(resultado.getBigDecimal("tb_vl_premio"));
			f.setTb_vidas(resultado.getLong("tb_vidas"));
			f.setTb_DataCCB(resultado.getString("tb_DataCCB"));
			f.setTb_DataCorretora(resultado.getString("tb_DataCorretora"));
			f.setTb_DataSeguradora(resultado.getString("tb_DataSeguradora")); 
			f.setTb_ano_mes_prod(resultado.getString("tb_ano_mes_prod")); 
			f.setTb_nome_agencia(resultado.getString("nome_agencia"));
			f.setNome_produtor(resultado.getString("produtor"));
			f.setEstipulante(resultado.getString("estipulante"));
			f.setTb_sucursal(resultado.getString("sucursal"));
			f.setId_congenere(resultado.getLong("id_congenere"));

			
			listadata.add(f);

		}
		comando.close();
		conexao.close();
		return listadata;

	}
	public ArrayList<Papolice> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT a.id,");
		sql.append("a.id_apolice,");
		sql.append("a.idtb_pessoafisica,");
		sql.append("a.id_sucursal,");
		sql.append("a.id_congenere,");
		sql.append("a.cod_codagencia,");

		sql.append("a.tb_ano_mes_prod,");
		sql.append("a.id_segmento,");
		sql.append("b.tb_segmento,");
		sql.append("a.tb_IDPJ,");
		sql.append("a.tb_StatusApo,");
		sql.append("a.tb_DataIniVig,");
		sql.append("ag.tb_nome_agencia as nome_agencia,");
		sql.append("a.tb_DataFimVig,");
		sql.append("a.tb_vl_premio,");
		sql.append("replace(a.tb_vl_premio,'.',',') as s_vl_premio,");
		sql.append("a.tb_vidas,");
		sql.append("a.tb_DataCCB,");
		sql.append("a.tb_DataCorretora,");
		sql.append("a.tb_DataSeguradora,");

		sql.append("a.dt_cred_1parc,");
		sql.append("a.dt_cred_2parc,");
		sql.append("a.dt_cred_3parc,");
		
		sql.append("Case when a.tb_idpj is null then a.estipulante else p.tb_razao end as estipulante, ");			 
		sql.append(" pf.tb_pf_nome as produtor,");
		sql.append("concat(suc.tb_codsuc,' - ',suc.tb_sucursal) as sucursal "); 
		
		sql.append(" from tb_apolice a ");
		sql.append(" inner join tb_segmento b on (b.id=a.id_segmento) ");
		sql.append(" inner join tb_sucursal suc on (suc.id=a.id_sucursal) ");
		sql.append(" inner join tb_pessoafisica pf on (pf.idtb_pessoafisica = a.idtb_pessoafisica)");
		sql.append(" inner join tb_agencias ag on (ag.tb_cod_agencia = a.cod_codagencia)");
		sql.append(" INNER JOIN tb_cliente_PJ P ON (P.TB_IDPJ=A.TB_IDPJ)");
		sql.append("  order by a.id_apolice desc "); 
				
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Papolice> lista = new ArrayList<Papolice>();

		while (resultado.next()) {

			Papolice f = new Papolice();
			f.setId(resultado.getLong("id"));	
			f.setId_apolice(resultado.getString("id_apolice"));
			f.setIdtb_pessoafisica(resultado.getLong("idtb_pessoafisica"));
			f.setId_sucursal(resultado.getLong("id_sucursal"));
			f.setId_agencia(resultado.getLong("cod_codagencia"));			
			f.setId_segmento(resultado.getLong("id_segmento"));
			f.setTb_IDPJ(resultado.getLong("tb_IDPJ"));
			f.setTb_StatusApo(resultado.getString("tb_StatusApo"));
			f.setSegmento(resultado.getString("tb_segmento"));
			f.setPf_DataIniVig(resultado.getDate("tb_DataIniVig"));
			f.setPf_DataFimVig(resultado.getDate("tb_DataFimVig"));
			f.setTb_vl_premio(resultado.getBigDecimal("tb_vl_premio"));
			f.setsValorPremio(resultado.getString("s_vl_premio"));
			f.setTb_vidas(resultado.getLong("tb_vidas"));
			f.setPf_DataC1(resultado.getDate("dt_cred_1parc"));
			f.setPf_DataC2(resultado.getDate("dt_cred_2parc"));
			f.setPf_DataC3(resultado.getDate("dt_cred_3parc"));

			f.setPf_DataCCB(resultado.getDate("tb_DataCCB"));
			f.setPf_DataCorretora(resultado.getDate("tb_DataCorretora"));
			f.setPf_DataSeguradora(resultado.getDate("tb_DataSeguradora"));
			
			f.setTb_DataCCB(resultado.getString("tb_DataCCB"));
			f.setTb_DataCorretora(resultado.getString("tb_DataCorretora"));
			f.setTb_DataSeguradora(resultado.getString("tb_DataSeguradora")); 
			f.setTb_ano_mes_prod(resultado.getString("tb_ano_mes_prod")); 
			f.setTb_nome_agencia(resultado.getString("nome_agencia"));
			f.setNome_produtor(resultado.getString("produtor"));
			f.setEstipulante(resultado.getString("estipulante"));
			f.setTb_sucursal(resultado.getString("sucursal"));
			f.setId_congenere(resultado.getLong("id_congenere"));
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}

	public void editar(Papolice f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tb_apolice SET ");
		sql.append("  tb_StatusApo = ? ");
		sql.append(" ,dt_cred_1parc = ? ");
		sql.append(" ,dt_cred_2parc = ? ");
		sql.append(" ,dt_cred_3parc = ? ");
		sql.append(" ,tb_vl_premio= ? ");
		sql.append(" ,tb_vidas= ? ");
		sql.append(" ,tb_DataCCB= ? ");
		sql.append(" ,tb_DataCorretora= ? ");
		sql.append(" ,tb_DataSeguradora= ? ");
		sql.append(" ,idtb_pessoafisica= ?  ");
		sql.append(" ,id_sucursal= ?  ");
		sql.append(" ,cod_codagencia= ?  ");
		sql.append(" ,TB_IDPJ= ?  ");
		sql.append(" ,id_segmento= ?  ");
		sql.append(" ,tb_DataIniVig = ? ");
		sql.append(" ,tb_DataFimVig = ? ");
		sql.append(" ,id_congenere = ? ");
		sql.append("  WHERE id = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, f.getTb_StatusApo());
		
		Date utilcred_1parc = null;
		try {
			utilcred_1parc = f.getPf_DataC1();
			java.sql.Date sqlDate = new java.sql.Date(utilcred_1parc.getTime());
			comando.setDate(2, sqlDate);
		} catch (Exception e) {

			comando.setDate(2, null);
		}
		Date utilcred_2parc = null;
		try {
			utilcred_2parc = f.getPf_DataC2();
			java.sql.Date sqlDate = new java.sql.Date(utilcred_2parc.getTime());
			comando.setDate(3, sqlDate);
		} catch (Exception e) {

			comando.setDate(3, null);
		}	
		Date utilcred_3parc = null;
		try {
			utilcred_3parc = f.getPf_DataC3();
			java.sql.Date sqlDate = new java.sql.Date(utilcred_3parc.getTime());
			comando.setDate(4, sqlDate);
		} catch (Exception e) {

			comando.setDate(4, null);
		}	
		
		Double vlpremio=null;				
		try {
			vlpremio=Double.parseDouble(f.getsValorPremio());
			comando.setDouble(5, vlpremio);
		} catch (NumberFormatException e1) {
			comando.setDouble(5, 0);
		}
		
		comando.setLong(6, f.getTb_vidas());
		
		Date utilDateCCB = null;
		try {
			utilDateCCB = f.getPf_DataCCB();
			java.sql.Date sqlDate = new java.sql.Date(utilDateCCB.getTime());
			comando.setDate(7, sqlDate);
		} catch (Exception e) {

			comando.setDate(7, null);
		}
		
		Date utilDateCorretora = null;
		try {
			utilDateCorretora = f.getPf_DataCorretora();
			java.sql.Date sqlDate = new java.sql.Date(utilDateCorretora.getTime());
			comando.setDate(8, sqlDate);
		} catch (Exception e) {

			comando.setDate(8, null);
		}
			
		Date utilDateSeguradora = null;
		try {
			utilDateSeguradora = f.getPf_DataSeguradora();
			java.sql.Date sqlDate = new java.sql.Date(utilDateSeguradora.getTime());
			comando.setDate(9, sqlDate);
		} catch (Exception e) {

			comando.setDate(9, null);
		} 
		
		comando.setLong(10, f.getIdtb_pessoafisica());
		comando.setLong(11, f.getId_sucursal());
		comando.setLong(12, f.getId_agencia());		
		comando.setLong(13, f.getEmpresa_combo().getTb_idpj());
		comando.setLong(14, f.getSegmento_combo().getId());

		Date utilEffDate = null;
		try {
			utilEffDate = f.getPf_DataIniVig();
			java.sql.Date sqlDate = new java.sql.Date(utilEffDate.getTime());
			comando.setDate(15, sqlDate);
		} catch (Exception e) {

			comando.setDate(15, null);
		} 
		
		Date utilExpDate = null;
		try {
			utilExpDate = f.getPf_DataFimVig();
			java.sql.Date sqlDate = new java.sql.Date(utilExpDate.getTime());
			comando.setDate(16, sqlDate);
		} catch (Exception e) {

			comando.setDate(16, null);
		}		
		comando.setLong(17, f.getCongenere_combo().getTb_idpj());
		comando.setLong(18, f.getId());
		
		comando.executeUpdate();
		comando.close();
		conexao.close();
	}

	public void excluir(Papolice f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tb_apolice WHERE id = ?  ");
		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar().prepareStatement(
				sql.toString());

		comando.setLong(1, f.getId());
		comando.executeUpdate();
		comando.close();

	}

	public void salvar(Papolice f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_apolice (");
		sql.append("id_apolice,");
		sql.append("id_segmento,");
		sql.append("id_congenere,");
		sql.append("tb_IDPJ,");
		sql.append("idtb_pessoafisica,");
		sql.append("tb_StatusApo, ");
		sql.append("tb_vidas,");
		sql.append("tb_vl_premio,");
		sql.append("cod_codagencia,");
		sql.append("nome_agencia,");		
		sql.append("dt_cred_1parc,");
		sql.append("dt_cred_2parc,");
		sql.append("dt_cred_3parc,");
		sql.append("tb_DataCCB,");
		sql.append("tb_DataCorretora,");
		sql.append("tb_DataSeguradora,");
		sql.append("id_sucursal,");
		sql.append("tb_DataIniVig,");
		sql.append("tb_DataFimVig,");
		sql.append("tb_ano_mes_prod ");
		sql.append(" ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ");
		sql.append("CASE");
		sql.append(" when month(now()) = 1 then CONCAT('JAN-DE-',YEAR(now()) )");
		sql.append(" when month(now()) = 2 then CONCAT('FEV-DE-',YEAR(now()) )"); 
		sql.append(" when month(now()) = 3 then CONCAT('MAR-DE-',YEAR(now()) )"); 
		sql.append(" when month(now()) = 4 then CONCAT('ABR-DE-',YEAR(now()) )"); 
		sql.append(" when month(now()) = 5 then CONCAT('MAI-DE-',YEAR(now()) )"); 
		sql.append(" when month(now()) = 6 then CONCAT('JUN-DE-',YEAR(now()) )"); 
		sql.append(" when month(now()) = 7 then CONCAT('JUL-DE-',YEAR(now()) )"); 
		sql.append(" when month(now()) = 8 then CONCAT('AGO-DE-',YEAR(now()) )"); 
		sql.append(" when month(now()) = 9 then CONCAT('SET-DE-',YEAR(now()) )"); 
		sql.append(" when month(now()) = 10 then CONCAT('OUT-DE-',YEAR(now()) )"); 
		sql.append(" when month(now()) = 11 then CONCAT('NOV-DE-',YEAR(now()) )"); 
		sql.append(" when month(now()) = 12 then CONCAT('DEZ-DE-',YEAR(now()) )"); 
		sql.append(" END )");
		Connection conexao = ConexaoFactory.conectar();
		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar()
				.prepareStatement(sql.toString());
		
		comando.setString(1, f.getId_apolice());		
		comando.setLong(2, f.getSegmento_combo().getId());
		comando.setLong(3, f.getCongenere_combo().getTb_idpj());		
		comando.setLong(4, f.getEmpresa_combo().getTb_idpj());
		comando.setLong(5, f.getAngariador_combo().getIdtb_pessoafisica());
		comando.setString(6, f.getTb_StatusApo());
		comando.setLong(7, f.getTb_vidas());
		double vpremio = 0;
		
		try {
			vpremio= Double.parseDouble(f.getsValorPremio());
			comando.setDouble(8, vpremio);
		} catch (Exception e) {

			comando.setDouble(8, 0);
		}		
		
		comando.setLong(9, f.getPagencia_combo().getTb_cod_agencia());
		comando.setString(10, f.getPagencia_combo().getTb_nome_agencia());
		
		Date utilcred_1parc = null;
		try {
			utilcred_1parc = f.getPf_DataC1();
			java.sql.Date sqlDate = new java.sql.Date(utilcred_1parc.getTime());
			comando.setDate(11, sqlDate);
		} catch (Exception e) {

			comando.setDate(11, null);
		}
		
		Date utilcred_2parc = null;
		try {
			utilcred_2parc = f.getPf_DataC2();
			java.sql.Date sqlDate = new java.sql.Date(utilcred_2parc.getTime());
			comando.setDate(12, sqlDate);
		} catch (Exception e) {

			comando.setDate(12, null);
		}

		Date utilcred_3parc = null;
		try {
			utilcred_3parc = f.getPf_DataC3();
			java.sql.Date sqlDate = new java.sql.Date(utilcred_3parc.getTime());
			comando.setDate(13, sqlDate);
		} catch (Exception e) {

			comando.setDate(13, null);
		}
			
		Date utilDateCCB = null;
		try {
			utilDateCCB = f.getPf_DataCCB();
			java.sql.Date sqlDate = new java.sql.Date(utilDateCCB.getTime());
			comando.setDate(14, sqlDate);
		} catch (Exception e) {

			comando.setDate(14, null);
		}
		
		Date utilDateCorretora = null;
		try {
			utilDateCorretora = f.getPf_DataCorretora();
			java.sql.Date sqlDate = new java.sql.Date(utilDateCorretora.getTime());
			comando.setDate(15, sqlDate);
		} catch (Exception e) {

			comando.setDate(15, null);
		}

		Date utilDateSeguradora = null;
		try {
			utilDateSeguradora = f.getPf_DataSeguradora();
			java.sql.Date sqlDate = new java.sql.Date(utilDateSeguradora.getTime());
			comando.setDate(16, sqlDate);
		} catch (Exception e) {

			comando.setDate(16, null);
		} 

		comando.setLong(17, f.getCombo_sucursal().getId_suc());	
		
		Date utilEffDate = null;
		try {
			utilEffDate = f.getPf_DataIniVig();
			java.sql.Date sqlDate = new java.sql.Date(utilEffDate.getTime());
			comando.setDate(18, sqlDate);
		} catch (Exception e) {

			comando.setDate(18, null);
		} 
		
		Date utilExpDate = null;
		try {
			utilExpDate = f.getPf_DataFimVig();
			java.sql.Date sqlDate = new java.sql.Date(utilExpDate.getTime());
			comando.setDate(19, sqlDate);
		} catch (Exception e) {

			comando.setDate(19, null);
		}		
				
		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

}
