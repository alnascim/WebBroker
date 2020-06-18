package br.com.WebBroker.beans;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import br.com.WebBroker.dao.PagenciaDAO;
import br.com.WebBroker.domain.Pagencia;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBAgencia")
@ViewScoped
public class AgenciaBean {
	
	private Pagencia pagencia;
	
	private ArrayList<Pagencia> itens;
	private ArrayList<Pagencia> itensfiltrados;

	public Pagencia getPagencia() {
		return pagencia;
	}

	public void setPagencia(Pagencia pagencia) {

		this.pagencia = pagencia;
	}

	public ArrayList<Pagencia> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Pagencia> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Pagencia> getItensfiltrados() {
		return itensfiltrados;
	}
	
	public void setItensfiltrados(ArrayList<Pagencia> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}
	@PostConstruct
	public void prepararPesquisa() {
		try {
			PagenciaDAO dao = new PagenciaDAO();
			itens= dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro 001 - "
					+ ex.getMessage());
		}
	}

	public void prepararNovo() {
		pagencia = new Pagencia();
	}

	public void novo() {

		try {
			PagenciaDAO dao = new PagenciaDAO();
			dao.salvar(pagencia);
			itens= dao.listar();
			JSFUtil.adicionarMensagemSucesso("Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro Usuário 002 - "
					+ ex.getMessage());
		}

	}

	public void excluir() {
		
		try {
			PagenciaDAO dao = new PagenciaDAO();
			dao.excluir(pagencia);
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Removido com Sucesso!");
		}catch(SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro Usuário 003 - " + ex.getMessage());
		}
		
	}	
	
		public void editar() {
			
			try {
				PagenciaDAO dao = new PagenciaDAO();
				dao.editar(pagencia);
				itens = dao.listar();
				JSFUtil.adicionarMensagemSucesso("Alterado com Sucesso!");
			}catch(SQLException ex) {
				ex.printStackTrace();
				JSFUtil.adicionarMensagemErro("Erro Usuário 003 - " + ex.getMessage());
			}
		}			
}
