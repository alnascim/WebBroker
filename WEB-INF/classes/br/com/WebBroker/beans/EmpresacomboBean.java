package br.com.WebBroker.beans;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.EmpresacomboDAO;
import br.com.WebBroker.domain.Empresa_combo;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBEmpresacombo")
@ViewScoped
public class EmpresacomboBean {
	
	private Empresa_combo Empresa;

	private ArrayList<Empresa_combo> itens;
	private ArrayList<Empresa_combo> itensfiltrados;
		
	public Empresa_combo getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(Empresa_combo Empresa) {
		this.Empresa = Empresa;
	}

	public Empresa_combo getEmpresa_combo() {
		return Empresa;
	}

	public void setEmpresa_combo(Empresa_combo Empresa) {

		this.Empresa = Empresa;
	}

	public ArrayList<Empresa_combo> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Empresa_combo> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Empresa_combo> getItensfiltrados() {
		return itensfiltrados;
	}
	
	public void setItensfiltrados(ArrayList<Empresa_combo> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			EmpresacomboDAO dao = new EmpresacomboDAO();
			itens= dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - "
					+ ex.getMessage());
		}
	}
	public void prepararNovo() {
		 
		Empresa = new Empresa_combo();
		

 
}
	
}
