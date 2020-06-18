package br.com.WebBroker.beans;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.NcociacomboDAO;
import br.com.WebBroker.domain.Ncocia_combo;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBNcociacombo")
@ViewScoped
public class NcociacomboBean {
	
	private Ncocia_combo Ncocia;

	private ArrayList<Ncocia_combo> itens;
	private ArrayList<Ncocia_combo> itensfiltrados;
		
	public Ncocia_combo getNcocia() {
		return Ncocia;
	}

	public void setNcocia(Ncocia_combo Ncocia) {
		this.Ncocia = Ncocia;
	}

	public Ncocia_combo getNcocia_combo() {
		return Ncocia;
	}

	public void setNcocia_combo(Ncocia_combo Ncocia) {

		this.Ncocia = Ncocia;
	}

	public ArrayList<Ncocia_combo> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Ncocia_combo> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Ncocia_combo> getItensfiltrados() {
		return itensfiltrados;
	}
	
	public void setItensfiltrados(ArrayList<Ncocia_combo> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			NcociacomboDAO dao = new NcociacomboDAO();
			itens= dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - "
					+ ex.getMessage());
		}
	}
	public void prepararNovo() {
		 
		Ncocia = new Ncocia_combo();
		

 
}
	
}
