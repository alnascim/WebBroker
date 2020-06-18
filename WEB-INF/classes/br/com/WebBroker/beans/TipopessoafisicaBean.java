package br.com.WebBroker.beans;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import br.com.WebBroker.dao.TipopessoafisicaDAO;
import br.com.WebBroker.domain.Tipopessoafisica;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBTipopessoa")
@ViewScoped
public class TipopessoafisicaBean {
	
	private Tipopessoafisica tipopessoafisica;
	
	private ArrayList<Tipopessoafisica> itens;
	private ArrayList<Tipopessoafisica> itensfiltrados;

	public Tipopessoafisica getTipopessoafisica() {
		return tipopessoafisica;
	}

	public void setTipopessoafisica(Tipopessoafisica tipopessoafisica) {

		this.tipopessoafisica = tipopessoafisica;
	}

	public ArrayList<Tipopessoafisica> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Tipopessoafisica> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Tipopessoafisica> getItensfiltrados() {
		return itensfiltrados;
	}
	
	public void setItensfiltrados(ArrayList<Tipopessoafisica> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}
	@PostConstruct
	public void prepararPesquisa() {
		try {
			TipopessoafisicaDAO dao = new TipopessoafisicaDAO();
			itens= dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - "
					+ ex.getMessage());
		}
	}

	public void prepararNovo() {
		tipopessoafisica = new Tipopessoafisica();
	}

	public void novo() {

		try {
			TipopessoafisicaDAO dao = new TipopessoafisicaDAO();
			dao.salvar(tipopessoafisica);
			itens= dao.listar();
			JSFUtil.adicionarMensagemSucesso("Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro 002 - "
					+ ex.getMessage());
		}

	}

	public void excluir() {
		
		try {
			TipopessoafisicaDAO dao = new TipopessoafisicaDAO();
			dao.excluir(tipopessoafisica);
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Removido com Sucesso!");
		}catch(SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro 003 - " + ex.getMessage());
		}
		
	}	
	
		public void editar() {
			
			try {
				TipopessoafisicaDAO dao = new TipopessoafisicaDAO();
				dao.editar(tipopessoafisica);
				itens = dao.listar();
				JSFUtil.adicionarMensagemSucesso("Alterado com Sucesso!");
			}catch(SQLException ex) {
				ex.printStackTrace();
				JSFUtil.adicionarMensagemErro("Erro 003 - " + ex.getMessage());
			}
		}			
}
