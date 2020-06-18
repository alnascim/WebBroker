package br.com.WebBroker.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import br.com.WebBroker.dao.EstadocivilDAO;
import br.com.WebBroker.domain.Estadocivil;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBEst")
@ViewScoped
public class EstadocivilBean {

	private Estadocivil estadoc;

	private ArrayList<Estadocivil> itens;
	private ArrayList<Estadocivil> itensfiltrados;

	public Estadocivil getEstado() {
		return estadoc;
	}

	public void setEstado(Estadocivil estado) {

		this.estadoc = estado;
	}

	public ArrayList<Estadocivil> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Estadocivil> itens) {
		this.itens = itens;
	}

	public ArrayList<Estadocivil> getItensfiltrados() {
		return itensfiltrados;
	}

	public void setItensfiltrados(ArrayList<Estadocivil> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			EstadocivilDAO dao = new EstadocivilDAO();
			itens = dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro 001 - " + ex.getMessage());
		}
	}

	public void prepararNovo() {
		estadoc = new Estadocivil();
	}

	public void novo() {

		try {
			EstadocivilDAO dao = new EstadocivilDAO();
			dao.salvar(estadoc);
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro Usuário 002 - "
					+ ex.getMessage());
		}

	}

	public void excluir() {

		try {
			EstadocivilDAO dao = new EstadocivilDAO();
			dao.excluir(estadoc);
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Removido com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro Usuário 003 - "
					+ ex.getMessage());
		}

	}

	public void editar() {

		try {
			EstadocivilDAO dao = new EstadocivilDAO();
			dao.editar(estadoc);
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Alterado com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro Usuário 003 - "
					+ ex.getMessage());
		}
	}
}
