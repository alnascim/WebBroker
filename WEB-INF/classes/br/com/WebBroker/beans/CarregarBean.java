package br.com.WebBroker.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.PcarregarDAO;
import br.com.WebBroker.domain.Pcarregar;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBCarregar")
@ViewScoped
public class CarregarBean {

	private Pcarregar Carregar;

	private ArrayList<Pcarregar> itens;
	private ArrayList<Pcarregar> itensfiltrados;

	public Pcarregar getCarregar() {
		return Carregar;
	}

	public void setCarregar(Pcarregar Carregar) {
		this.Carregar = Carregar;
	}

	public Pcarregar getPcarregar() {
		return Carregar;
	}

	public void setPcarregar(Pcarregar Carregar) {

		this.Carregar = Carregar;
	}

	public ArrayList<Pcarregar> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Pcarregar> itens) {
		this.itens = itens;
	}

	public ArrayList<Pcarregar> getItensfiltrados() {
		return itensfiltrados;
	}

	public void setItensfiltrados(ArrayList<Pcarregar> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			PcarregarDAO dao = new PcarregarDAO();
			itens = dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - " + ex.getMessage());
		}
	}

	public void prepararNovo() {
		Carregar = new Pcarregar();
	}


}
