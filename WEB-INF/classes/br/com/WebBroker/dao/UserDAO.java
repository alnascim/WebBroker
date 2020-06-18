
package br.com.WebBroker.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Usuario;
import br.com.WebBroker.factory.ConexaoFactory;

public class UserDAO {

	public ArrayList<Usuario> buscaPornome(Usuario u) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT TB_USER_ID,TB_USER_NAME FROM tb_user WHERE TB_USER_NAME LIKE ? order by TB_USER_NAME");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());
		comando.setString(1, "%" + u.getUsername() + "%");

		ResultSet resultado = comando.executeQuery();

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		while (resultado.next()) {

			Usuario item = new Usuario();

			item.setIduser(resultado.getLong("TB_USER_ID"));
			item.setUsername(resultado.getString("TB_USER_NAME"));

			lista.add(item);

		}
		comando.close();
		conexao.close();

		return lista;
	}

	public ArrayList<Usuario> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT TB_USER_ID,TB_USER_NAME,TB_FUNCTION FROM tb_user order by TB_USER_NAME");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		while (resultado.next()) {

			Usuario u = new Usuario();

			u.setIduser(resultado.getLong("TB_USER_ID"));
			u.setUsername(resultado.getString("TB_USER_NAME"));
			u.setTb_function(resultado.getString("TB_FUNCTION"));

			lista.add(u);

		}
		comando.close();
		conexao.close();

		return lista;
	}

	public void salvar(Usuario f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_user ");
		sql.append("(TB_USER_NAME,TB_USER_PWD,TB_FUNCTION)");
		sql.append(" VALUES (?,?,?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setString(1, f.getUsername());
		comando.setString(2, f.getUserpwd());
		comando.setString(3, f.getTb_function());

		comando.executeUpdate();
		comando.close();
		conexao.close();


	}

	public Usuario validarlogin(Usuario f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT TB_USER_PWD FROM tb_user WHERE TB_USER_NAME = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setString(1, f.getUsername());

		ResultSet resultado = comando.executeQuery();

		Usuario retorno = null;

		if (resultado.next()) {
			retorno = new Usuario();
			retorno.setUserpwd(resultado.getString("TB_USER_PWD"));
		}
		comando.close();
		conexao.close();

		return retorno;
	}

	public Usuario consultar(Usuario f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT TB_USER_ID,TB_USER_NAME FROM tb_user WHERE TB_USER_ID = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setLong(1, f.getIduser());

		ResultSet resultado = comando.executeQuery();

		Usuario retorno = null;

		if (resultado.next()) {
			retorno = new Usuario();
			retorno.setIduser(resultado.getLong("TB_USER_ID"));
			retorno.setUsername(resultado.getString("TB_USER_NAME"));
		}
		comando.close();
		conexao.close();

		return retorno;
	}

	public void editar(Usuario f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tb_user SET TB_USER_NAME = ? WHERE TB_USER_ID = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setString(1, f.getUsername());
		comando.setLong(2, f.getIduser());

		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

	public void excluir(Usuario f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tb_user WHERE TB_USER_ID = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = new ConexaoFactory().conectar()
				.prepareStatement(sql.toString());

		comando.setLong(1, f.getIduser());

		comando.executeUpdate();
		comando.close();
		conexao.close();

	}

	public static void main(String[] args) {
		
		 Usuario u1 = new Usuario(); 
		  u1.setIduser(11L);
		  
		  UserDAO udao = new UserDAO();
		  
		  try { Usuario u2 = udao.consultar(u1);
		  
		  System.out.println("Resulado " + u1); System.out.println("Resulado " + u2); 
		  
		     } catch (SQLException e) {
		  System.out.println("Usuario não encontrado"); e.printStackTrace(); 
		  }

		
		

	}

}
