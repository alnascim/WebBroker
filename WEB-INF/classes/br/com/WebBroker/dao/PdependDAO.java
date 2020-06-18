package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import br.com.WebBroker.domain.Pdepend;
import br.com.WebBroker.domain.Pfisica;
import br.com.WebBroker.factory.ConexaoFactory;

public class PdependDAO {

	public ArrayList<Pdepend> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		/* SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); */

		sql.append("SELECT ");
		sql.append("d.idtb_dependente, ");
		sql.append("d.idtb_pessoafisica, ");
		sql.append("d.tb_pf_nome, ");
		sql.append("t.tb_pf_nome as tb_pf_nome_t, ");
		sql.append("d.tb_pf_datanasc, ");
		sql.append("d.tb_pf_cpf, ");
		sql.append("d.tb_pf_nro_docto,");
		sql.append("d.tb_num_carteira,");
		sql.append("d.tb_pf_email ");
		sql.append("From tb_dependente d ");
		sql.append("join tb_pessoafisica t on (d.idtb_pessoafisica = t.idtb_pessoafisica) ORDER BY t.tb_pf_nome");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Pdepend> lista = new ArrayList<Pdepend>();

		while (resultado.next()) {

			Pdepend f = new Pdepend();
			f.setIdtb_pessoafisica(resultado.getLong("idtb_pessoafisica"));
			f.setIdtb_dependente(resultado.getLong("idtb_dependente"));
			f.setTb_pf_nome(resultado.getString("tb_pf_nome"));
			f.setTb_pf_nome_t(resultado.getString("tb_pf_nome_t"));
			f.setTb_pf_datanasc(resultado.getString("tb_pf_datanasc"));
			f.setTb_pf_cpf(resultado.getString("tb_pf_cpf"));
			f.setTb_pf_nro_docto(resultado.getString("tb_pf_nro_docto"));
			f.setPf_datanasc(resultado.getDate("tb_pf_datanasc"));
			f.setTb_num_carteira(resultado.getString("tb_num_carteira"));
			f.setTb_pf_email(resultado.getString("tb_pf_email"));
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}

	public void editar(Pdepend f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tb_dependente SET ");
		sql.append(" tb_pf_datanasc = ? ,");
		sql.append(" tb_pf_nro_docto = ?, ");
		sql.append(" tb_num_carteira = ?, ");
		sql.append(" tb_pf_email = ? ");
		sql.append(" WHERE idtb_dependente = ? and id_tipo_pf = 3");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		/* Set date */
		Date utilDate = null;
		try {
			utilDate = f.getPf_datanasc();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			comando.setDate(1, sqlDate);
		} catch (Exception e) {

			comando.setDate(1, null);
		}
		/* Set date */

		comando.setString(2, f.getTb_pf_nro_docto());
		comando.setString(3, f.getTb_num_carteira());
		comando.setString(4, f.getTb_pf_email());
		comando.setLong(5, f.getIdtb_dependente());
		comando.executeUpdate();
		comando.close();
		conexao.close();

	}
	public void excluir(Pdepend f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tb_dependente WHERE idtb_pessoafisica = ? and  idtb_dependente = ? and id_tipo_pf = 3");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setLong(1, f.getIdtb_pessoafisica());
		comando.setLong(2, f.getIdtb_dependente());

		comando.executeUpdate();
		comando.close();
		conexao.close();

	}
	public void salvar(Pdepend f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_dependente (");
		sql.append("tb_pf_nome,");
		sql.append("idtb_pessoafisica,");
		sql.append("tb_pf_datanasc,");
		sql.append("tb_pf_cpf,");
		sql.append("tb_pf_nro_docto,");
		sql.append("tb_pf_sexo,");
		sql.append("tb_pf_RIC,");
		sql.append("tb_pf_cartao_saude,");
		sql.append("tb_pf_nascido_vivo,");
		sql.append("tb_pf_matricula_func,");
		sql.append("tb_pf_PISPASEP,");
		sql.append("tb_pf_data_adm,");
		sql.append("tb_num_carteira,");
		sql.append("tb_pf_email,");
		sql.append("insert_date,");
		sql.append("id_tipo_pf ");

		sql.append(") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,3) ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		/* Set date */
		Date utilDate = null;
		try {
			utilDate = f.getPf_datanasc();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			comando.setDate(3, sqlDate);
		} catch (Exception e) {

			comando.setDate(3, null);
		}

		Date utilDate1 = null;
		try {
			utilDate1 = f.getPf_data_adm();
			java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
			comando.setDate(12, sqlDate1);
		} catch (Exception e) {

			comando.setDate(12, null);
		}

		comando.setString(1, f.getTb_pf_nome());
		comando.setLong(2, f.getTitular_combo().getIdtb_pessoafisica());
		comando.setString(4, f.getTb_pf_cpf());
		comando.setString(5, f.getTb_pf_nro_docto());
		comando.setString(6, f.getTb_pf_sexo());
		comando.setString(7, f.getTb_pf_RIC());
		comando.setString(8, f.getTb_pf_cartao_saude());
		comando.setString(9, f.getTb_pf_nascido_vivo());
		comando.setString(10, f.getTb_pf_matricula_func());
		comando.setString(11, f.getTb_pf_PISPASEP());
		comando.setString(13, f.getTb_num_carteira());
		
		comando.setString(14, f.getTb_pf_email());
		Date utilDaten = null;
		try {
			utilDaten = new Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDaten.getTime());
			comando.setDate(15, sqlDate);
		} catch (Exception e) {

			comando.setDate(15, null);
		}		
		comando.executeUpdate();
		comando.close();
		conexao.close();


	}
	public void salvar_d(Pdepend f) throws SQLException {
		StringBuilder sql = new StringBuilder();
 	
		sql.append("INSERT INTO tb_dependente (");
		sql.append("tb_pf_nome,");
		sql.append("idtb_pessoafisica,");
		sql.append("tb_pf_datanasc,");
		sql.append("tb_pf_cpf,");
		sql.append("tb_pf_nro_docto,");
		sql.append("tb_pf_sexo,");
		sql.append("tb_pf_RIC,");
		sql.append("tb_pf_cartao_saude,");
		sql.append("tb_pf_nascido_vivo,");
		sql.append("tb_pf_matricula_func,");
		sql.append("tb_pf_PISPASEP,");
		sql.append("tb_pf_data_adm,");
		sql.append("tb_num_carteira,");
		sql.append("tb_pf_email,");
		sql.append("insert_date,");
		sql.append("id_tipo_pf");
		
		sql.append(") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,3) ");
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getTb_pf_nome());
		comando.setLong(2, f.getIdtb_pessoafisica());
		/* Set date */
		Date utilDate = null;
		try {
			utilDate = f.getPf_datanasc();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			comando.setDate(3, sqlDate);
		} catch (Exception e) {

			comando.setDate(3, null);
		}

		comando.setString(4, f.getTb_pf_cpf());
		comando.setString(5, f.getTb_pf_nro_docto());
		comando.setString(6, f.getTb_pf_sexo());
		comando.setString(7, f.getTb_pf_RIC());
		comando.setString(8, f.getTb_pf_cartao_saude());
		comando.setString(9, f.getTb_pf_nascido_vivo());
		comando.setString(10, f.getTb_pf_matricula_func());
		comando.setString(11, f.getTb_pf_PISPASEP());
		Date utilDate1 = null;
		try {
			utilDate1 = f.getPf_data_adm();
			java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
			comando.setDate(12, sqlDate1);
		} catch (Exception e) {

			comando.setDate(12, null);
		}		
		
		comando.setString(13, f.getTb_num_carteira());
		comando.setString(14, f.getTb_pf_email());
		Date utilDaten = null;
		try {
			utilDaten = new Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDaten.getTime());
			comando.setDate(15, sqlDate);
		} catch (Exception e) {

			comando.setDate(15, null);
		}				
		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

