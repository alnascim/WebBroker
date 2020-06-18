package br.com.WebBroker.beans;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import br.com.WebBroker.dao.ProfissaoDAO;
import br.com.WebBroker.domain.Profissao;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBProfissao")
@ViewScoped
public class ProfissaoBean {
	
	private Profissao profissao;
	
	private ArrayList<Profissao> itens;
	private ArrayList<Profissao> itensfiltrados;

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {

		this.profissao = profissao;
	}

	public ArrayList<Profissao> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Profissao> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Profissao> getItensfiltrados() {
		return itensfiltrados;
	}
	
	public void setItensfiltrados(ArrayList<Profissao> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}
	@PostConstruct
	public void prepararPesquisa() {
		try {
			ProfissaoDAO dao = new ProfissaoDAO();
			itens= dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro 001 - "
					+ ex.getMessage());
		}
	}

	public void prepararNovo() {
		profissao = new Profissao();
	}

	public void novo() {

		try {
			ProfissaoDAO dao = new ProfissaoDAO();
			dao.salvar(profissao);
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
			ProfissaoDAO dao = new ProfissaoDAO();
			dao.excluir(profissao);
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Removido com Sucesso!");
		}catch(SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro Usuário 003 - " + ex.getMessage());
		}
		
	}	
	
		public void editar() {
			
			try {
				ProfissaoDAO dao = new ProfissaoDAO();
				dao.editar(profissao);
				itens = dao.listar();
				JSFUtil.adicionarMensagemSucesso("Alterado com Sucesso!");
			}catch(SQLException ex) {
				ex.printStackTrace();
				JSFUtil.adicionarMensagemErro("Erro Usuário 003 - " + ex.getMessage());
			}
		}			
}
