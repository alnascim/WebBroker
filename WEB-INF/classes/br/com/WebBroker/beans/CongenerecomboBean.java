package br.com.WebBroker.beans;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.CongenerecomboDAO;
import br.com.WebBroker.domain.Congenere_combo;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBCongenerecombo")
@ViewScoped
public class CongenerecomboBean {
	
	private Congenere_combo Congenere;

	private ArrayList<Congenere_combo> itens;
	private ArrayList<Congenere_combo> itensfiltrados;
		
	public Congenere_combo getCongenere() {
		return Congenere;
	}

	public void setCongenere(Congenere_combo Congenere) {
		this.Congenere = Congenere;
	}

	public Congenere_combo getCongenere_combo() {
		return Congenere;
	}

	public void setCongenere_combo(Congenere_combo Congenere) {

		this.Congenere = Congenere;
	}

	public ArrayList<Congenere_combo> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Congenere_combo> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Congenere_combo> getItensfiltrados() {
		return itensfiltrados;
	}
	
	public void setItensfiltrados(ArrayList<Congenere_combo> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			CongenerecomboDAO dao = new CongenerecomboDAO();
			itens= dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - "
					+ ex.getMessage());
		}
	}
	public void prepararNovo() {
		 
		Congenere = new Congenere_combo();
		

 
}
	
}