	public void salvar_1(Pdepend f) throws SQLException {

		Pfisica ff = new Pfisica();

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_dependente (");
		sql.append("tb_pf_nome,");
		sql.append("idtb_pessoafisica,");
		sql.append("tb_pf_datanasc,");
		sql.append("tb_pf_cpf,");
		sql.append("tb_pf_nro_docto,");
		sql.append("tb_pf_sexo,");
		sql.append("tb_pf_RIC,");
		sql.append("tb_pf_cartao_saude,");
		sql.append("tb_pf_nascido_vivo,");
		sql.append("tb_pf_matricula_func,");
		sql.append("tb_pf_PISPASEP,");
		sql.append("tb_pf_data_adm,");
		sql.append("tb_num_carteira,");
		sql.append("tb_pf_email,");
		sql.append("id_tipo_pf ");
		sql.append(") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,3) ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		/* Set date */
		Date utilDate = null;
		try {
			utilDate = f.getPf_datanasc();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			comando.setDate(3, sqlDate);
		} catch (Exception e) {

			comando.setDate(3, null);
		}

		Date utilDate1 = null;
		try {
			utilDate1 = f.getPf_data_adm();
			java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
			comando.setDate(12, sqlDate1);
		} catch (Exception e) {

			comando.setDate(12, null);
		}

		comando.setString(1, f.getTb_pf_nome());
		comando.setLong(2, ff.getIdtb_pessoafisica());
		comando.setString(4, f.getTb_pf_cpf());
		comando.setString(5, f.getTb_pf_nro_docto());
		comando.setString(6, f.getTb_pf_sexo());
		comando.setString(7, f.getTb_pf_RIC());
		comando.setString(8, f.getTb_pf_cartao_saude());
		comando.setString(9, f.getTb_pf_nascido_vivo());
		comando.setString(10, f.getTb_pf_matricula_func());
		comando.setString(11, f.getTb_pf_PISPASEP());
		comando.setString(13, f.getTb_num_carteira());
		comando.setString(14, f.getTb_pf_email());
		comando.executeUpdate();
		comando.close();
		conexao.close();


	}

}
