package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Pagadores;
import br.com.WebBroker.factory.ConexaoFactory;

public class PagadoresDAO {
	
	public ArrayList<Pagadores> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		/*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");*/			
		
		sql.append("SELECT ");
		sql.append("a.id, ");
		sql.append("a.account_name, ");
		sql.append("a.t_agenc, ");
		sql.append("concat(a.t_account_number,'-',a.t_account_digit) as t_account_number, ");		
		sql.append("b.banco ");
		sql.append("from lemara_finance.tb_account_payer a " );
		sql.append("inner join lemara_finance.tb_bancos b on b.cod = a.id_bank " );

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Pagadores> lista = new ArrayList<Pagadores>();

		while (resultado.next()) {
			
			Pagadores f = new Pagadores();
			f.setId(resultado.getInt("id"));
			f.setAccount_name(resultado.getString("account_name"));
			f.setT_agenc(resultado.getString("t_agenc"));
			f.setT_account_number(resultado.getString("t_account_number"));
			f.setBank(resultado.getString("banco"));

			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}
	
	
	public void salvar(Pagadores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO lemara_finance.tb_account_payer ( ");
		sql.append("account_name, ");
		sql.append("t_agenc,");
		sql.append("t_account_number,");
		sql.append("t_account_digit, ");
		sql.append("id_bank ");
		sql.append(" ) VALUES (?,?,?,?,?) ");
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, f.getAccount_name());
		comando.setString(2,f.getT_agenc());
		comando.setString(3, f.getT_account_number());
		comando.setString(4, f.getT_account_digit());
		comando.setInt(5, f.getBanco_combo().getId());
		comando.executeUpdate();
		comando.close();
		conexao.close();


	}
	public void excluir(Pagadores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM lemara_finance.tb_account_payer WHERE id = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setInt(1, f.getId());

		comando.executeUpdate();
		comando.close();
		conexao.close();


	}
	
}
