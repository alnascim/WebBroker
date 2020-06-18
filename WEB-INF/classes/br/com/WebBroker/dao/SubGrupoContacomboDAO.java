package br.com.WebBroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.WebBroker.domain.SubGrupoConta_combo;
import br.com.WebBroker.factory.ConexaoFactory;

public class SubGrupoContacomboDAO {

	public ArrayList<SubGrupoConta_combo> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT ");
		sql.append(" ID_SQ,ID_SQ_FK,NameSub,id_subsegmento");
		sql.append(" from lemara_finance.SubGrupoContaResutado ");

		Connection conexao = ConexaoFactory.conectarf();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<SubGrupoConta_combo> lista = new ArrayList<SubGrupoConta_combo>();

		while (resultado.next()) {

			SubGrupoConta_combo f = new SubGrupoConta_combo();
			f.setId_(resultado.getInt("ID_SQ"));
			f.setIdfk_(resultado.getInt("ID_SQ_FK"));
			f.setName_(resultado.getString("NameSub"));
			f.setIdsegmento_(resultado.getInt("id_subsegmento"));
			lista.add(f);
		}
		comando.close();
		conexao.close();
		return lista;
	}

}
