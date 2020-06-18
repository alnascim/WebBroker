package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.WebBroker.domain.Pdepend;
import br.com.WebBroker.domain.Pfisica;
import br.com.WebBroker.factory.ConexaoFactory;

public class PCliente_pfDAO {
	
	public void verifypf(Pfisica f,Pdepend d) throws SQLException {
		Long iddp=f.getIdtb_pessoafisica();

		d.setIdtb_pessoafisica(iddp);
		
	}
	public void verifycpf(Pfisica f) throws SQLException {
		FacesContext context = FacesContext.getCurrentInstance();
		Connection conexao = ConexaoFactory.conectar();
 
 		StringBuilder sql = new StringBuilder();
		String sCPF =  f.getTb_pf_cpf();
		sql.append("SELECT tb_pf_cpf from v_verifycliente_pf where tb_pf_cpf = ?");
 

		
		try {
 
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());
			comando.setString(1, sCPF);

			ResultSet resultado = comando.executeQuery();
		 
			if (resultado.next()) {
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "CPF Já Cadastrado ! [ "
								+ sCPF + "]", ""));
			} else {
				
				if(sCPF == null && "".equals(sCPF)){
					sCPF="";
				}
				
				else {

					context.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "CPF Não Cadastrado ! [ "
									+ sCPF + "]", ""));
					}
				
				
			}

		} catch (SQLException e) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Erro ao localizar registro. Mensagem: " + e.getMessage(),
					""));

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

	}

	public void localizar(Pfisica f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		FacesContext context = FacesContext.getCurrentInstance();
		Connection conexao = ConexaoFactory.conectar();

		sql.append("SELECT d.CITY,d.DISTRICT,d.STREET_ZIPCODE,d.STREET_NAME,t.street_types as 	STREET_TYPE,x.state_name as state  FROM T_CTS_INT_ZIPCODE_DATA d");

		sql.append(" inner join t_cts_streettype t");
		sql.append(" on (t.id = d.street_type)");

		sql.append(" inner join t_state x");
		sql.append(" on (x.state_id = d.state)");

		sql.append(" where STREET_ZIPCODE = ?");

		try {
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());
			comando.setString(1, f.getSTREET_ZIPCODE());

			ResultSet resultado = comando.executeQuery();

			if (resultado.next()) {
				f.setSTREET_NAME(resultado.getString("STREET_NAME"));
				f.setCITY(resultado.getString("CITY"));
				f.setDISTRICT(resultado.getString("DISTRICT"));
				f.setSTREET_ZIPCODE(resultado.getString("STREET_ZIPCODE"));
				f.setSTATE(resultado.getString("state"));
				f.setSTREET_TYPE(resultado.getString("STREET_TYPE"));
			} else {
				context.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"CEP   Inexistente" + f.getSTREET_ZIPCODE(), ""));

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

	}

	public ArrayList<Pfisica> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		String pattern = "dd-mm-yyyy";
		SimpleDateFormat f_datanasc = new SimpleDateFormat(pattern);
		// SimpleDateFormat f_ini_vig = new SimpleDateFormat(pattern);
		// SimpleDateFormat f_data_adm = new SimpleDateFormat(pattern);
		// SimpleDateFormat f_DataExped = new SimpleDateFormat(pattern);

		sql.append("SELECT ");
		sql.append("a.idtb_pessoafisica,");
		sql.append("a.tb_pf_nome,");
		sql.append("a.tb_pf_sexo,");
		sql.append("a.tb_pf_datanasc,");
		sql.append("a.tb_pf_cpf,");
		sql.append("a.tb_pf_nome_mae,");
		sql.append("a.tb_dt_ini_vig,");
		sql.append("a.tb_pf_RIC,");
		sql.append("a.tb_pf_cartao_saude,");
		sql.append("a.tb_pf_nascido_vivo,");
		sql.append("a.tb_pf_matricula_func,");
		sql.append("a.tb_pf_data_adm,");
		sql.append("a.tb_pf_nro_docto,");
		sql.append("a.tb_pf_orgao_exp,");
		sql.append("a.tb_pf_DataExped,");
		sql.append("a.tb_pf_ddd01,");
		sql.append("a.tb_pf_fone01,");
		sql.append("a.tb_pf_ddd02,");
		sql.append("a.tb_pf_fone02,");
		sql.append("a.tb_pf_CEP,");
		sql.append("a.tb_pf_PISPASEP,");
		sql.append("a.tb_idpj,");
		sql.append("a.id_prof,");
		sql.append("a.id_est_civ,");
		sql.append("a.id_parent,");
		sql.append("a.id_tipo_pf, ");
		sql.append("a.tb_cep_num, ");
		sql.append("a.tb_cep_compl,");
		sql.append("IFNULL(x.state_name,'Cep não localizado') as state,");
		sql.append("IFNULL(d.CITY,'Cep não localizado') as 	CITY	,");
		sql.append("IFNULL(d.DISTRICT,'Cep não localizado') as 	DISTRICT,");
		sql.append("IFNULL(t.street_types,'Cep não localizado') as 	STREET_TYPE,	");
		sql.append("IFNULL(d.STREET_NAME,'Cep não localizado') as 	STREET_NAME,");

		sql.append("tb_num_carteira, ");
		sql.append("tb_pf_email ");
		sql.append(" from tb_cliente_pf a ");

		sql.append(" left join t_cts_int_zipcode_data d");
		sql.append(" on d.STREET_ZIPCODE = a.tb_pf_CEP");

		sql.append(" left join t_cts_streettype t");
		sql.append(" on (t.id = d.street_type)");

		sql.append(" left join t_state x");
		sql.append(" on (x.state_id = d.state)");

		sql.append(" ORDER BY insert_date desc  ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Pfisica> lista = new ArrayList<Pfisica>();

		while (resultado.next()) {

			Pfisica f = new Pfisica();

			f.setIdtb_pessoafisica(resultado.getLong("idtb_pessoafisica"));
			f.setTb_pf_nome(resultado.getString("tb_pf_nome"));
			f.setTb_pf_datanasc(resultado.getString("tb_pf_datanasc"));
			f.setTb_pf_cpf(resultado.getString("tb_pf_cpf"));
			f.setTb_pf_nro_docto(resultado.getString("tb_pf_nro_docto"));
			f.setTb_pf_sexo(resultado.getString("tb_pf_sexo"));
			f.setTb_pf_nome_mae(resultado.getString("tb_pf_nome_mae"));
			f.setTb_dt_ini_vig(resultado.getString("tb_dt_ini_vig"));
			f.setTb_pf_RIC(resultado.getString("tb_pf_RIC"));
			f.setTb_pf_cartao_saude(resultado.getString("tb_pf_cartao_saude"));
			f.setTb_pf_nascido_vivo(resultado.getString("tb_pf_nascido_vivo"));
			f.setTb_pf_matricula_func(resultado
					.getString("tb_pf_matricula_func"));
			f.setTb_pf_data_adm(resultado.getString("tb_pf_data_adm"));
			f.setTb_pf_orgao_exp(resultado.getString("tb_pf_orgao_exp"));
			f.setTb_pf_DataExped(resultado.getString("tb_pf_DataExped"));
			f.setTb_pf_ddd01(resultado.getString("tb_pf_ddd01"));
			f.setTb_pf_fone01(resultado.getString("tb_pf_fone01"));
			f.setTb_pf_ddd02(resultado.getString("tb_pf_ddd02"));
			f.setTb_pf_fone02(resultado.getString("tb_pf_fone02"));
			f.setSTREET_ZIPCODE(resultado.getString("tb_pf_CEP"));
			f.setTb_pf_PISPASEP(resultado.getString("tb_pf_PISPASEP"));
			f.setTb_id_prof(resultado.getLong("id_prof"));
			f.setTb_id_est_civ(resultado.getLong("id_est_civ"));
			f.setPf_datanasc(resultado.getDate("tb_pf_datanasc"));
			f.setPf_data_adm(resultado.getDate("tb_pf_data_adm"));
			f.setPf_dt_ini_vig(resultado.getDate("tb_dt_ini_vig"));
			f.setPf_DataExped(resultado.getDate("tb_pf_DataExped"));
			f.setTb_idpj(resultado.getLong("tb_idpj"));
			f.setTb_cep_num(resultado.getLong("tb_cep_num"));
			f.setSTREET_COMP(resultado.getString("tb_cep_compl"));
			f.setTb_num_carteira(resultado.getString("tb_num_carteira"));

			f.setSTATE(resultado.getString("sTATE"));
			f.setCITY(resultado.getString("cITY"));
			f.setDISTRICT(resultado.getString("DISTRICT"));
			f.setSTREET_TYPE(resultado.getString("STREET_TYPE"));
			f.setSTREET_NAME(resultado.getString("STREET_NAME"));
			f.setSTREET_COMP(resultado.getString("tb_cep_compl"));
			f.setTb_cep_num(resultado.getLong("tb_cep_num"));
			f.setTb_pf_email(resultado.getString("tb_pf_email"));

			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}

	public void editar(Pfisica f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tb_cliente_pf SET ");
		sql.append("  tb_pf_nome = ? ");
		sql.append(" ,tb_pf_datanasc = ? ");
		sql.append(" ,tb_pf_nro_docto = ? ");
		sql.append(" ,tb_dt_ini_vig= ? ");
		sql.append(" ,tb_pf_data_adm= ? ");
		sql.append(" ,tb_pf_DataExped= ? ");
		sql.append(" ,tb_pf_cpf= ? ");
		sql.append(" ,tb_pf_sexo= ? ");
		sql.append(" ,tb_pf_nome_mae= ? ");
		sql.append(" ,tb_pf_RIC= ? ");
		sql.append(" ,tb_pf_cartao_saude= ? ");
		sql.append(" ,tb_pf_nascido_vivo= ? ");
		sql.append(" ,tb_pf_matricula_func= ? ");
		sql.append(" ,tb_pf_orgao_exp= ? ");
		sql.append(" ,tb_pf_ddd01= ? ");
		sql.append(" ,tb_pf_fone01= ? ");
		sql.append(" ,tb_pf_ddd02= ? ");
		sql.append(" ,tb_pf_fone02= ? ");
		sql.append(" ,tb_pf_CEP= ? ");
		sql.append(" ,tb_pf_PISPASEP= ? ");
		sql.append(" ,id_prof= ? ");

		sql.append(" ,tb_idpj= ? ");
		sql.append(" ,id_est_civ= ? ");

		sql.append(" ,tb_cep_num= ? ");
		sql.append(" ,tb_cep_compl= ? ");

		sql.append(" ,tb_num_carteira= ? ");

		sql.append(" ,tb_pf_email= ? ");

		sql.append(" WHERE idtb_pessoafisica = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, f.getTb_pf_nome());
		Date utilDate = null;
		try {
			utilDate = f.getPf_datanasc();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			comando.setDate(2, sqlDate);
		} catch (Exception e) {

			comando.setDate(2, null);
		}
		comando.setString(3, f.getTb_pf_nro_docto());
		try {
			utilDate = f.getPf_dt_ini_vig();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			comando.setDate(4, sqlDate);
		} catch (Exception e) {

			comando.setDate(4, null);
		}
		try {
			utilDate = f.getPf_data_adm();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			comando.setDate(5, sqlDate);
		} catch (Exception e) {

			comando.setDate(5, null);
		}
		try {
			utilDate = f.getPf_DataExped();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			comando.setDate(6, sqlDate);
		} catch (Exception e) {

			comando.setDate(6, null);
		}
		comando.setString(7, f.getTb_pf_cpf());
		comando.setString(8, f.getTb_pf_sexo());
		comando.setString(9, f.getTb_pf_nome_mae());
		comando.setString(10, f.getTb_pf_RIC());
		comando.setString(11, f.getTb_pf_cartao_saude());
		comando.setString(12, f.getTb_pf_nascido_vivo());
		comando.setString(13, f.getTb_pf_matricula_func());
		comando.setString(14, f.getTb_pf_orgao_exp());
		comando.setString(15, f.getTb_pf_ddd01());
		comando.setString(16, f.getTb_pf_fone01());
		comando.setString(17, f.getTb_pf_ddd02());
		comando.setString(18, f.getTb_pf_fone02());
		comando.setString(19, f.getSTREET_ZIPCODE());
		comando.setString(20, f.getTb_pf_PISPASEP());
		comando.setLong(21, f.getTb_id_prof());

		comando.setLong(22, f.getTb_idpj());
		comando.setLong(23, f.getTb_id_est_civ());

		comando.setLong(24, f.getTb_cep_num());
		comando.setString(25, f.getSTREET_COMP());
		comando.setString(26, f.getTb_num_carteira());
		comando.setString(27, f.getTb_pf_email());
		comando.setLong(28, f.getIdtb_pessoafisica());
		comando.executeUpdate();
		comando.close();
		conexao.close();
	}

	public void excluir(Pfisica f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tb_cliente_pf WHERE idtb_pessoafisica = ? ");
		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar().prepareStatement(
				sql.toString());

		comando.setLong(1, f.getIdtb_pessoafisica());
		comando.executeUpdate();
		comando.close();

	}

	public void salvar(Pfisica f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_cliente_pf (");
		sql.append("tb_pf_nome,");
		sql.append("tb_pf_sexo,");
		sql.append("tb_pf_datanasc, ");
		sql.append("tb_pf_cpf, ");
		sql.append("tb_pf_nome_mae, ");
		sql.append("tb_dt_ini_vig,");
		sql.append("tb_pf_RIC,");
		sql.append("tb_pf_cartao_saude,");
		sql.append("tb_pf_nascido_vivo,");
		sql.append("tb_pf_matricula_func,");
		sql.append("tb_pf_data_adm,");
		sql.append("tb_pf_nro_docto, ");
		sql.append("tb_pf_orgao_exp,");
		sql.append("tb_pf_DataExped,");
		sql.append("tb_pf_ddd01,");
		sql.append("tb_pf_fone01,");
		sql.append("tb_pf_ddd02,");
		sql.append("tb_pf_fone02,");
		sql.append("tb_pf_CEP,");
		sql.append("tb_pf_PISPASEP,");
		sql.append("tb_idpj,");
		sql.append("id_prof,");
		sql.append("id_est_civ,");
		sql.append("tb_cep_num, ");
		sql.append("tb_cep_compl,");
		sql.append("tb_num_carteira,");
		sql.append("tb_pf_email,");
		sql.append("insert_date,");
		sql.append("id_tipo_pf ");
		sql.append(") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0) ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setString(1, f.getTb_pf_nome());
		comando.setString(2, f.getTb_pf_sexo());

		Date utilDate = null;
		try {
			utilDate = f.getPf_datanasc();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			comando.setDate(3, sqlDate);
		} catch (Exception e) {

			comando.setDate(3, null);
		}
		comando.setString(4, f.getTb_pf_cpf());
		comando.setString(5, f.getTb_pf_nome_mae());

		Date utilDataIniVig = null;
		try {
			utilDataIniVig = f.getPf_dt_ini_vig();
			java.sql.Date sqlDataIniVig = new java.sql.Date(
					utilDataIniVig.getTime());
			comando.setDate(6, sqlDataIniVig);
		} catch (Exception e) {

			comando.setDate(6, null);
		}
		comando.setString(7, f.getTb_pf_RIC());
		comando.setString(8, f.getTb_pf_cartao_saude());
		comando.setString(9, f.getTb_pf_nascido_vivo());
		comando.setString(10, f.getTb_pf_matricula_func());

		Date utilDate1 = null;
		try {
			utilDate1 = f.getPf_data_adm();
			java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
			comando.setDate(11, sqlDate1);
		} catch (Exception e) {

			comando.setDate(11, null);
		}
		comando.setString(12, f.getTb_pf_nro_docto());
		comando.setString(13, f.getTb_pf_orgao_exp());

		Date utilDataExped = null;
		try {
			utilDataExped = f.getPf_DataExped();
			java.sql.Date sqlDataExped = new java.sql.Date(
					utilDataExped.getTime());
			comando.setDate(14, sqlDataExped);
		} catch (Exception e) {

			comando.setDate(14, null);
		}

		comando.setString(15, f.getTb_pf_ddd01());
		comando.setString(16, f.getTb_pf_fone01());
		comando.setString(17, f.getTb_pf_ddd02());
		comando.setString(18, f.getTb_pf_fone02());
		comando.setString(19, f.getSTREET_ZIPCODE());
		comando.setString(20, f.getTb_pf_PISPASEP());
		comando.setLong(21, f.getEmpresa_combo().getTb_idpj());
		comando.setLong(22, f.getProfissao_combo().getTb_id_prof());
		comando.setLong(23, f.getEstadocivil_combo().getTb_id_estado());

		comando.setLong(24, f.getTb_cep_num());
		comando.setString(25, f.getSTREET_COMP());
		comando.setString(26, f.getTb_pf_email());
		comando.setString(27, f.getTb_num_carteira());

		Date utilDaten = null;
		try {
			utilDaten = new Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDaten.getTime());
			comando.setDate(28, sqlDate);
		} catch (Exception e) {

			comando.setDate(28, null);
		}

		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

}
