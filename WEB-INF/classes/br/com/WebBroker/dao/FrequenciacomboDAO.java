package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.Frequencia_combo;
import br.com.WebBroker.factory.ConexaoFactory;

public class FrequenciacomboDAO {

	public ArrayList<Frequencia_combo> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT ");
		sql.append(" id,frequence_name,frequence_count ");
		sql.append(" from t_billing_frequence ");

		Connection conexao = ConexaoFactory.conectarf();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Frequencia_combo> lista = new ArrayList<Frequencia_combo>();

		while (resultado.next()) {

			Frequencia_combo f = new Frequencia_combo();
			f.setId(resultado.getInt("id"));
			f.setFreq_name(resultado.getString("frequence_name"));
			f.setFreq_count(resultado.getInt("frequence_count"));

			lista.add(f);

		}
		comando.close();
		conexao.close();
		return lista;
	}

}
