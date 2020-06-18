package br.com.WebBroker.beans;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.AngariadorcomboDAO;
import br.com.WebBroker.domain.Angariador_combo;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBAngariadorcombo")
@ViewScoped
public class AngariadorcomboBean {
	
	private Angariador_combo Angariador;

	private ArrayList<Angariador_combo> itens;
	private ArrayList<Angariador_combo> itensfiltrados;
		
	public Angariador_combo getAngariador() {
		return Angariador;
	}

	public void setAngariador(Angariador_combo Angariador) {
		this.Angariador = Angariador;
	}

	public Angariador_combo getAngariador_combo() {
		return Angariador;
	}

	public void setAngariador_combo(Angariador_combo Angariador) {

		this.Angariador = Angariador;
	}

	public ArrayList<Angariador_combo> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Angariador_combo> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Angariador_combo> getItensfiltrados() {
		return itensfiltrados;
	}
	
	public void setItensfiltrados(ArrayList<Angariador_combo> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			AngariadorcomboDAO dao = new AngariadorcomboDAO();
			itens= dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - "
					+ ex.getMessage());
		}
	}

	public void prepararNovo() {
 
			Angariador = new Angariador_combo();
			

	 
	}
	
}
