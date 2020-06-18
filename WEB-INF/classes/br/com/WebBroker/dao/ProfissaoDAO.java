
package br.com.WebBroker.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Profissao;
import br.com.WebBroker.factory.ConexaoFactory;

public class ProfissaoDAO {

	public ArrayList<Profissao> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id_prof,tb_prof FROM tb_profissao order by id_prof");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Profissao> lista = new ArrayList<Profissao>();

		while (resultado.next()) {
			Profissao u = new Profissao();
			u.setTb_id_prof(resultado.getLong("id_prof"));
			u.setTb_prof(resultado.getString("tb_prof"));
			lista.add(u);
		}
		comando.close();
		conexao.close();

		return lista;
	}

	public void salvar(Profissao f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_profissao ");
		sql.append("(tb_prof)");
		sql.append(" VALUES (?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setString(1, f.getTb_prof());

		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

	public void editar(Profissao f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tb_profissao SET tb_prof = ? WHERE id_prof = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setString(1, f.getTb_prof());
		comando.setLong(2, f.getTb_id_prof());

		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

	public void excluir(Profissao f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tb_profissao WHERE id_prof = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setLong(1, f.getTb_id_prof());

		comando.executeUpdate();
		comando.close();
		conexao.close();


	}

}
