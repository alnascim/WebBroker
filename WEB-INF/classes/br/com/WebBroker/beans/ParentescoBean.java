package br.com.WebBroker.beans;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import br.com.WebBroker.dao.ParentescoDAO;
import br.com.WebBroker.domain.Parentesco;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBParent")
@ViewScoped
public class ParentescoBean {
	
	private Parentesco parentesco;
	
	private ArrayList<Parentesco> itens;
	private ArrayList<Parentesco> itensfiltrados;

	public Parentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(Parentesco parentesco) {

		this.parentesco = parentesco;
	}

	public ArrayList<Parentesco> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Parentesco> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Parentesco> getItensfiltrados() {
		return itensfiltrados;
	}
	
	public void setItensfiltrados(ArrayList<Parentesco> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}
	@PostConstruct
	public void prepararPesquisa() {
		try {
			ParentescoDAO dao = new ParentescoDAO();
			itens= dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro 001 - "
					+ ex.getMessage());
		}
	}

	public void prepararNovo() {
		parentesco = new Parentesco();
	}

	public void novo() {

		try {
			ParentescoDAO dao = new ParentescoDAO();
			dao.salvar(parentesco);
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
			ParentescoDAO dao = new ParentescoDAO();
			dao.excluir(parentesco);
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Removido com Sucesso!");
		}catch(SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro Usuário 003 - " + ex.getMessage());
		}
		
	}	
	
		public void editar() {
			
			try {
				ParentescoDAO dao = new ParentescoDAO();
				dao.editar(parentesco);
				itens = dao.listar();
				JSFUtil.adicionarMensagemSucesso("Alterado com Sucesso!");
			}catch(SQLException ex) {
				ex.printStackTrace();
				JSFUtil.adicionarMensagemErro("Erro Usuário 003 - " + ex.getMessage());
			}
		}			
}
