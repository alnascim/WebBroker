package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import br.com.WebBroker.domain.ContasPagar;
import br.com.WebBroker.domain.ExtratoBancario;
import br.com.WebBroker.factory.ConexaoFactory;

public class ExtratoBancarioDAO {

	
	public ArrayList<ExtratoBancario> listar_extrato(ExtratoBancario fp) throws SQLException  {
		StringBuilder sql = new StringBuilder();
		/* SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); */

		sql.append("SELECT ");
		sql.append("id,");
		sql.append("c_data,");
		sql.append("c_lancto,");
		sql.append("c_docto, ");
		sql.append("format(trim(ltrim(replace(replace(c_debito,'.',''),',','.'))),2,'de_DE') as c_debito,");
		sql.append("format(trim(ltrim(replace(replace(c_credito,'.',''),',','.'))),2,'de_DE') as c_credito ");
		sql.append("from lemara_finance.tb_banckaccount_movement ");
		sql.append(" WHERE DATE_FORMAT(D_DATE, '%Y-%m-%d') between ? and ? ");
		
	 
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
		ArrayList<ExtratoBancario> lista = new ArrayList<ExtratoBancario>();
		while (resultado.next()) {

			ExtratoBancario f = new ExtratoBancario();
			f.setId(resultado.getInt("id"));
			f.setC_data(resultado.getString("c_data"));
			f.setC_lancto(resultado.getString("c_lancto"));
			f.setC_docto(resultado.getString("c_docto"));
			f.setC_debito(resultado.getString("c_debito"));
			f.setC_credito(resultado.getString("c_credito"));
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
		
	}

	
	public ArrayList<ExtratoBancario> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		/* SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); */

		sql.append("SELECT ");
		sql.append("id,");
		sql.append("c_data,");
		sql.append("c_lancto,");
		sql.append("c_docto, ");
		sql.append("format(trim(ltrim(replace(replace(c_debito,'.',''),',','.'))),2,'de_DE') as c_debito,");
		sql.append("format(trim(ltrim(replace(replace(c_credito,'.',''),',','.'))),2,'de_DE') as c_credito ");
		sql.append("from lemara_finance.tb_banckaccount_movement");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();
		ArrayList<ExtratoBancario> lista = new ArrayList<ExtratoBancario>();
		while (resultado.next()) {

			ExtratoBancario f = new ExtratoBancario();
			f.setId(resultado.getInt("id"));
			f.setC_data(resultado.getString("c_data"));
			f.setC_lancto(resultado.getString("c_lancto"));
			f.setC_docto(resultado.getString("c_docto"));
			f.setC_debito(resultado.getString("c_debito"));
			f.setC_credito(resultado.getString("c_credito"));
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}

	public ArrayList<ExtratoBancario> listar_resumo() throws SQLException {
		StringBuilder sql = new StringBuilder();
		/* SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); */

		sql.append("SELECT ");
		sql.append("D_DATE as c_data,");
		sql.append("format(trim(ltrim(replace(replace(c_credito,'.',''),',','.'))),2,'de_DE') as c_credito ");
		sql.append("from lemara_finance.tb_banckaccount_movement ");
		sql.append("group by c_data");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();
		ArrayList<ExtratoBancario> lista = new ArrayList<ExtratoBancario>();
		while (resultado.next()) {

			ExtratoBancario f = new ExtratoBancario();
			f.setC_data(resultado.getString("c_data"));
			f.setC_credito(resultado.getString("c_credito"));
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}

	public ArrayList<ExtratoBancario> listar_resumo_data() throws SQLException {
		StringBuilder sql = new StringBuilder();
		/* SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); */

		sql.append("SELECT ");
		sql.append("D_DATE as c_data,");
		sql.append("format(trim(ltrim(replace(replace(c_credito,'.',''),',','.'))),2,'de_DE') as c_credito ");
		sql.append("from lemara_finance.tb_banckaccount_movement ");
		sql.append("WHERE DATE_FORMAT(D_DATE, '%Y-%m-%d') = DATE_ADD(date(now()), INTERVAL 1 day) ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();
		ArrayList<ExtratoBancario> lista = new ArrayList<ExtratoBancario>();
		while (resultado.next()) {

			ExtratoBancario f = new ExtratoBancario();
			f.setC_data(resultado.getString("c_data"));
			f.setC_credito(resultado.getString("c_credito"));
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}

	public ArrayList<ExtratoBancario> listar_resumo_filtro(ExtratoBancario fp)
			throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("D_DATE as c_data,");
		sql.append("format(trim(ltrim(replace(replace(c_credito,'.',''),',','.'))),2,'de_DE') as c_credito ");
		sql.append("from lemara_finance.tb_banckaccount_movement ");
		sql.append("WHERE DATE_FORMAT(D_DATE, '%Y-%m-%d') between ? and ? ");

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
		ArrayList<ExtratoBancario> lista = new ArrayList<ExtratoBancario>();
		while (resultado.next()) {

			ExtratoBancario f = new ExtratoBancario();
			f.setC_data(resultado.getString("c_data"));
			f.setC_credito(resultado.getString("c_credito"));
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;

	}

	public ArrayList<ExtratoBancario> encontrar_conta(ContasPagar fp)
			throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("D_DATE as c_data,");
		sql.append("format(trim(ltrim(replace(replace(c_debito,'.',''),',','.'))),2,'de_DE') as c_debito ");
		sql.append("from lemara_finance.tb_banckaccount_movement ");
		sql.append("WHERE c_debito = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, '-'+fp.getAmount());

		ResultSet resultado = comando.executeQuery();
		ArrayList<ExtratoBancario> lista = new ArrayList<ExtratoBancario>();
		while (resultado.next()) {

			ExtratoBancario f = new ExtratoBancario();

			f.setD_data(resultado.getDate("c_data"));
			f.setC_data(resultado.getString("c_data"));
			f.setC_debito(resultado.getString("c_debito"));
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;

	}
}
