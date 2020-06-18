package br.com.WebBroker.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.BancoCarregarDAO;
import br.com.WebBroker.dao.PagadoresDAO;
import br.com.WebBroker.domain.BancoCombo;
import br.com.WebBroker.domain.Pagadores;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBPayers")
@ViewScoped
public class PPagadoresBean {

	private Pagadores ppagadores;
	private ArrayList<Pagadores> itens;
	private ArrayList<Pagadores> itensfiltrados;
	private ArrayList<BancoCombo> comboBanco;
	
	public ArrayList<BancoCombo> getComboBanco() {
		return comboBanco;
	}
	public void setComboBanco(ArrayList<BancoCombo> comboBanco) {
		this.comboBanco = comboBanco;
	}
	public Pagadores getPpagadores() {
		return ppagadores;
	}
	public ArrayList<Pagadores> getItens() {
		return itens;
	}
	public ArrayList<Pagadores> getItensfiltrados() {
		return itensfiltrados;
	}
	public void setPpagadores(Pagadores ppagadores) {
		this.ppagadores = ppagadores;
	}
	public void setItens(ArrayList<Pagadores> itens) {
		this.itens = itens;
	}
	public void setItensfiltrados(ArrayList<Pagadores> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			PagadoresDAO dao = new PagadoresDAO();
			itens = dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro 001 - " + ex.getMessage());
		}
	}
	public void prepararNovo() {
		ppagadores = new Pagadores();
		BancoCarregarDAO dao = new BancoCarregarDAO();
		
		try {

			comboBanco = dao.listar();


		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
 
	public void excluir() {

		try {
			PagadoresDAO dao = new PagadoresDAO();
			dao.excluir(ppagadores);
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Excluido com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro Usuário 002 - "
					+ ex.getMessage());
		}

	}
	public void salvar() throws Exception {

		try {
			PagadoresDAO dao = new PagadoresDAO();
			dao.salvar(ppagadores);
			JSFUtil.adicionarMensagemSucesso("Salvo com Sucesso!");
			itens = dao.listar();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro Usuário 002 - "
					+ ex.getMessage());
		}

	}


}
