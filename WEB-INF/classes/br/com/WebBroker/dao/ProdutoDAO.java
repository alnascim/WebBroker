package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Produto;
import br.com.WebBroker.factory.ConexaoFactory;

public class ProdutoDAO {
	public ArrayList<Produto> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		/* SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); */

		sql.append("SELECT ");
		sql.append(" a.idsub, ");
		sql.append(" concat(a.nco_cia,' - ',a.tb_subsegmento) as tb_subsegmento, ");
		sql.append(" a.tb_idpj, ");
		sql.append(" b.tb_razao, ");
		sql.append(" a.nco_cia ");
		
		sql.append(" from tb_subsegmento a ");
		sql.append(" inner join tb_cliente_PJ b on b.tb_idpj=a.tb_idpj ");
		sql.append(" and b.del_logica='N' ");
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Produto> lista = new ArrayList<Produto>();

		while (resultado.next()) {

			Produto f = new Produto();
			f.setIdsub(resultado.getLong("idsub"));
			f.setTb_subsegmento(resultado.getString("tb_subsegmento"));
			f.setTb_idpj(resultado.getInt("tb_idpj"));
			f.setTb_razao(resultado.getString("tb_razao"));
			f.setNco_cia(resultado.getInt("nco_cia"));

			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}
	public void salvar(Produto f) throws SQLException {

		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_subsegmento ");
		sql.append("(tb_subsegmento,tb_idpj,nco_cia) values (?,?,?) ");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
 
		comando.setString(1, f.getTb_subsegmento());
		comando.setLong(2, f.getCongenere_combo().getTb_idpj());
		comando.setInt(3, f.getNco_cia());
		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

	public void editar(Produto f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tb_subsegmento SET tb_subsegmento = ? WHERE idsub = ?");

		Connection conexao = ConexaoFactory.conectar();

		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar()
				.prepareStatement(sql.toString());

		comando.setString(1, f.getTb_subsegmento());

		comando.executeUpdate();
		comando.close();
		conexao.close();

	}
	public void excluir(Produto f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tb_subsegmento WHERE idsub = ? ");

		Connection conexao = ConexaoFactory.conectar();

		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar()
				.prepareStatement(sql.toString());

		comando.setLong(1, f.getIdsub());

		comando.executeUpdate();
		comando.close();
		conexao.close();


	}

}
