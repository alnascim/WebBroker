package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import br.com.WebBroker.domain.PFechamento;
import br.com.WebBroker.domain.Report_001;
import br.com.WebBroker.factory.ConexaoFactory;

import com.mysql.jdbc.CallableStatement;

public class PFechamentoDAO {

	private long  lLote;
	private String path;
	private String pathToReportPackage;
	private Map<String, Object> parameters;

	public void call_report(PFechamento f1) throws Exception {
		lLote=f1.getLote();
		try {
			List<Report_001> report = new ArrayList<Report_001>();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT concat(tb_razao,'-',tb_subsegmento) as CIA, ");
			sql.append("FORMAT(Sum(Case When FeeSign = 1 Then lemara_comiss Else 0 End),2,'de_DE') as Comissao ,");
			sql.append("FORMAT(Sum(Case When FeeSign = -1 Then lemara_comiss Else 0 End),2,'de_DE') as Estorno,");
			sql.append("FORMAT(Sum(lemara_comiss),2,'de_DE') as Comissao_Liquida ");
			sql.append("FROM lemara_finance.vfaturamento ");
			sql.append("Where lote= ? ");
			sql.append("group by concat(tb_razao,'-',tb_subsegmento)");

			Connection conexao = (Connection) ConexaoFactory.conectar();
			PreparedStatement comando = (PreparedStatement) conexao
					.prepareStatement(sql.toString());
			comando.setLong(1, lLote);

			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {

				Report_001 f = new Report_001();
				
				f.setField_01(resultado.getString("cia"));
				f.setField_02(resultado.getString("Comissao"));
				f.setField_03(resultado.getString("Estorno"));
				f.setField_04(resultado.getString("Comissao"));
				f.setField_08(resultado.getString("Comissao_Liquida"));
				report.add(f);

			}

			comando.close();
			
			StringBuilder sql2 = new StringBuilder();
			sql2.append("SELECT 'Total' as CIA, ");
			sql2.append("FORMAT(Sum(Case When FeeSign = 1 Then lemara_comiss Else 0 End),2,'de_DE') as Comissao ,");
			sql2.append("FORMAT(Sum(Case When FeeSign = -1 Then lemara_comiss Else 0 End),2,'de_DE') as Estorno,");
			sql2.append("FORMAT(Sum(lemara_comiss),2,'de_DE') as Comissao_Liquida, "); 
			sql2.append("nco_date_str ");
			sql2.append("FROM lemara_finance.vfaturamento ");
			sql2.append("Where lote= ? ");

			PreparedStatement comando2 = conexao.prepareStatement(sql2
					.toString());
			comando2.setLong(1, lLote);

			ResultSet resultado2 = comando2.executeQuery();
			parameters = new HashMap<String, Object>();
			while (resultado2.next()) {
				parameters.put("pdatamov", resultado2.getString("nco_date_str"));	
				parameters.put("sum_field_02", resultado2.getString("Comissao"));
				parameters.put("sum_field_03", resultado2.getString("Estorno"));
				parameters.put("sum_field_04", resultado2.getString("Comissao"));
				parameters.put("sum_field_08", resultado2.getString("Comissao_Liquida"));
			}
//
			comando2.close();
			
			StringBuilder sql3 = new StringBuilder();
			sql3.append("SELECT  ");
			sql3.append("concat('Fechamento do LOTE - ',lote,' Movimento Compreende entre as datas de ',concat(right(replace(d_ini_fecha,'-',''),2),'/',mid(replace(d_ini_fecha,'-',''),5,2),'/',left(replace(d_ini_fecha,'-',''),4)), ' até ',concat(right(replace(d_fim_fecha,'-',''),2),'/',mid(replace(d_fim_fecha,'-',''),5,2),'/',left(replace(d_fim_fecha,'-',''),4))) as dmov ");
			sql3.append("FROM lemara_finance.t_fechamento ");
			sql3.append("Where lote=? ");

			PreparedStatement comando3 = conexao.prepareStatement(sql3
					.toString());
			comando3.setLong(1,lLote);

			ResultSet resultado3 = comando3.executeQuery();
			while (resultado3.next()) {
				parameters.put("pdata", resultado3.getString("dmov"));	
			}
			comando3.close();			
		
			this.path = this.getClass().getClassLoader().getResource("")
					.getPath();						
			this.pathToReportPackage = this.path
					+ "br/com/WebBroker/Relatorio/";

			JasperReport inputStream = JasperCompileManager.compileReport(this
					.getPathToReportPackage() + "Fechamento.jrxml");
//			
			JasperPrint print = JasperFillManager.fillReport(inputStream,
					parameters, new JRBeanCollectionDataSource(report));

			JasperPrintManager.printReport(print, true);
			JRViewer viewer = new JRViewer(print);
			viewer.setVisible(true);			
 

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<PFechamento> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("a.id,");
		sql.append("a.lote,");
		sql.append("case when a.flag_fechado='Y' then 'Lote Fechado' when a.flag_fechado='N' then 'Lote Aberto' end as flag_fechado,");
		sql.append("case when a.flag_fechado='Y' then 'true' when a.flag_fechado='N' then 'false' end as flag,");
		sql.append("a.d_ini_fecha,");
		sql.append("a.d_fim_fecha from lemara_finance.t_fechamento a");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<PFechamento> lista = new ArrayList<PFechamento>();

		while (resultado.next()) {

			PFechamento f = new PFechamento();

			f.setId(resultado.getInt("id"));
			f.setLote(resultado.getInt("lote"));
			f.setFlag_fechado(resultado.getString("flag_fechado"));
			f.setS_ini_fecha(resultado.getString("d_ini_fecha"));
			f.setS_fim_fecha(resultado.getString("d_fim_fecha"));
			f.setD_ini_fecha(resultado.getDate("d_ini_fecha"));
			f.setD_fim_fecha(resultado.getDate("d_fim_fecha"));
			f.setBflag(true);
			lista.add(f);
		}
		comando.close();
		conexao.close();

		return lista;
	}

	public void reabrir(PFechamento f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("update lemara_finance.t_fechamento set flag_fechado = 'N' WHERE id = ? ");
		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar().prepareStatement(
				sql.toString());

		comando.setLong(1, f.getId());
		comando.executeUpdate();
		comando.close();

	}

	public void excluir(PFechamento f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM lemara_finance.t_fechamento WHERE id = ? ");
		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar().prepareStatement(
				sql.toString());

		comando.setLong(1, f.getId());
		comando.executeUpdate();
		comando.close();

	}

	public void processar_reabertura(PFechamento f) throws SQLException {

		Connection conexao = ConexaoFactory.conectarf();

		CallableStatement cs = (CallableStatement) conexao
				.prepareCall("{call sp_gera_reabertura(?)}");
		cs.setInt("vlote", f.getLote());
		cs.execute();
		conexao.close();

	}

	public void processar_fechamento(PFechamento f) throws SQLException {

		Connection conexao = ConexaoFactory.conectarf();

		CallableStatement cs = (CallableStatement) conexao
				.prepareCall("{call sp_gera_fechamento(?)}");
		cs.setInt("vlote", f.getLote());
		cs.execute();
		conexao.close();

	}

	public void salvar(PFechamento f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO lemara_finance.t_fechamento(LOTE,FLAG_FECHADO,D_INI_FECHA,D_FIM_FECHA,teste");

		sql.append(") VALUES (?,?,?,?,?) ");

		Connection conexao = ConexaoFactory.conectar();
		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar().prepareStatement(
				sql.toString());

		comando.setInt(1, f.getLote());
		comando.setString(2, f.getFlag_fechado());

		Date d_ini_fecha = null;
		java.sql.Date sqlDate1 = null;
		try {
			d_ini_fecha = f.getD_ini_fecha();
			sqlDate1 = new java.sql.Date(d_ini_fecha.getTime());
			comando.setDate(3, sqlDate1);
		} catch (Exception e) {

			comando.setDate(3, null);
		}

		Date d_fim_fecha = null;
		java.sql.Date sqlDate2 = null;
		try {
			d_fim_fecha = f.getD_fim_fecha();
			sqlDate2 = new java.sql.Date(d_fim_fecha.getTime());
			comando.setDate(4, sqlDate2);
		} catch (Exception e) {

			comando.setDate(4, null);
		}
		comando.setInt(5, f.getLote());

		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

	public void recuperar(PFechamento f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		FacesContext context = FacesContext.getCurrentInstance();
		Connection conexao = ConexaoFactory.conectar();
		// sql.append("select concat(year(now()),month(now())) as LOTE ");
		// sql.append("from lemara_finance.t_fechamento b ");
		// sql.append("where not exists (select 1 from lemara_finance.t_fechamento a where a.lote = concat(year(now()),month(now())))");
		sql.append("select case when MAX(LOTE)+1 is null then 100190 else MAX(LOTE)+1 end as LOTE ");
		sql.append("from lemara_finance.t_fechamento b ");
		try {
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());

			ResultSet resultado = comando.executeQuery();

			if (resultado.next()) {
				f.setLote(resultado.getInt("LOTE"));
				f.setFlag_fechado("N");
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

	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}

	public String getPath() {
		return this.path;
	}
}
