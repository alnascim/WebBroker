package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.WebBroker.domain.Beneficios;
import br.com.WebBroker.domain.Congenere_combo;
import br.com.WebBroker.domain.Pdepend;
import br.com.WebBroker.domain.Pfisica;
import br.com.WebBroker.domain.Segmento;
import br.com.WebBroker.factory.ConexaoFactory;

public class PfisicaDAO {
	Boolean rBotao;
	public ArrayList<Beneficios> getbeneficios(Pfisica ap) throws SQLException {
		StringBuilder sql = new StringBuilder();
 				
		sql.append("SELECT a.id, ");
		sql.append("a.tb_num_carteira, ");
		sql.append("b.id_apolice, ");
		sql.append("d.tb_razao  ");
		sql.append("from lemara_schema.tb_relat_benef a ");
		sql.append("inner join lemara_schema.tb_apolice b on b.id_apolice = a.id_apolice ");
		sql.append("inner join lemara_schema.tb_cliente_pj d on d.tb_idpj = b.tb_idpj  ");
				
		sql.append(" where a.id_pessoa = " + ap.getIdtb_pessoafisica());
				
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Beneficios> lista = new ArrayList<Beneficios>();

		while (resultado.next()) {
			Beneficios f = new Beneficios();
			f.setS_apolice(resultado.getString("id_apolice"));
			f.setNum_carteira(resultado.getString("tb_num_carteira"));
			f.setTb_razao(resultado.getString("tb_razao"));
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
		
	}

	public void getIdclientpf(Pfisica f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		FacesContext context = FacesContext.getCurrentInstance();
		Connection conexao = ConexaoFactory.conectar();
		sql.append("select case when MAX(idtb_pessoafisica)+1 is null then 1 else MAX(idtb_pessoafisica)+1 end as idtb_pessoafisica ");
		sql.append("from lemara_schema.tb_pessoafisica b ");
		try {
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());

			ResultSet resultado = comando.executeQuery();

			if (resultado.next()) {
				f.setIdtb_pessoafisica(resultado.getLong("idtb_pessoafisica"));
			}
		} catch (SQLException e) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erro ao localizar : " + e.getMessage(), ""));

		} finally {
			try {

				conexao.close();
			} catch (Throwable e) {
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Erro ao fechar operação ." + e.getMessage(), ""));

			}
		}

