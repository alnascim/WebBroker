package br.com.WebBroker.beans;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.PangariadorDAO;
import br.com.WebBroker.dao.TipopessoafisicaDAO;
import br.com.WebBroker.domain.Pangariador;
import br.com.WebBroker.domain.Tipopessoafisica;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBAngariador")
@ViewScoped
public class AngariadorBean {
	
	private Pangariador Angariador;

	private ArrayList<Pangariador> itens;
	private ArrayList<Pangariador> itensfiltrados;
	
	private Tipopessoafisica tipopessoafisica;
	private ArrayList<Tipopessoafisica> combotipos;
	
	public Pangariador getAngariador() {
		return Angariador;
	}

	public void setAngariador(Pangariador Angariador) {
		this.Angariador = Angariador;
	}

	public Pangariador getPangariador() {
		return Angariador;
	}

	public void setPangariador(Pangariador Angariador) {

		this.Angariador = Angariador;
	}

	public ArrayList<Pangariador> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Pangariador> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Pangariador> getItensfiltrados() {
		return itensfiltrados;
	}
	
	public void setItensfiltrados(ArrayList<Pangariador> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}
	
	public Tipopessoafisica getTipopessoafisica() {
		return tipopessoafisica;
	}

	public void setTipopessoafisica(Tipopessoafisica tipopessoafisica) {
		this.tipopessoafisica = tipopessoafisica;
	}

	public ArrayList<Tipopessoafisica> getCombotipos() {
		return combotipos;
	}

	public void setCombotipos(ArrayList<Tipopessoafisica> combotipos) {
		this.combotipos = combotipos;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			PangariadorDAO dao = new PangariadorDAO();
			itens= dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - "
					+ ex.getMessage());
		}
	}

	public void prepararNovo() {
		try {
			Angariador = new Pangariador();
			TipopessoafisicaDAO dao = new TipopessoafisicaDAO();
			combotipos = dao.listar();
		} catch (SQLException ex) {
				ex.printStackTrace();
				JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}

	public void novo()   {

		try {
			PangariadorDAO dao = new PangariadorDAO();
			dao.salvar(Angariador);
			itens= dao.listar();
			JSFUtil.adicionarMensagemSucesso("Registro Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  002 - "
					+ ex.getMessage());
		}

	}

	public void excluir() {
		
		try {
			PangariadorDAO dao = new PangariadorDAO();
			dao.excluir(Angariador); 
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Registro Removido com Sucesso!");
		}catch(SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
		}
		
	}	
	
		public void editar() {
			
			try {
				PangariadorDAO dao = new PangariadorDAO();
				dao.editar(Angariador);
				itens = dao.listar();
				
				JSFUtil.adicionarMensagemSucesso("Registro Alterado com Sucesso!");
			}catch(SQLException ex) {
				ex.printStackTrace();
				JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
			}
		}			
}
