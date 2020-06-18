package br.com.WebBroker.beans;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.ListaDependenteDAO;
import br.com.WebBroker.domain.ListaDependente_combo;
import br.com.WebBroker.domain.Pdepend;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBListaDependente")
@ViewScoped
public class ListaDependentecomboBean {
	
	private ListaDependente_combo Dependente;
	private ArrayList<Pdepend> itens;
	private ArrayList<Pdepend> itensfiltrados;
		 

	public ListaDependente_combo getDependente() {
		return Dependente;
	}


	public void setDependente(ListaDependente_combo dependente) {
		Dependente = dependente;
	}


	public ArrayList<Pdepend> getItens() {
		return itens;
	}


	public void setItens(ArrayList<Pdepend> itens) {
		this.itens = itens;
	}


	public ArrayList<Pdepend> getItensfiltrados() {
		return itensfiltrados;
	}


	public void setItensfiltrados(ArrayList<Pdepend> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}
//
//
//	@PostConstruct
//	public void prepararPesquisa() {
//		try {
//			ListaDependenteDAO dao = new ListaDependenteDAO();
////			itens= dao.buscaDepend(8);
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			JSFUtil.adicionarMensagemErro("Erro  001 - "
//					+ ex.getMessage());
//		}
//	}
//	
}
