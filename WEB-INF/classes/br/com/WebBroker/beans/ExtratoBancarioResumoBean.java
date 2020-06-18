package br.com.WebBroker.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.ExtratoBancarioDAO;
import br.com.WebBroker.domain.ExtratoBancario;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBExtratoBancarioResumo")
@ViewScoped
public class ExtratoBancarioResumoBean {

	private ExtratoBancario Extrato;
	private ArrayList<ExtratoBancario> itens;
	private ArrayList<ExtratoBancario> itensfiltrados;
	
	public ExtratoBancario getExtrato() {
		return Extrato;
	}
	public ArrayList<ExtratoBancario> getItens() {
		return itens;
	}
	public ArrayList<ExtratoBancario> getItensfiltrados() {
		return itensfiltrados;
	}
	public void setExtrato(ExtratoBancario extrato) {
		Extrato = extrato;
	}
	public void setItens(ArrayList<ExtratoBancario> itens) {
		this.itens = itens;
	}
	public void setItensfiltrados(ArrayList<ExtratoBancario> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}
	@PostConstruct
	public void prepararListar() {
		ExtratoBancarioDAO dao = new ExtratoBancarioDAO();
		try {
			itens = dao.listar_resumo_data();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}

}
