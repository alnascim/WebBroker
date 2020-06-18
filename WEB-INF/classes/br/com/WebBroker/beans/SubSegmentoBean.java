package br.com.WebBroker.beans;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.SubSegmentoDAO;
import br.com.WebBroker.domain.Produto; 
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBSubSegmento")
@ViewScoped
public class SubSegmentoBean {
	private Produto subsegmento;
	private ArrayList<Produto> itens;
	private ArrayList<Produto> itensfiltrados;

	public Produto getSubSegmento() {
		return subsegmento;
	}

	public void setSubSegmento(Produto subsegmento) {

		this.subsegmento = subsegmento;
	}

	public ArrayList<Produto> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Produto> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Produto> getItensfiltrados() {
		return itensfiltrados;
	}
	
	public void setItensfiltrados(ArrayList<Produto> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}
	@PostConstruct
	public void prepararPesquisa() {
		try {
			SubSegmentoDAO dao = new SubSegmentoDAO();
			itens= dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - "
					+ ex.getMessage());
		}
	}

	public void prepararNovo() {
		subsegmento = new Produto();
	}

	public void novo() {

		try {
			SubSegmentoDAO dao = new SubSegmentoDAO();
			dao.salvar(subsegmento);
			itens= dao.listar();
			JSFUtil.adicionarMensagemSucesso(" Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  002 - "
					+ ex.getMessage());
		}

	}

	public void excluir() {
		
		try {
			SubSegmentoDAO dao = new SubSegmentoDAO();
			dao.excluir(subsegmento);
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Removido com Sucesso!");
		}catch(SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
		}
		
	}	
	
		public void editar() {
			
			try {
				SubSegmentoDAO dao = new SubSegmentoDAO();
				dao.editar(subsegmento);
				itens = dao.listar();
				JSFUtil.adicionarMensagemSucesso(" Alterado com Sucesso!");
			}catch(SQLException ex) {
				ex.printStackTrace();
				JSFUtil.adicionarMensagemErro("Erro Usuário 003 - " + ex.getMessage());
			}
		}			
}