		conexao.close();
	}

	public void verifypf(Pfisica f, Pdepend d) throws SQLException {
		Long iddp = f.getIdtb_pessoafisica();

		d.setIdtb_pessoafisica(iddp);

	}

	public Boolean verifycpf(Pfisica f) throws SQLException {
		FacesContext context = FacesContext.getCurrentInstance();
		Connection conexao = ConexaoFactory.conectar();

		StringBuilder sql = new StringBuilder();
		String sCPF = f.getTb_pf_cpf();
		sql.append("SELECT tb_pf_cpf from v_verifycpf where tb_pf_cpf = ?");

		try {

			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());
			comando.setString(1, sCPF);

			ResultSet resultado = comando.executeQuery();

			if (resultado.next()) {
				rBotao = false;
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "CPF Já Cadastrado ! [ "
								+ sCPF + "]", ""));
			} else {
				rBotao = true;
				// context.addMessage(null, new FacesMessage(
				// FacesMessage.SEVERITY_ERROR, "CPF Não Cadastrado ! [ "
				// + sCPF + "]", ""));
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
		return rBotao;
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
//		sql.append("Case when b.tb_IDPJ is null then 'Estipulante/Empresa Não Relacionada' else b.tb_razao end as tb_razao,");

		sql.append("tb_num_carteira, ");
		sql.append("tb_pf_email ");
		sql.append(" from tb_pessoafisica a ");
//		sql.append(" left join tb_cliente_pj b on b.tb_IDPJ = a.tb_IDPJ ");

		sql.append(" left join t_cts_int_zipcode_data d");
		sql.append(" on d.STREET_ZIPCODE = a.tb_pf_CEP");

		sql.append(" left join t_cts_streettype t");
		sql.append(" on (t.id = d.street_type)");

		sql.append(" left join t_state x");
		sql.append(" on (x.state_id = d.state)");

		sql.append(" where id_tipo_pf = 1 ORDER BY a.idtb_pessoafisica desc  ");

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

//			f.settb_razao(resultado.getString("tb_razao"));

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
		sql.append("UPDATE tb_pessoafisica SET ");
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

		sql.append(" WHERE idtb_pessoafisica = ? and id_tipo_pf = 1");

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
		sql.append("DELETE FROM TB_PESSOAFISICA WHERE idtb_pessoafisica = ? and id_tipo_pf = 1");
		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar().prepareStatement(
				sql.toString());

		comando.setLong(1, f.getIdtb_pessoafisica());
		comando.executeUpdate();
		comando.close();

	}

	public void buscaOneDepend(Pdepend f) throws SQLException {
		FacesContext context = FacesContext.getCurrentInstance();
		StringBuilder sql = new StringBuilder();
		Connection conexao = ConexaoFactory.conectar();

		sql.append(" SELECT ");
		sql.append(" d.idtb_dependente, ");
		sql.append(" d.idtb_pessoafisica, ");
		sql.append(" d.tb_pf_nome, ");
		sql.append(" d.tb_pf_datanasc, ");
		sql.append(" d.tb_pf_cpf, ");
		sql.append(" d.tb_pf_nro_docto, ");
		sql.append(" d.tb_pf_email ");
		sql.append(" From tb_dependente d ");
		sql.append(" Where d.idtb_dependente = ?  ");

		try {
			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());
			comando.setLong(1, f.getIdtb_dependente());
			ResultSet resultado = comando.executeQuery();

			if (resultado.next()) {
				Pdepend item = new Pdepend();

				item.setIdtb_pessoafisica(resultado
						.getLong("idtb_pessoafisica"));
				item.setTb_pf_nome(resultado.getString("tb_pf_nome"));
				item.setTb_pf_datanasc(resultado.getString("tb_pf_datanasc"));
				item.setTb_pf_cpf(resultado.getString("tb_pf_cpf"));
				item.setTb_pf_nro_docto(resultado.getString("tb_pf_nro_docto"));
				item.setTb_pf_email(resultado.getString("tb_pf_email"));

			} else {
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Dependente Não Localizado", ""));

			}
		} catch (SQLException e) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erro ao tentar localizar Dependente. Mensagem: "
									+ e.getMessage(), ""));

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

	public void salvar(Pfisica f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_pessoafisica (");
		sql.append("tb_pf_nome,");
		sql.append("tb_pf_sexo,");
		sql.append("id_est_civ,");
		sql.append("tb_pf_datanasc, ");
		sql.append("tb_pf_cpf, ");
		sql.append("tb_pf_nro_docto, ");
		sql.append("tb_pf_orgao_exp,");
		sql.append("tb_pf_DataExped,");
		sql.append("tb_pf_nome_mae, ");
		sql.append("tb_dt_ini_vig,");
		sql.append("tb_pf_RIC,");
		sql.append("tb_pf_cartao_saude,");
		sql.append("tb_pf_nascido_vivo,");
		sql.append("tb_pf_matricula_func,");
		sql.append("id_prof,");
		sql.append("tb_pf_data_adm,");
		sql.append("tb_pf_PISPASEP,");
		sql.append("tb_pf_ddd01,");
		sql.append("tb_pf_fone01,");
		sql.append("tb_pf_ddd02,");
		sql.append("tb_pf_fone02,");
		sql.append("tb_pf_CEP,");
		sql.append("tb_pf_email,");
		sql.append("tb_cep_num, ");
		sql.append("tb_cep_compl,");		
		sql.append("insert_date,");
		sql.append("idtb_pessoafisica,");
		sql.append("id_tipo_pf ");

		sql.append(") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1) ");

		Connection conexao = ConexaoFactory.conectar();
		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar().prepareStatement(
				sql.toString());

		comando.setString(1, f.getTb_pf_nome());
		comando.setString(2, f.getTb_pf_sexo());
		comando.setLong(3, f.getEstadocivil_combo().getTb_id_estado());

		Date utilDate = null;
		try {
			utilDate = f.getPf_datanasc();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			comando.setDate(4, sqlDate);
		} catch (Exception e) {

			comando.setDate(4, null);
		}
		comando.setString(5, f.getTb_pf_cpf());
		comando.setString(6, f.getTb_pf_nro_docto());
		comando.setString(7, f.getTb_pf_orgao_exp());

		Date utilDataExped = null;
		try {
			utilDataExped = f.getPf_DataExped();
			java.sql.Date sqlDataExped = new java.sql.Date(
					utilDataExped.getTime());
			comando.setDate(8, sqlDataExped);
		} catch (Exception e) {

			comando.setDate(8, null);
		}
		comando.setString(9, f.getTb_pf_nome_mae());
		
		Date utilDataIniVig = null;
		try {
			utilDataIniVig = f.getPf_dt_ini_vig();
			java.sql.Date sqlDataIniVig = new java.sql.Date(
					utilDataIniVig.getTime());
			comando.setDate(10, sqlDataIniVig);
		} catch (Exception e) {

			comando.setDate(10, null);
		}
		comando.setString(11, f.getTb_pf_RIC());
		comando.setString(12, f.getTb_pf_cartao_saude());
		comando.setString(13, f.getTb_pf_nascido_vivo());
		comando.setString(14, f.getTb_pf_matricula_func());
		comando.setLong(15, f.getProfissao_combo().getTb_id_prof());
		Date utilDate1 = null;
		try {
			utilDate1 = f.getPf_data_adm();
			java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
			comando.setDate(16, sqlDate1);
		} catch (Exception e) {

			comando.setDate(16, null);
		}
		comando.setString(17, f.getTb_pf_PISPASEP());
		comando.setString(18, f.getTb_pf_ddd01());
		comando.setString(19, f.getTb_pf_fone01());
		comando.setString(20, f.getTb_pf_ddd02());
		comando.setString(21, f.getTb_pf_fone02());
		comando.setString(22, f.getSTREET_ZIPCODE());
		comando.setString(23, f.getTb_pf_email());
		comando.setLong(24, f.getTb_cep_num());
		comando.setString(25, f.getSTREET_COMP());
		Date utilDaten = null;
		try {
			utilDaten = new Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDaten.getTime());
			comando.setDate(26, sqlDate);
		} catch (Exception e) {

			comando.setDate(26, null);
		}	
		comando.setLong(27, f.getIdtb_pessoafisica());
		
		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

	public ArrayList<Segmento> getprodfromcia(Pfisica ap) throws SQLException {
		StringBuilder sql = new StringBuilder();
		Long Tb_idpj = ap.getCongenere_combo().getTb_idpj();

		sql.append("SELECT ");
		sql.append(" a.id, ");
		sql.append(" a.tb_segmento, ");
		sql.append(" a.id_subsegmento, a.nco_cia,");
		sql.append(" a.tb_sigla, ");
		sql.append(" concat(a.nco_cia,' - ',b.tb_razao ,' - ',c.tb_subsegmento) as tb_razao,");
		sql.append(" concat(a.nco_cia,' - ',b.tb_razao ,' - ',c.tb_subsegmento,' Ramo - ',a.tb_sigla) as segmento");

		sql.append(" from tb_segmento a ");
		sql.append(" inner join tb_subsegmento c on a.id_subsegmento = c.idsub ");
		sql.append(" inner join tb_cliente_PJ b on c.tb_idpj=b.tb_idpj ");

		sql.append(" where b.tb_idpj = " + Tb_idpj);
	
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

			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}
	public ArrayList<Congenere_combo> getcongeneres(Pfisica ap) throws SQLException {
		StringBuilder sql = new StringBuilder();
			
		sql.append("SELECT ");
		sql.append("a.tb_idpj,");		
		sql.append("Concat(ve.nome,'-',a.tb_Razao) as tb_Razao ");
		sql.append(" from tb_cliente_PJ a ");
		sql.append(" inner join lemara_schema.v_empresasgrupo ve ");
		sql.append(" on ve.id = a.tb_fk_empresagrupo" );
		
		sql.append(" inner join lemara_schema.tb_apolice p on p.id_congenere = a.tb_idpj");
		
		sql.append(" where a.id_tipo_pj = 1 and a.DEL_LOGICA = 'N'");
		sql.append(" and p.id_apolice = ? ");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setLong(1, ap.getApolices_combo().getId_apolice());
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Congenere_combo> lista = new ArrayList<Congenere_combo>();

		while (resultado.next()) {
			
			Congenere_combo f = new Congenere_combo();
			f.setTb_idpj(resultado.getLong("tb_idpj"));
			f.setTb_razao(resultado.getString("tb_razao"));
 
			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}
	public ArrayList<Segmento> getapolice(Pfisica ap) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT ");
		sql.append(" a.id, s.id as id_segmento, ");
		sql.append(" a.id_apolice as apolice, ");
		sql.append(" b.tb_senha_acesso, ");
		sql.append(" s.tb_segmento ");

		sql.append(" from tb_apolice a ");
		sql.append(" inner join tb_cliente_pj b on b.tb_IDPJ = a.tb_IDPJ ");
		sql.append(" inner join tb_segmento s on s.id = a.id_segmento ");

		sql.append(" where s.id  = " + ap.getSegmento_combo().getId());

		sql.append(" and b.del_logica='N' ");
		sql.append(" order by a.id_apolice");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Segmento> lista = new ArrayList<Segmento>();

		while (resultado.next()) {
			Segmento f = new Segmento();
			f.setId_apolice(resultado.getLong("id"));
			f.setSid_apolice(resultado.getString("apolice"));
			f.setId(resultado.getLong("id_segmento"));
			f.setSenha_acesso(resultado.getString("tb_senha_acesso"));
			f.setTb_segmento(resultado.getString("tb_segmento"));
			lista.add(f);
		}
		comando.close();
		conexao.close();

		return lista;
	}
	
	public void salvarRelac(Pfisica b) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO lemara_schema.tb_relat_benef(");
		sql.append("id_pessoa, ");
		sql.append("tb_num_carteira, ");		
		sql.append("id_apolice ");
//		sql.append("id_estipulante, ");
//		sql.append("id_segmento, ");
//		sql.append("id_apolice ");
		
		
		sql.append(") VALUES (?,?,?) ");
		
		Connection conexao = ConexaoFactory.conectar();
		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar()
				.prepareStatement(sql.toString());
		
		comando.setLong(1,b.getIdtb_pessoafisica());		
		comando.setString(2, b.getTb_num_carteira());
		comando.setLong(3, b.getApolices_combo().getId_apolice());
//		comando.setLong(3, b.getCongenere_combo().getTb_idpj());
//		comando.setLong(4, b.getEmpresa_combo().getTb_idpj());		
//		comando.setLong(5, b.getSegmento_combo().getId());
//		comando.setLong(6, b.getApolice_combo().getId_apolice());
		 
		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

}
