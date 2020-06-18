
package br.com.WebBroker.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Tipopessoafisica;
import br.com.WebBroker.factory.ConexaoFactory;

public class TipopessoafisicaDAO {

	public ArrayList<Tipopessoafisica> listar() throws SQLException {
		
		ArrayList<Tipopessoafisica> lista = new ArrayList<Tipopessoafisica>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id,tb_tipo FROM tb_tipo_pf ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();


		while (resultado.next()) {

			Tipopessoafisica u = new Tipopessoafisica();

			u.setId(resultado.getLong("id"));
			u.setTb_tipo(resultado.getString("tb_tipo"));

			lista.add(u);

		}
		comando.close();
		conexao.close();

		return lista;
	}

	public void salvar(Tipopessoafisica f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_tipo_pf ");
		sql.append("(tb_tipo)");
		sql.append(" VALUES (?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setString(1, f.getTb_tipo()); 

		comando.executeUpdate();
		comando.close();
		conexao.close();


	}


	public void editar(Tipopessoafisica f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tb_tipo_pf SET tb_tipo = ? WHERE id = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setString(1, f.getTb_tipo());
		comando.setLong(2, f.getId());

		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

	public void excluir(Tipopessoafisica f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tb_tipo_pf WHERE id = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setLong(1, f.getId());

		comando.executeUpdate();
		comando.close();
		conexao.close();


	}


}
