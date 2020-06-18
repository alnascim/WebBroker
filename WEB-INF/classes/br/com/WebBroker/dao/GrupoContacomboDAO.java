package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.WebBroker.domain.GrupoConta_combo;
import br.com.WebBroker.factory.ConexaoFactory;

public class GrupoContacomboDAO {

	public ArrayList<GrupoConta_combo> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT ");
		sql.append(" id_sq,code,name");
		sql.append(" from lemara_finance.grupocontaresutado ");

		Connection conexao = ConexaoFactory.conectarf();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<GrupoConta_combo> lista = new ArrayList<GrupoConta_combo>();

		while (resultado.next()) {

			GrupoConta_combo f = new GrupoConta_combo();
			f.setId(resultado.getInt("id_sq"));
//			f.setCode(resultado.getInt("code"));
			f.setName(resultado.getString("name"));

			lista.add(f);

		}
		comando.close();
		conexao.close();
		return lista;
	}

}
