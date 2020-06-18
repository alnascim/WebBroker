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

@ManagedBean(name = "MBPagadores")
@ViewScoped
public class PagadoresBean {
	
	private Pagadores Pagadores;
	private ArrayList<Pagadores> itens;
	private ArrayList<Pagadores> itensfiltrados;
	
	private ArrayList<BancoCombo> combobanco;
	
	public Pagadores getPagadores() {
		return Pagadores;
	}
	public ArrayList<Pagadores> getItens() {
		return itens;
	}
	public ArrayList<Pagadores> getItensfiltrados() {
		return itensfiltrados;
	}
	public ArrayList<BancoCombo> getCombobanco() {
		return combobanco;
	}
	public void setPagadores(Pagadores pagadores) {
		Pagadores = pagadores;
	}
	public void setItens(ArrayList<Pagadores> itens) {
		this.itens = itens;
	}
	public void setItensfiltrados(ArrayList<Pagadores> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}
	public void setCombobanco(ArrayList<BancoCombo> combobanco) {
		this.combobanco = combobanco;
	}
	@PostConstruct
	public void prepararPesquisa() {
		try {
			PagadoresDAO dao = new PagadoresDAO();
			itens= dao.listar();
			BancoCarregarDAO db = new 	BancoCarregarDAO();
			combobanco=db.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - "
					+ ex.getMessage());
		}
	}
	
	public void prepararNovo() {
		Pagadores = new Pagadores();
		BancoCarregarDAO db = new 	BancoCarregarDAO();
		try {
			combobanco=db.listar();
		} catch (SQLException ex) {
				ex.printStackTrace();
				JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}

	public void salvar()   {
		PagadoresDAO dao = new PagadoresDAO();
		try {
			
			dao.salvar(Pagadores);
			itens= dao.listar();
			JSFUtil.adicionarMensagemSucesso("Registro Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  002 - "
					+ ex.getMessage());
		}

	}
	public void excluir()  {
		PagadoresDAO dao = new PagadoresDAO();
		try {
			dao.excluir(Pagadores);
			itens= dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}		
}
