package br.com.WebBroker.beans;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.TitularcomboDAO;
import br.com.WebBroker.domain.Titular_combo;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBTitularcombo")
@ViewScoped
public class TitularcomboBean {
	
	private Titular_combo Titular;

	private ArrayList<Titular_combo> itens;
	private ArrayList<Titular_combo> itensfiltrados;
		
	public Titular_combo getTitular() {
		return Titular;
	}

	public void setTitular(Titular_combo Titular) {
		this.Titular = Titular;
	}

	public Titular_combo getTitular_combo() {
		return Titular;
	}

	public void setTitular_combo(Titular_combo Titular) {

		this.Titular = Titular;
	}

	public ArrayList<Titular_combo> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Titular_combo> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Titular_combo> getItensfiltrados() {
		return itensfiltrados;
	}
	
	public void setItensfiltrados(ArrayList<Titular_combo> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			TitularcomboDAO dao = new TitularcomboDAO();
			itens= dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - "
					+ ex.getMessage());
		}
	}
	public void prepararNovo() {
		 
		Titular = new Titular_combo();
		

 
}
	
}
