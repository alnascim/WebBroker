package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.WebBroker.domain.EmpresasLemara_combo;
import br.com.WebBroker.domain.Pjuridicas;
import br.com.WebBroker.factory.ConexaoFactory;


public class PjuridicasDAO {

	public ArrayList<EmpresasLemara_combo> EmpresasGrupo() throws SQLException {

		ArrayList<EmpresasLemara_combo> lista = new ArrayList<EmpresasLemara_combo>();
		StringBuilder sql = new StringBuilder();

		sql.append(" SELECT 1 AS ID, 'Lemara' as Nome ");
		sql.append(" Union ");
		sql.append(" SELECT 2 AS ID, 'LemaraCORR' as Nome ");

		Connection conexao = ConexaoFactory.conectar();

		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar().prepareStatement(
				sql.toString());

		ResultSet resultado = comando.executeQuery();
		while (resultado.next()) {

			EmpresasLemara_combo u = new EmpresasLemara_combo();

			u.setIdtb_pessoafisica(resultado.getLong("id"));
			u.setTb_pf_nome(resultado.getString("nome"));

			lista.add(u);

		}
		comando.close();
		conexao.close();

		return lista;
	}
	
	public ArrayList<Pjuridicas> buscaPornome(Pjuridicas u) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT tb_IDPJ,tb_Cnpj,TB_RAZAO,TB_NUMAPO FROM tb_cliente_PJ WHERE TB_RAZAO LIKE ? and id_tipo_pj = 1  and del_logica='N' order by TB_RAZAO");
	 
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, "%" + u.getTb_Razao() + "%");

		ResultSet resultado = comando.executeQuery();

		ArrayList<Pjuridicas> lista = new ArrayList<Pjuridicas>();

		while (resultado.next()) {

			Pjuridicas item = new Pjuridicas();

			item.setTb_Cnpj(resultado.getString("tb_Cnpj"));
			item.setTb_IDPJ(resultado.getLong("tb_IDPJ"));
			item.setTb_Razao(resultado.getString("TB_RAZAO"));
			item.setTb_numapo(resultado.getLong("TB_NUMAPO"));

			lista.add(item);

		}

		return lista;
	}

	public ArrayList<Pjuridicas> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct a.tb_cep,");
		sql.append("a.id_segmento,");
		sql.append("a.id_angariador, ");
		sql.append("a.tb_IDPJ,");
		sql.append("(select b.tb_pf_nome from tb_pessoafisica B where b.idtb_pessoafisica = a.id_angariador limit 1) as tb_pf_nome,");
		sql.append("a.tb_Cnpj,");
		sql.append("Concat(ve.nome,'-',a.tb_Razao) as tb_Razao,");
		sql.append("IFNULL(b.id_apolice,'9999999') as id_apolice,");
		sql.append("a.tb_Contato,");
		sql.append("a.tb_emaiL,");
		sql.append("a.tb_pj_ddd01,");
		sql.append("a.tb_pj_fone01,");
		sql.append("a.tb_pj_ddd02,");
		sql.append("a.tb_pj_fone02,");
		sql.append("a.tb_Qtd_Socio,");
		sql.append("a.tb_ini_ativ,");
		sql.append("a.tb_senha_acesso,");
		sql.append("a.tb_cod_agencia,");
		sql.append("IFNULL(x.state_name,'Cep não localizado') as state,");
		sql.append("IFNULL(d.CITY,'Cep não localizado') as 	CITY	,");
		sql.append("IFNULL(d.DISTRICT,'Cep não localizado') as 	DISTRICT,");
		sql.append("IFNULL(t.street_types,'Cep não localizado') as 	STREET_TYPE,	");
		sql.append("IFNULL(d.STREET_NAME,'Cep não localizado') as 	STREET_NAME,");
		sql.append("a.tb_cep_compl, ");
		
		sql.append("a.tb_tipocontato, ");
		sql.append("a.tb_cepcorresp, ");
		
		sql.append("a.tb_cep_num ");
		sql.append(" FROM tb_cliente_PJ  a ");

		sql.append(" inner join lemara_schema.v_empresasgrupo ve ");
		sql.append(" on ve.id = a.tb_fk_empresagrupo" );
		
		sql.append(" left join t_cts_int_zipcode_data d");
		sql.append(" on d.STREET_ZIPCODE = a.tb_cep" );
		
		sql.append(" left join t_cts_streettype t");
		sql.append(" on (t.id = d.street_type)");
		
		sql.append(" left join t_state x");
		sql.append(" on (x.state_id = d.state)");

		sql.append(" left join tb_APOLICE B ");
		sql.append(" on (a.tb_idpj = b.tb_idpj and a.tb_idpj = b.tb_idpj  )");
		sql.append(" where a.id_tipo_pj = 1");

		sql.append(" order by a.insert_date desc");
	
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();

		ArrayList<Pjuridicas> lista = new ArrayList<Pjuridicas>();

		while (resultado.next()) {

			Pjuridicas u = new Pjuridicas();
			u.setTb_Cnpj(resultado.getString("tb_Cnpj"));
			u.setTb_Razao(resultado.getString("tb_Razao"));
			u.setTb_Contato(resultado.getString("tb_Contato"));
			u.setTb_email(resultado.getString("tb_emaiL"));
			u.setTb_Qtd_Socio(resultado.getLong("tb_Qtd_Socio"));
			u.setTb_ini_ativ(resultado.getString("tb_ini_ativ"));
			u.setIni_ativ(resultado.getDate("tb_ini_ativ"));
			u.setTb_pf_nome(resultado.getString("tb_pf_nome"));
			u.setTb_numapo(resultado.getLong("id_apolice"));
			u.setTb_IDPJ(resultado.getLong("tb_IDPJ"));
			u.setTb_senha_acesso(resultado.getString("tb_senha_acesso"));
			u.setId_angariador(resultado.getLong("id_angariador"));
			u.setSTREET_ZIPCODE(resultado.getString("tb_cep"));
			u.setSTATE(resultado.getString("sTATE"));
			u.setCITY(resultado.getString("cITY"));
			u.setDISTRICT(resultado.getString("DISTRICT"));
			u.setSTREET_TYPE(resultado.getString("STREET_TYPE"));
			u.setSTREET_NAME(resultado.getString("STREET_NAME"));
			u.setSTREET_COMP(resultado.getString("tb_cep_compl"));
			u.setTb_cep_num(resultado.getLong("tb_cep_num"));
			u.setTb_cod_agencia(resultado.getLong("tb_cod_agencia"));
			
			u.setTb_cepcorresp(resultado.getString("tb_cepcorresp"));
			u.setTb_tipocontato(resultado.getString("tb_tipocontato"));
			
			u.setTb_pj_ddd01(resultado.getString("tb_pj_ddd01"));
			u.setTb_pj_fone01(resultado.getString("tb_pj_fone01"));
			
			u.setTb_pj_ddd02(resultado.getString("tb_pj_ddd02"));
			u.setTb_pj_fone02(resultado.getString("tb_pj_fone02"));
			
			/*
			 * java.util.Date d = new java.util.Date(); java.util.Date dataUtil
			 * = df.parse(u.getTb_ini_ativ()); java.util.Date dataJDBCN = new
			 * java.util.Date( dataUtil.getTime());
			 */

			lista.add(u);

		}
		comando.close();
		conexao.close();
		return lista;
	}
	public void salvar(Pjuridicas f) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("INSERT INTO tb_cliente_Pj( ");
		sql.append("  tb_Cnpj ");
		sql.append(" ,tb_Razao ");
		sql.append(" ,tb_Contato ");
		sql.append(" ,tb_email ");
		sql.append(" ,tb_ini_ativ ");
		sql.append(" ,tb_cep ");
		sql.append(" ,tb_cep_num ");
		sql.append(" ,tb_cep_compl ");
		sql.append(" ,tb_cepcorresp ");
		sql.append(" ,tb_tipocontato ");
		sql.append(" ,insert_date ");
		sql.append(" ,id_tipo_pj ");
		sql.append(" ,tb_fk_empresagrupo ");
		sql.append(" ,tb_pj_ddd01 ");
		sql.append(" ,tb_pj_fone01 ");	
		sql.append(" ,tb_pj_ddd02 ");
		sql.append(" ,tb_pj_fone02 ");	
		
		sql.append(" ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
 
		Connection conexao = ConexaoFactory.conectar();
		new ConexaoFactory();
		PreparedStatement comando = ConexaoFactory.conectar()
				.prepareStatement(sql.toString()); 

		/* Set date */
		comando.setString(1, f.getTb_Cnpj());
		comando.setString(2, f.getTb_Razao());
		comando.setString(3, f.getTb_Contato());
		comando.setString(4, f.getTb_email());
		Date utilDate = null;
		try {
			utilDate = f.getIni_ativ();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			comando.setDate(5, sqlDate);
		} catch (Exception e) {

			comando.setDate(5, null);
		}
		comando.setString(6, f.getSTREET_ZIPCODE());
		comando.setLong(7, f.getTb_cep_num());
		comando.setString(8, f.getSTREET_COMP());		
		comando.setString(9, f.getTb_cepcorresp());
		comando.setString(10, f.getTb_tipocontato());
		Date utilDaten = null;
		try {
			utilDaten = new Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDaten.getTime());
			comando.setDate(11, sqlDate);
		} catch (Exception e) {
			comando.setDate(11, null);
		}
		comando.setInt(12, 1);
		comando.setLong(13, f.getEmpresasgrupo().getIdtb_pessoafisica());
		
		comando.setString(14, f.getTb_pj_ddd01());
		comando.setString(15, f.getTb_pj_fone01());
		comando.setString(16, f.getTb_pj_ddd02());
		comando.setString(17, f.getTb_pj_fone02());
				
		comando.executeUpdate();
		comando.close();
		conexao.close();
	}
	
	public Pjuridicas consultar(Pjuridicas f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT TB_RAZAO,TB_NUMAPO FROM tb_cliente_PJ WHERE tb_Cnpj = ? and id_tipo_pj=1");
		sql.append("  and del_logica='N' ");
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, f.getTb_Cnpj());

		ResultSet resultado = comando.executeQuery();

		Pjuridicas retorno = null;

		if (resultado.next()) {
			retorno = new Pjuridicas();
			retorno.setTb_Razao(resultado.getString("TB_RAZAO"));
			retorno.setTb_numapo(resultado.getLong("TB_NUMAPO"));
		}
		comando.close();
		conexao.close();

		return retorno;
	}

	public void localizar(Pjuridicas j) throws SQLException {
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
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, j.getSTREET_ZIPCODE());
 
			ResultSet resultado = comando.executeQuery();
			
			if (resultado.next()) {
				j.setSTREET_NAME(resultado.getString("STREET_NAME"));
				j.setCITY(resultado.getString("CITY"));
				j.setDISTRICT(resultado.getString("DISTRICT"));
				j.setSTREET_ZIPCODE(resultado.getString("STREET_ZIPCODE"));
				j.setSTATE(resultado.getString("state"));
				j.setSTREET_TYPE(resultado.getString("STREET_TYPE"));
			} else {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"CEP   Inexistente", ""));
				 
			}
		} catch (SQLException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro ao localizar CEP. Mensagem: " + e.getMessage(), ""));
		
		} finally {
			try {
 
				conexao.close();
			} catch (Throwable e) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro ao fechar operação de Localização. Mensagem: " + e.getMessage(), ""));
				
			}
		}
		
	}
	public void editar(Pjuridicas f) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE tb_cliente_PJ SET ");

		sql.append(" tb_Contato = ?,");
		sql.append(" tb_email = ? ,");
		sql.append(" tb_Qtd_Socio = ? ,");
		sql.append(" tb_ini_ativ = ? ,");
		sql.append(" tb_Razao = ? ,");
		sql.append(" tb_cnpj = ? ,");
		sql.append(" tb_cep = ? ,");
		sql.append(" tb_senha_acesso = ?, ");
		sql.append(" tb_cep_num = ?, ");
		sql.append(" tb_cep_compl = ?, ");
		sql.append(" tb_tipocontato = ?, ");
		sql.append(" tb_cepcorresp = ?,");
		sql.append(" tb_pj_ddd01= ?, ");
		sql.append(" tb_pj_fone01= ?, ");	
		sql.append(" tb_pj_ddd02= ?, ");
		sql.append(" tb_pj_fone02= ? ");	
		
		sql.append(" WHERE tb_IDPJ = ? ");		
		
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, f.getTb_Contato());
		comando.setString(2, f.getTb_email());
		comando.setLong(3, f.getTb_Qtd_Socio());
		/* Set date */

		Date utilDate = null;
		try {
			utilDate = f.getIni_ativ();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			comando.setDate(4, sqlDate);
		} catch (Exception e) {

			comando.setDate(4, null);
		}

		/* Set date */
		comando.setString(5, f.getTb_Razao());
		comando.setString(6, f.getTb_Cnpj());
		comando.setString(7, f.getSTREET_ZIPCODE());
		comando.setString(8, f.getTb_senha_acesso());
		comando.setLong(9, f.getTb_cep_num());
		comando.setString(10, f.getSTREET_COMP());
		
		comando.setString(11, f.getTb_tipocontato());
		comando.setString(12, f.getTb_cepcorresp());
		comando.setString(13, f.getTb_pj_ddd01());
		comando.setString(14, f.getTb_pj_fone01());
		comando.setString(15, f.getTb_pj_ddd02());
		comando.setString(16, f.getTb_pj_fone02());
		comando.setLong(17, f.getTb_IDPJ());
		
		comando.executeUpdate();
		comando.close();
		conexao.close();

		// try {
		// comando.executeUpdate();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	public void excluir(Pjuridicas f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tb_cliente_PJ WHERE tb_IDPJ = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setLong(1, f.getTb_IDPJ());

		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

}
