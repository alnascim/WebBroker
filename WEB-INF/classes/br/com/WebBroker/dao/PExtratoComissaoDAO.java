package br.com.WebBroker.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import br.com.WebBroker.domain.PExtratoComissao;
import br.com.WebBroker.factory.ConexaoFactory;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class PExtratoComissaoDAO {

	private Map<String, Object> parameters;
	private String path;
	private String pathToReportPackage;

	public ArrayList<PExtratoComissao> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT tb_pf_nome, ");
		sql.append("nco_date_str,	");
		sql.append("nco_date_abr,   ");
		sql.append("Nome_Produto, ");
		sql.append("nco_long_date, ");
		sql.append("Replace(sum(net_comis),'.',',') as net_comis,  ");
		sql.append("Replace(sum(nco_comis),'.',',') as nco_comis  ");
		sql.append("FROM lemara_finance.vagentcommission a ");
		sql.append("group by tb_pf_nome,nco_date_str,nco_date_abr,Nome_Produto,nco_long_date ");
		sql.append("order by nco_date_abr,tb_pf_nome");

		Connection conexao = (Connection) ConexaoFactory.conectar();

		PreparedStatement comando = (PreparedStatement) conexao
				.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<PExtratoComissao> lista = new ArrayList<PExtratoComissao>();

		while (resultado.next()) {

			PExtratoComissao f = new PExtratoComissao();

			f.setTb_pf_nome(resultado.getString("tb_pf_nome"));
			f.setNco_amd_cobranca(resultado.getString("nco_date_abr"));
			f.setNco_date_str(resultado.getString("nco_date_str"));
			f.setNet_comis(resultado.getString("net_comis"));
			f.setNco_comis(resultado.getString("nco_comis"));
			f.setSegmento(resultado.getString("Nome_Produto"));
			f.setNco_long_date(resultado.getString("nco_long_date"));

			lista.add(f);
		}
		comando.close();
		conexao.close();

		return lista;
	}

	public ArrayList<PExtratoComissao> listar_corretor() throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT nse_nm_sucursal,");
		sql.append("nse_nm_agencia,");
		sql.append("tb_pf_nome,");
		// sql.append("nco_nm_segurado,");
		// sql.append("nco_apol,");
		sql.append("Replace(sum(nco_comis),'.',',') as nco_comis,");
		sql.append("nco_date_str,");
		sql.append("nome_subproduto ");
		sql.append("FROM lemara_finance.vbrokercommission ");
		sql.append(" group by nse_nm_sucursal,nse_nm_agencia,tb_pf_nome,nco_date_str,nome_subproduto");
		sql.append(" order by nse_nm_sucursal,nse_nm_agencia,tb_pf_nome,nco_date_str,nome_subproduto");

		Connection conexao = (Connection) ConexaoFactory.conectar();

		PreparedStatement comando = (PreparedStatement) conexao
				.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<PExtratoComissao> lista = new ArrayList<PExtratoComissao>();

		while (resultado.next()) {

			PExtratoComissao f = new PExtratoComissao();

			f.setTb_surcursal(resultado.getString("nse_nm_sucursal"));
			f.setNse_nm_agencia(resultado.getString("nse_nm_agencia"));
			f.setTb_pf_nome(resultado.getString("tb_pf_nome"));
			// f.setNco_nm_segurado(resultado.getString("NCO_NM_SEGURADO"));
			// f.setNco_apol(resultado.getString("nco_apol"));
			f.setNco_comis(resultado.getString("nco_comis"));
			f.setSegmento(resultado.getString("nome_subproduto"));
			f.setNco_date_str(resultado.getString("nco_date_str"));

			lista.add(f);
		}
		comando.close();
		conexao.close();

		return lista;
	}

	public void call_report_angariador(PExtratoComissao f1) throws Exception {
		try {
			List<PExtratoComissao> report = new ArrayList<PExtratoComissao>();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT tb_ano_mes_prod,");
			sql.append("tb_pf_nome,");
			sql.append("NCO_NM_SEGURADO,");
			sql.append("nco_date_str,");
			sql.append("nco_prest,");
			sql.append("nco_date_abr,");
			sql.append("NCO_NR_PROPOSTA,");
			sql.append("Nome_Produto,");
			sql.append("Replace(nco_comis,'.',',') as nco_comis,");
			sql.append("Replace(net_comis,'.',',') as net_comis,");
			sql.append("nse_nm_sucursal ");
			sql.append("FROM lemara_finance.vagentcommission a ");
			sql.append("inner join lemara_schema.tb_apolice b on b.id_apolice=a.nco_apol ");
			sql.append("WHERE tb_pf_nome = ?");
			sql.append("and nco_date_abr = ?");
			sql.append("and Nome_Produto = ?");

			Connection conexao = (Connection) ConexaoFactory.conectar();
			PreparedStatement comando = (PreparedStatement) conexao
					.prepareStatement(sql.toString());

			comando.setString(1, f1.getTb_pf_nome());
			comando.setString(2, f1.getNco_amd_cobranca());
			comando.setString(3, f1.getSegmento());

			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {

				PExtratoComissao f = new PExtratoComissao();
				f.setTb_pf_nome(resultado.getString("tb_pf_nome"));
				f.setNco_nm_segurado(resultado.getString("NCO_NM_SEGURADO"));
				f.setNco_amd_cobranca(resultado.getString("nco_date_abr"));
				f.setNco_date_str(resultado.getString("nco_date_str"));
				f.setNco_nr_proposta(resultado.getString("NCO_NR_PROPOSTA"));
				f.setSegmento(resultado.getString("Nome_Produto"));
				f.setNco_comis(resultado.getString("nco_comis"));
				f.setNet_comis(resultado.getString("net_comis"));
				f.setTb_surcursal(resultado.getString("nse_nm_sucursal"));
				f.setTb_ano_mes_prod(resultado.getString("tb_ano_mes_prod"));
				f.setNco_prest(resultado.getString("nco_prest"));
				report.add(f);

			}

			comando.close();
			parameters = new HashMap<String, Object>();

			parameters.put("data_move", f1.getNco_long_date());
			parameters.put("segmento", f1.getSegmento());
			parameters.put("angariador", f1.getTb_pf_nome());
			parameters.put("sum_net_comis", f1.getNet_comis());
			parameters.put("sum_nco_comis", f1.getNco_comis());

			conexao.close();
			
			this.path = this.getClass().getClassLoader().getResource("")
					.getPath();
			this.pathToReportPackage = this.path
					+ "br/com/WebBroker/Relatorio/";
			
			JasperReport report_1 = JasperCompileManager.compileReport(this
					.getPathToReportPackage() + "ExtratoAngariador.jrxml");

			JasperPrint print = JasperFillManager.fillReport(report_1,
					parameters, new JRBeanCollectionDataSource(report));

			JasperPrintManager.printReport(print, true);
			JRViewer viewer = new JRViewer(print);
			viewer.setVisible(true);
			// JasperExportManager.exportReportToPdfFile(print,
			// "D:/Particular/eclipse/workspace/WebBroker/Relatorio_de_Clientes.pdf");

			// JasperViewer viewer = new JasperViewer(print, false);
			// viewer.setVisible(true);
			// viewer.toFront();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void call_report_corretor(PExtratoComissao f1) throws Exception {
		try {
			List<PExtratoComissao> report = new ArrayList<PExtratoComissao>();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT nse_nm_sucursal,");
			sql.append("nse_nm_agencia,");
			sql.append("tb_pf_nome,");
			sql.append("nco_nm_segurado,");
			sql.append("nco_apol,");
			sql.append("Replace(sum(nco_comis),'.',',') as nco_comis,");
			sql.append("nome_subproduto ");
			sql.append("FROM lemara_finance.vbrokercommission ");
			sql.append("WHERE nse_nm_sucursal = ?");
			sql.append("and  nco_date_str = ? ");
			sql.append(" group by nse_nm_sucursal,nse_nm_agencia,tb_pf_nome,nco_nm_segurado,nco_apol,nome_subproduto");

			Connection conexao = (Connection) ConexaoFactory.conectar();
			PreparedStatement comando = (PreparedStatement) conexao
					.prepareStatement(sql.toString());
			comando.setString(1, f1.getTb_surcursal());
			comando.setString(2, f1.getNco_date_str());
			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				PExtratoComissao f = new PExtratoComissao();
				f.setTb_surcursal(resultado.getString("nse_nm_sucursal"));
				f.setNse_nm_agencia(resultado.getString("nse_nm_agencia"));
				f.setTb_pf_nome(resultado.getString("tb_pf_nome"));
				f.setNco_nm_segurado(resultado.getString("NCO_NM_SEGURADO"));
				f.setNco_apol(resultado.getString("nco_apol"));
				f.setNco_comis(resultado.getString("nco_comis"));
				f.setSegmento(resultado.getString("nome_subproduto"));
				report.add(f);
			}
			
			comando.close();
			
			StringBuilder sql1 = new StringBuilder();
			sql1.append("SELECT nco_date_str,");
			sql1.append("Replace(sum(nco_comis),'.',',') as nco_comis ");
			sql1.append("FROM lemara_finance.vbrokercommission ");
			sql1.append("WHERE nse_nm_sucursal = ?");
			sql1.append("and  nco_date_str = ? ");
			sql1.append("group by nco_date_str");

			PreparedStatement comando1 = (PreparedStatement) conexao
					.prepareStatement(sql1.toString());
			comando1.setString(1, f1.getTb_surcursal());
			comando1.setString(2, f1.getNco_date_str());
			
			ResultSet resultado1 = comando1.executeQuery();
			HashMap<String, Object> parameters = null;
			while (resultado1.next()) {
				parameters = new HashMap<String, Object>();
				parameters.put("data_move",
						resultado1.getString("nco_date_str"));
				parameters.put("sum_nco_comis",
						resultado1.getString("nco_comis"));
			}

			
			comando1.close();
			conexao.close();

			

			this.path = this.getClass().getClassLoader().getResource("")
					.getPath();
			this.pathToReportPackage = this.path
					+ "br/com/WebBroker/Relatorio/";
			JasperReport inputStream = JasperCompileManager.compileReport(this
					.getPathToReportPackage() + "ExtratoCorretor.jrxml");

			JasperPrint print = JasperFillManager.fillReport(inputStream,
					parameters, new JRBeanCollectionDataSource(report));

			JasperPrintManager.printReport(print, true);


			JRViewer viewer = new JRViewer(print);
//			JFrame frameRelatorio = new JFrame("Extrato do Corretor");
//			frameRelatorio.add(viewer, BorderLayout.CENTER);
//			frameRelatorio.setSize(500, 500);
//			frameRelatorio.setExtendedState(JFrame.MAXIMIZED_BOTH);
//			frameRelatorio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//			frameRelatorio.setVisible(true);

			viewer.setVisible(true);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}

	public String getPath() {
		return this.path;
	}

}