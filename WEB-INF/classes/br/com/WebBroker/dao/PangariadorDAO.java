package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import br.com.WebBroker.domain.Pangariador;
import br.com.WebBroker.factory.ConexaoFactory;

public class PangariadorDAO {
	
	public ArrayList<Pangariador> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		/*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");*/			
		
		sql.append("SELECT ");
		sql.append("idtb_pessoafisica,tb_pf_nome, ");
		sql.append("tb_pf_datanasc, ");
		sql.append("tb_pf_cpf, ");
		sql.append("tb_pf_nro_docto ");		
		sql.append(" from tb_pessoafisica where id_tipo_pf = 4 order by tb_pf_nome" );

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Pangariador> lista = new ArrayList<Pangariador>();

		while (resultado.next()) {
			
			Pangariador f = new Pangariador();
			f.setIdtb_pessoafisica(resultado.getLong("idtb_pessoafisica"));
			f.setTb_pf_nome(resultado.getString("tb_pf_nome"));
			f.setTb_pf_datanasc(resultado.getString("tb_pf_datanasc"));
			f.setTb_pf_cpf(resultado.getString("tb_pf_cpf"));
			f.setTb_pf_nro_docto(resultado.getString("tb_pf_nro_docto"));

			f.setPf_datanasc(resultado.getDate("tb_pf_datanasc"));

			lista.add(f);

		}
		comando.close();
		conexao.close();

		return lista;
	}
	
	public void editar(Pangariador f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE tb_pessoafisica SET tb_pf_nome = ?, ");
		sql.append(" tb_pf_datanasc = ? ,");
		sql.append(" tb_pf_nro_docto = ? ");
		sql.append(" WHERE idtb_pessoafisica = ? and id_tipo_pf = 4 ");
	
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
/* Set date*/
		
		Date utilDate = null;
		try {
			utilDate = f.getPf_datanasc();
			java.sql.Date sqlDate1 = new java.sql.Date(utilDate.getTime());
			comando.setDate(2, sqlDate1);
		} catch (Exception e) {
			
			comando.setDate(2, null);
		}  
/* Set date*/		

		comando.setString(1, f.getTb_pf_nome());				
		comando.setString(3, f.getTb_pf_nro_docto());		
		comando.setLong(4,f.getIdtb_pessoafisica());
		
		
		try {
			comando.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		comando.close();
		conexao.close();

	 
		}
	public void excluir(Pangariador f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM TB_PESSOAFISICA WHERE idtb_pessoafisica = ? and id_tipo_pf = 4");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());
 
		comando.setLong(1,f.getIdtb_pessoafisica());
		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

	
	public void salvar(Pangariador f) throws SQLException {

		/*
		sql.append("tb_pf_sexo,");
		sql.append("tb_pf_datanasc,");
		sql.append("tb_pf_cpf,");
		sql.append("tb_pf_RIC,");
		sql.append("tb_pf_cartao_saude,");
		sql.append("tb_pf_nascido_vivo,");
		sql.append("tb_pf_matricula_func,");
		sql.append("tb_pf_data_adm,");
		sql.append("tb_pf_natur_id,");
		sql.append("tb_pf_orgao_exp,");
		sql.append("tb_pf_DataExped,");
		sql.append("tb_pf_PISPASEP,");
		sql.append("tb_pf_nome_respons,");
		sql.append("tb_pf_estciv,");
		sql.append("tb_pf_altura,");
		sql.append("tb_pf_peso,");
		sql.append("tb_pf_profissao,");
		sql.append("tb_pf_nome_mae,");
		sql.append("tb_pf_CEP,");
		sql.append("tb_pf_email,");
		sql.append("tb_pf_fone01,");
		sql.append("tb_pf_ddd01,");
		sql.append("tb_pf_fone02,");
		sql.append("tb_pf_ddd02,");
		sql.append("tb_pf_transf_titular,");
		sql.append("tb_pf_forma_reemb,");
		sql.append("tb_pf_nro_banco,");
		sql.append("tb_pf_nome_banco,");
		sql.append("tb_pf_agencia,");
		sql.append("tb_pf_conta,");
		sql.append("tb_pessoafisicacol)");
		sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
*/
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_pessoafisica ");
		sql.append("(tb_pf_nome,");
		sql.append("tb_pf_datanasc,");
		sql.append("tb_pf_cpf,");
		sql.append("tb_pf_nro_docto,id_tipo_pf) ");
		sql.append(" VALUES (?,?,?,?,4) ");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		Date utilDate = null;
		try {
			utilDate = f.getPf_datanasc();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			comando.setDate(2, sqlDate);
		} catch (Exception e) {
			
			comando.setDate(2, null);
		}		
		
		comando.setString(1, f.getTb_pf_nome());
		
		comando.setString(3,f.getTb_pf_cpf());
		comando.setString(4, f.getTb_pf_nro_docto());
		comando.executeUpdate();
		comando.close();
		conexao.close();

/*		
		comando.setString(3, f.getTb_pf_sexo());
		comando.setString(6, f.getTb_pf_RIC());
		comando.setString(7, f.getTb_pf_cartao_saude());
		comando.setString(8, f.getTb_pf_nascido_vivo());
		comando.setString(9, f.getTb_pf_matricula_func());
		comando.setString(10, f.getTb_pf_data_adm());
		
		comando.setString(12, f.getTb_pf_natur_id());
		comando.setString(13, f.getTb_pf_orgao_exp());
		comando.setString(14, f.getTb_pf_DataExped());
		comando.setString(15, f.getTb_pf_PISPASEP());
		comando.setString(16, f.getTb_pf_nome_respons());
		comando.setLong(17, f.getTb_pf_estciv());
		comando.setString(18, f.getTb_pf_altura());
		comando.setString(19, f.getTb_pf_peso());
		comando.setString(20, f.getTb_pf_profissao());
		comando.setString(21, f.getTb_pf_nome_mae());
		comando.setString(22, f.getTb_pf_CEP());
		comando.setString(23, f.getTb_pf_email());
		comando.setString(24, f.getTb_pf_fone01());
		comando.setString(25, f.getTb_pf_ddd01());
		comando.setString(26, f.getTb_pf_fone02());
		comando.setString(27, f.getTb_pf_ddd02());
		comando.setString(28, f.getTb_pf_transf_titular());
		comando.setString(29, f.getTb_pf_forma_reemb());
		comando.setString(30, f.getTb_pf_nro_banco());
		comando.setString(31, f.getTb_pf_nome_banco());
		comando.setString(32, f.getTb_pf_agencia());
		comando.setString(33, f.getTb_pf_conta());
		comando.setString(34, f.getTb_pessoafisicacol());
*/
		

	}
}
