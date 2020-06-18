package br.com.WebBroker.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.GrupoContaDAO;
import br.com.WebBroker.domain.GrupoConta;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBGrupoConta")
@ViewScoped
public class GrupoContaBean {

	private GrupoConta GrupoConta;
	private ArrayList<GrupoConta> itens;
	private ArrayList<GrupoConta> itensfiltrados;

	public GrupoConta getGrupoConta() {
		return GrupoConta;
	}

	public void setGrupoConta(GrupoConta grupoConta) {
		GrupoConta = grupoConta;
	}

	public ArrayList<GrupoConta> getItens() {
		return itens;
	}

	public void setItens(ArrayList<GrupoConta> itens) {
		this.itens = itens;
	}

	public ArrayList<GrupoConta> getItensfiltrados() {
		return itensfiltrados;
	}

	public void setItensfiltrados(ArrayList<GrupoConta> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			GrupoContaDAO dao = new GrupoContaDAO();
			itens = dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - " + ex.getMessage());
		}
	}

	public void prepararNovo() {
		GrupoConta = new GrupoConta();
	}

	public void novo() {

		try {
			GrupoContaDAO dao = new GrupoContaDAO();

			dao.salvar(GrupoConta);
			itens = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Registro Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  002 - " + ex.getMessage());
		}
	}

	public void excluir() {

		try {
			GrupoContaDAO dao = new GrupoContaDAO();
			dao.excluir(GrupoConta);

			JSFUtil.adicionarMensagemSucesso("Registro Removido com Sucesso!");
			itens = dao.listar();

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
		}
	}

}
