package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Produto;
import br.com.WebBroker.domain.Segmento;
import br.com.WebBroker.factory.ConexaoFactory;

public class SegmentoDAO {
	private Integer inco_cia;
	private Integer nco_ramo;

	public ArrayList<Produto> listarproduto() throws SQLException {
		StringBuilder sql = new StringBuilder();
		/* SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); */

		sql.append("SELECT ");
		sql.append(" c.idsub, ");
		sql.append(" c.tb_idpj, ");
		sql.append(" concat(c.nco_cia,' - ',b.tb_razao ,' - ',c.tb_subsegmento) as tb_subsegmento,");
		sql.append(" c.nco_cia ");
		sql.append(" from tb_subsegmento c ");
		sql.append(" inner join tb_cliente_PJ b on c.tb_idpj=b.tb_idpj ");
		sql.append(" where b.del_logica='N' ");
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Produto> lista = new ArrayList<Produto>();

		while (resultado.next()) {

			Produto f = new Produto();
			f.setIdsub(resultado.getLong("idsub"));
			f.setTb_subsegmento(resultado.getString("tb_subsegmento"));
			f.setTb_idpj(resultado.getInt("tb_idpj"));
			f.setNco_cia(resultado.getInt("nco_cia"));
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}

	public ArrayList<Segmento> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		/* SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); */

		sql.append("SELECT ");
		sql.append(" a.id, ");
		sql.append(" a.tb_segmento, ");
		sql.append(" a.id_subsegmento, a.nco_cia,");
		sql.append(" concat(a.nco_cia,a.nco_ramo,a.id_subsegmento) as event_code,");
		sql.append(" a.tb_sigla, ");
		sql.append(" concat(a.nco_cia,' - ',b.tb_razao ,' - ',c.tb_subsegmento) as tb_razao,");
		sql.append(" concat(b.tb_razao ,' - ',a.tb_segmento) as segmento");

		sql.append(" from tb_segmento a ");
		sql.append(" inner join tb_subsegmento c on a.id_subsegmento = c.idsub ");
		sql.append(" inner join tb_cliente_PJ b on c.tb_idpj=b.tb_idpj ");

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
			f.setEvent_code(resultado.getString("event_code"));
			f.setId_subsegmento(resultado.getInt("id_subsegmento"));
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}

	public void salvar(Segmento f) throws SQLException {
		Connection conexao = ConexaoFactory.conectar();
		nco_ramo = Integer.parseInt(f.getTb_sigla());

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_segmento ");
		sql.append("(tb_segmento,tb_sigla,nco_cia,id_subsegmento,nco_ramo) values (?,?,?,?,?) ");
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getTb_segmento());
		comando.setString(2, f.getTb_sigla());
		comando.setInt(3, f.getNco_cia());
		comando.setLong(4, f.getProduto_combo().getIdsub());
		comando.setInt(5, nco_ramo);

		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

	public void editar(Segmento f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tb_segmento SET tb_segmento = ?,tb_sigla= ?,nco_cia=? WHERE id = ?");

		Connection conexao = ConexaoFactory.conectar();

		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar().prepareStatement(
				sql.toString());

		comando.setString(1, f.getTb_segmento());
		comando.setString(2, f.getTb_sigla());
		comando.setInt(3, f.getNco_cia());
		comando.setLong(4, f.getId());

		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

	public void excluir(Segmento f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tb_segmento WHERE id = ? ");

		Connection conexao = ConexaoFactory.conectar();

		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar().prepareStatement(
				sql.toString());

		comando.setLong(1, f.getId());

		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

}
