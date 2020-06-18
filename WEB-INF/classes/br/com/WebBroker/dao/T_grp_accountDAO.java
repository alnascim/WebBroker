package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.WebBroker.domain.SubGrupoConta_combo;
import br.com.WebBroker.domain.T_grp_account;
import br.com.WebBroker.factory.ConexaoFactory;

import com.mysql.jdbc.CallableStatement;

public class T_grp_accountDAO {

	public ArrayList<SubGrupoConta_combo> getsubgrupo(T_grp_account ap) throws SQLException {
		StringBuilder sql = new StringBuilder();
 		Integer iID_SQ_FK =ap.getGrupoconta_combo().getId();
				
		sql.append("SELECT ID_SQ,ID_SQ_FK,NameSub,id_subsegmento from lemara_finance.SubGrupoContaResutado ");
		sql.append(" where ID_SQ_FK = " + iID_SQ_FK);
				
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();
		ArrayList<SubGrupoConta_combo> lista = new ArrayList<SubGrupoConta_combo>();

		while (resultado.next()) {
			SubGrupoConta_combo f = new SubGrupoConta_combo();
			
			f.setId_(resultado.getInt("id_sq"));
			f.setIdfk_(resultado.getInt("ID_SQ_FK"));
			f.setName_(resultado.getString("NameSub"));
			f.setIdsegmento_(resultado.getInt("id_subsegmento"));
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
		
	}
	public void vFeeType(T_grp_account f) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		FacesContext context = FacesContext.getCurrentInstance();
		Connection conexao = ConexaoFactory.conectar();
		sql.append("SELECT b.id_subsegmento,concat(a.id_sq,b.id_sq,b.id_subsegmento) as fee_id,concat(a.name,'-',b.namesub) as name ");
		sql.append(" FROM lemara_finance.grupocontaresutado a ");
		sql.append(" inner join lemara_finance.subgrupocontaresutado b on b.id_sq_fk=a.id_sq ");
		sql.append(" where a.id_sq = ? and b.id_sq = ? ");

		try {
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());
			comando.setInt(1, f.getGrupoconta_combo().getId());
			comando.setInt(2, f.getSubgrupoconta_combo().getId_());
			
			ResultSet resultado = comando.executeQuery();

		if (resultado.next()) {
				f.setFee_id(resultado.getInt("fee_id"));
				f.setFee_name(resultado.getString("name"));
				f.setSegment_id(resultado.getInt("id_segmento"));
			} else {
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Nao Encontrado", ""));
			}
		} catch (SQLException e) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Erro ao localizar CEP. Mensagem: " + e.getMessage(), ""));

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
		conexao.close();
	}

	public ArrayList<T_grp_account> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		Connection conexao = ConexaoFactory.conectarf();

		sql.append("SELECT ");
		sql.append(" a.ID,");
		sql.append(" a.FEE_ID,");
		sql.append(" a.FEE_NAME , ");
		sql.append(" a.AUTOMATIC_FLAG,");
		sql.append(" (SELECT name FROM lemara_finance.vorigem where id = a.automatic_flag)  as sautomatic_flag,");
		sql.append(" a.DUE_DATE,");
		sql.append(" a.FREQUENCE_ID,");
		sql.append(" b.FREQUENCE_name,");
		sql.append(" a.installments,");
		sql.append(" a.AMOUNT ");
		sql.append(" FROM T_grp_account a");
		sql.append(" left JOIN lemara_finance.tb_account_payer p on p.id = a.payer_id ");	
		sql.append(" inner join t_billing_frequence b on b.id=a.frequence_id");
		sql.append(" inner join lemara_finance.grupocontaresutado g on g.id_sq=a.ID_GRP");
		sql.append(" inner join lemara_finance.subgrupocontaresutado sg on sg.id_sq=a.ID_SUBGRP");
		sql.append(" order by a.ID");
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();
		ArrayList<T_grp_account> lista = new ArrayList<T_grp_account>();
		while (resultado.next()) {

			T_grp_account f = new T_grp_account();

			f.setId(resultado.getInt("ID"));
			f.setFee_id(resultado.getInt("fee_id"));
			f.setFee_name(resultado.getString("fee_name"));
//			f.setFee_type(resultado.getInt("fee_type"));
			f.setAutomatic_flag(resultado.getInt("automatic_flag"));
			f.setDdue_date(resultado.getDate("due_date"));
			f.setFrequence_id(resultado.getInt("frequence_id"));
//			f.setPayer_name(resultado.getString("account_name"));

			f.setBig_amount(resultado.getBigDecimal("amount"));

			f.setSautomatic_flag(resultado.getString("sautomatic_flag"));
			f.setSfrequence(resultado.getString("FREQUENCE_name"));
			f.setInstallments(resultado.getInt("installments"));
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;

	}
	public void excluir(T_grp_account f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM lemara_finance.t_grp_account WHERE id = ?  ");
		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar().prepareStatement(
				sql.toString());

		comando.setLong(1, f.getId());
		comando.executeUpdate();
		comando.close();

	}
	
	public boolean f_checpayment(T_grp_account f){
		boolean result = false; 
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("Select 1 as linha FROM lemara_finance.t_grp_account_payer WHERE fk_id_acc = ? and inst_pay_date is not null");
			new ConexaoFactory();
			PreparedStatement comando = ConexaoFactory.conectar().prepareStatement(
					sql.toString());

			comando.setLong(1, f.getId());
			ResultSet resultado = comando.executeQuery();
			result = resultado.next();
			comando.close();
			resultado.close();
		}catch (SQLException e) {
			e.getMessage();
		}
		return result;
	}
	
	public void salvar(T_grp_account f) throws SQLException {
		StringBuilder sql = new StringBuilder();			
		sql.append("INSERT INTO lemara_finance.T_grp_account (");
		sql.append("FEE_ID,");
		sql.append("FEE_NAME,");
		sql.append("AUTOMATIC_FLAG,");
		sql.append("DUE_DATE,");
		sql.append("FREQUENCE_ID,");
		sql.append("installments,");
		sql.append("AMOUNT,");
		sql.append("EVENT_CODE, ");
		sql.append("payer_id, ");
		sql.append("ID_GRP,");
		sql.append("ID_SUBGRP,");
		sql.append("tb_IDPJ ");
		
		sql.append(") VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ");
 
		Connection conexao = ConexaoFactory.conectar();
		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar().prepareStatement(
				sql.toString());

		comando.setInt(1,f.getFee_id());
		comando.setString(2, f.getFee_name());
		comando.setInt(3, f.getAutomatic_flag_combo().getId());

		Date utilDate = null;
		try {
			utilDate = f.getDdue_date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			comando.setDate(4, sqlDate);
		} catch (Exception e) {

			comando.setDate(4, null);
		}
		comando.setLong(5, f.getFrequence_combo().getId());
		comando.setLong(6, f.getInstallments());

		double vpremio = 0;

		try {
			vpremio = Double.parseDouble(f.getAmount());
			comando.setDouble(7, vpremio);
		} catch (Exception e) {

			comando.setDouble(7, 0);
		}
		comando.setString(8, "99");
		comando.setInt(9, f.getPayer_combo().getId());
		
		comando.setInt(10, f.getGrupoconta_combo().getId());
		comando.setInt(11, f.getSubgrupoconta_combo().getId_());
		comando.setLong(12, f.getEmpresasgrupo().getIdtb_pessoafisica());

		
		comando.executeUpdate();
		comando.close();

		Connection conexaof = ConexaoFactory.conectarf();
		CallableStatement cs1 = (CallableStatement) conexaof.prepareCall("{call sp_CreateAccountPayer()}");				
		cs1.execute();
		CallableStatement cs2 = (CallableStatement) conexaof.prepareCall("{call sp_change_event_code()}");
		cs2.execute();
				
		conexao.close();
 
	}

}
