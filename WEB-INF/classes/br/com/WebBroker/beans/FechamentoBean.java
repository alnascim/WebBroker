package br.com.WebBroker.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.PFechamentoDAO;
import br.com.WebBroker.domain.ListaComissao;
import br.com.WebBroker.domain.PFechamento;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBFechaMes")
@ViewScoped
public class FechamentoBean {

	private PFechamento pfechamento;
	private ArrayList<PFechamento> itens;
	private ArrayList<PFechamento> itensfiltrados;
	private ArrayList<ListaComissao> itens1;
	private ArrayList<ListaComissao> itensfiltrados1;
	
	public ArrayList<ListaComissao> getItens1() {
		return itens1;
	}
	public ArrayList<ListaComissao> getItensfiltrados1() {
		return itensfiltrados1;
	}
	public void setItens1(ArrayList<ListaComissao> itens1) {
		this.itens1 = itens1;
	}
	public void setItensfiltrados1(ArrayList<ListaComissao> itensfiltrados1) {
		this.itensfiltrados1 = itensfiltrados1;
	}
	
	public PFechamento getPFechamento() {
		return pfechamento;
	}
	public void setPFechamento(PFechamento pfechamento) {
		this.pfechamento = pfechamento;
	}

	public ArrayList<PFechamento> getItens() {
		return itens;
	}

	public void setItens(ArrayList<PFechamento> itens) {
		this.itens = itens;
	}

	public ArrayList<PFechamento> getItensfiltrados() {
		return itensfiltrados;
	}

	public void setItensfiltrados(ArrayList<PFechamento> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			PFechamentoDAO dao = new PFechamentoDAO();
			itens = dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro 001 - " + ex.getMessage());
		}
	}
	public void prepararNovo() {
		pfechamento = new PFechamento();
		PFechamentoDAO dao = new PFechamentoDAO();
		try {
			dao.recuperar(pfechamento);			
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro Usuário 002 - "
					+ ex.getMessage());
		}
	}
	public void reabrir() {

		try {
			PFechamentoDAO dao = new PFechamentoDAO();
			dao.reabrir(pfechamento);
			dao.processar_reabertura(pfechamento);
			dao.excluir(pfechamento);
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Excluido com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro Usuário 002 - "
					+ ex.getMessage());
		}

	}
	public void excluir() {

		try {
			PFechamentoDAO dao = new PFechamentoDAO();
			dao.excluir(pfechamento);
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
			PFechamentoDAO dao = new PFechamentoDAO();
			dao.salvar(pfechamento);
			dao.processar_fechamento(pfechamento);

			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro Usuário 002 - "
					+ ex.getMessage());
		}

	}
	public void call_rpt() throws Exception {

		PFechamentoDAO dao = new PFechamentoDAO();
		dao.call_report(pfechamento);
	}

}
