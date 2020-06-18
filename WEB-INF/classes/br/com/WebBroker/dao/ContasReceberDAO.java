package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import br.com.WebBroker.domain.ContasPagar;
import br.com.WebBroker.factory.ConexaoFactory;

public class ContasReceberDAO {

	public ArrayList<ContasPagar> listar(ContasPagar fp) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("select pa.id_p,");
		sql.append("grp.fee_name,");
		sql.append("pa.due_date,");
		sql.append("replace(replace(replace(format(grp.amount,2), '.','|'),',','.'),'|',',') as amount,");
		sql.append("pa.installment, ");
		sql.append("p.account_name ");
		sql.append("From lemara_finance.t_grp_account grp ");
		sql.append("left join lemara_finance.tb_account_payer p on p.id = grp.payer_id ");
		sql.append("inner join lemara_finance.t_grp_account_payer pa on pa.fk_id_acc = grp.id ");		

		sql.append("inner join lemara_finance.grupocontaresutado gr on gr.id_sq = grp.id_grp ");		
				
		sql.append("WHERE pa.inst_pay_date is null ");
		sql.append("and DATE_FORMAT(pa.due_date, '%Y-%m-%d') between ? and ? ");
		sql.append("and gr.FeeSign = 1 ");
		
		
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

		ArrayList<ContasPagar> listadata = new ArrayList<ContasPagar>();
		while (resultado.next()) {

			ContasPagar f = new ContasPagar();

			f.setP_ID(resultado.getInt("id_p"));
			f.setFee_name(resultado.getString("fee_name"));
			f.setDue_date(resultado.getString("due_date"));
			f.setAmount(resultado.getString("amount"));
			f.setInstallments(resultado.getString("installment"));
			f.setPayer_name(resultado.getString("account_name"));
			f.setPf_due_date(resultado.getDate("due_date"));
			listadata.add(f);
		}
		comando.close();
		conexao.close();
		return listadata;
	}
	public ArrayList<ContasPagar> listarData() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select pa.id_p,");
		sql.append("grp.fee_name,");
		sql.append("pa.due_date,");
		sql.append("replace(replace(replace(format(grp.amount,2), '.','|'),',','.'),'|',',') as amount,");		
		sql.append("pa.installment, ");
		sql.append("p.account_name ");
		sql.append("From lemara_finance.t_grp_account grp ");
		sql.append("left join lemara_finance.tb_account_payer p on p.id = grp.payer_id ");
		sql.append("inner join lemara_finance.t_grp_account_payer pa on pa.fk_id_acc = grp.id ");		
		sql.append("inner join lemara_finance.grupocontaresutado gr on gr.id_sq = grp.id_grp ");		

		sql.append("WHERE DATE_FORMAT(pa.due_date, '%Y-%m-%d') = DATE_ADD(date(now()), INTERVAL 1 day) and pa.inst_pay_date is null ");
		sql.append("and gr.FeeSign = 1 ");
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<ContasPagar> listadata = new ArrayList<ContasPagar>();
		while (resultado.next()) {

			ContasPagar f = new ContasPagar();
			
			f.setP_ID(resultado.getInt("id_p"));
			f.setFee_name(resultado.getString("fee_name"));
			f.setDue_date(resultado.getString("due_date"));
			f.setAmount(resultado.getString("amount"));
			f.setInstallments(resultado.getString("installment"));
			f.setPayer_name(resultado.getString("account_name"));
			f.setPf_due_date(resultado.getDate("due_date"));
			listadata.add(f);

		}

		comando.close();
		conexao.close();
		return listadata;

	}
	public void baixarpagamento(ContasPagar cp) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE LEMARA_FINANCE.t_grp_account_payer SET INST_PAY_DATE = date(now()) WHERE ID_P = ? ");
		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectarf().prepareStatement(
				sql.toString());

		comando.setInt(1, cp.getP_ID());
		comando.executeUpdate();
		comando.close();

	}

}
