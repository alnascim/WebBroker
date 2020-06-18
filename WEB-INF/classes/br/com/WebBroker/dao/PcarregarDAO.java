package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Statement;

import br.com.WebBroker.domain.Pcarregar;
import br.com.WebBroker.factory.ConexaoFactory;

public class PcarregarDAO {
	public ArrayList<Pcarregar> BanckAccountFiles() throws SQLException {
		StringBuilder sql = new StringBuilder(); 

		sql.append("SELECT distinct ");
		sql.append("NomeArq, ");
		sql.append("DataImport  ");
		sql.append("from lemara_finance.tb_BanckAccountFiles ORDER BY id desc");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();
		ArrayList<Pcarregar> lista = new ArrayList<Pcarregar>();

		while (resultado.next()) {

			Pcarregar f = new Pcarregar();
			f.setNomearq(resultado.getString("NomeArq"));
			f.setDataimport(resultado.getString("DataImport"));
			f.setD_dataimport(resultado.getDate("DataImport"));
			lista.add(f);
		}
		comando.close();
		conexao.close();
		return lista;
	}
	public ArrayList<Pcarregar> listar() throws SQLException {
		StringBuilder sql = new StringBuilder(); 

		sql.append("SELECT distinct ");
		sql.append("NomeArq, ");
		sql.append("DataImport,nco_cia ");
		sql.append(" from TB_FatProcessados where tb_flag_carga_full = 1 ORDER BY id desc");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();
		ArrayList<Pcarregar> lista = new ArrayList<Pcarregar>();
		while (resultado.next()) {
			Pcarregar f = new Pcarregar();
			f.setNomearq(resultado.getString("NomeArq"));
			f.setDataimport(resultado.getString("DataImport"));
			f.setD_dataimport(resultado.getDate("DataImport"));
			f.setNco_cia(resultado.getInt("nco_cia"));
			lista.add(f);
		}
		comando.close();
		conexao.close();


		return lista;
	}
	public void importDataFull(String filename) throws SQLException {
		Statement stmt;
		String query;

		Connection conexao = ConexaoFactory.conectar();
		
		try {
			stmt = (Statement) conexao
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

			query = "LOAD DATA INFILE '" + filename
					+ "'  INTO TABLE extrato_cargafull(c_linha)";
		 
			stmt.executeUpdate(query);
			
			stmt.close();
			conexao.close();


		} catch (Exception e) {
			e.printStackTrace();
			stmt = null;
		}
	}
	public void importBankAccount(String filename) throws SQLException {
		Statement stmt;
		String query;

		Connection conexao = ConexaoFactory.conectar();
		
		try {
			stmt = (Statement) conexao
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

			query = "LOAD DATA INFILE '" + filename
					+ "'  INTO TABLE lemara_finance.tb_importbankaccount(c_linha)";
		 
			stmt.executeUpdate(query);
			
			stmt.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
			stmt = null;
		}
	}	
	public void importData(String filename) throws SQLException {
		Statement stmt;
		String query;

		Connection conexao = ConexaoFactory.conectar();
		
		try {
			stmt = (Statement) conexao
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

			query = "LOAD DATA INFILE '" + filename
					+ "'  INTO TABLE TB_IMPORTFATURAMENTO(c_linha)";
		 
			stmt.executeUpdate(query);
			
			stmt.close();
			conexao.close();


		} catch (Exception e) {
			e.printStackTrace();
			stmt = null;
		}
	}
	public void salvarBankData(String filename) throws SQLException {

		Connection conexao = ConexaoFactory.conectar();
		
//		CallableStatement remove = (CallableStatement) conexao.prepareCall("{call lemara_finance.sp_removeBankData()}");
//		remove.execute();
		
		CallableStatement cs = (CallableStatement) conexao.prepareCall("{call lemara_finance.sp_loadBankData(?)}");
		cs.setString("sfilename", filename);
		cs.execute();
		
 
		conexao.close();
	}
	public void salvar(String filename) throws SQLException {

		Connection conexao = ConexaoFactory.conectar();

		CallableStatement cs = (CallableStatement) conexao.prepareCall("{call sp_loadFaturamento(?)}");
		cs.setString("sfilename", filename);
		cs.execute();
		
 
		conexao.close();
	}
	public void salvarFull(String filename) throws SQLException {

		Connection conexao = ConexaoFactory.conectar();

		CallableStatement cs = (CallableStatement) conexao.prepareCall("{call sp_cargafull(?)}");
		cs.setString("sfilename", filename);
		cs.execute();
		
		conexao.close();
	}
}
