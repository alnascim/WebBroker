package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.com.WebBroker.domain.PGrade;
import br.com.WebBroker.factory.ConexaoFactory;

import java.math.BigDecimal;

public class PGradeDAO {
	
	public ArrayList<PGrade> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
 		
		sql.append("SELECT g.id_grade,");
		sql.append(" g.id_angariador,");
		sql.append(" g.id_segmento,");
		sql.append(" g.id_parcela,");
		sql.append(" g.tb_perccomis,");
		sql.append(" g.flag_clt,");
		sql.append(" g.tb_bonus_comis,");
		sql.append(" concat(a.nco_cia,' - ',b.tb_razao ,' - ',a.tb_subsegmento,' Ramo - ',seg.tb_sigla) as segmento,");
		sql.append(" pf.tb_pf_nome,");
		sql.append(" seg.tb_segmento");
		sql.append(" FROM lemara_schema.tb_gradecomis g");
		sql.append(" inner join tb_pessoafisica pf");
		sql.append(" on (pf.idtb_pessoafisica = g.id_angariador and pf.id_tipo_pf=4)");
		sql.append(" inner join tb_segmento seg");
		sql.append(" on (seg.id = g.id_segmento)");
		sql.append(" inner join tb_subsegmento a on a.idsub = seg.id_subsegmento ");
		sql.append(" inner join tb_cliente_PJ b on b.tb_idpj=a.tb_idpj ");
		sql.append(" where b.del_logica='N' ");
		sql.append(" order by pf.tb_pf_nome,seg.tb_segmento,g.id_parcela");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();
		
		ArrayList<PGrade> lista = new ArrayList<PGrade>();

		while (resultado.next()) {
			
			PGrade f = new PGrade();
			f.setId_grade(resultado.getLong("id_grade"));
			f.setId_angariador(resultado.getLong("id_angariador"));			
			f.setId_segmento(resultado.getLong("id_segmento"));			
			f.setId_parcela(resultado.getLong("id_parcela"));			
			f.setTb_perccomis(resultado.getDouble("tb_perccomis"));
			f.setTb_flag_clt(resultado.getString("flag_clt"));
			f.setTb_nome(resultado.getString("tb_pf_nome"));
			f.setTb_segmento(resultado.getString("segmento"));
						
			lista.add(f);
		}
		comando.close();
		conexao.close();

		return lista;
	}	
	
	public void editar(PGrade f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tb_gradecomis SET tb_perccomis = ? ");
		sql.append(" WHERE id_grade = ? ");
		sql.append(" AND id_angariador = ? ");
		sql.append(" AND id_segmento = ? ");
		sql.append(" AND id_parcela = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());	
		
		BigDecimal perc= new BigDecimal(f.getTb_perccomis());
		comando.setBigDecimal(1, perc);
		comando.setLong(2, f.getId_grade());
		comando.setLong(3, f.getId_angariador());
		comando.setLong(4, f.getId_segmento());
		comando.setLong(5, f.getId_parcela());

		comando.executeUpdate();		
		comando.close();
		conexao.close();

		}

	public void excluir(PGrade f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tb_gradecomis ");
		sql.append(" WHERE id_grade = ? ");
		sql.append(" AND id_angariador = ? ");
		sql.append(" AND id_segmento = ? ");
		sql.append(" AND id_parcela = ? ");
		
		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar()
				.prepareStatement(sql.toString());
 
		
		comando.setLong(1, f.getId_grade());
		comando.setLong(2, f.getId_angariador());
		comando.setLong(3, f.getId_segmento());
		comando.setLong(4, f.getId_parcela());
		
		comando.executeUpdate();
		comando.close();
 

	}

	public void salvar(PGrade f) throws SQLException {
		StringBuilder sql = new StringBuilder();
				
		sql.append("INSERT INTO tb_gradecomis (");
		sql.append("id_angariador,");
		sql.append("id_segmento,");
		sql.append("id_parcela,");
		sql.append("tb_perccomis, ");
		sql.append("insert_date ");
		sql.append(") VALUES (?,?,?,?,?) ");		
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
 		
		comando.setLong(1, f.getAngariador_combo().getIdtb_pessoafisica());
		comando.setLong(2, f.getSegmento_combo().getId());
		comando.setLong(3, f.getId_parcela());
		
		BigDecimal perc= new BigDecimal(f.getTb_perccomis());
		comando.setBigDecimal(4, perc);		

		Date utilDate = null;
		try {
			utilDate = new Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			comando.setDate(5, sqlDate);
		} catch (Exception e) {

			comando.setDate(5, null);
		}		
		
		comando.executeUpdate();
		comando.close();
		conexao.close();


	}
	
	

}
