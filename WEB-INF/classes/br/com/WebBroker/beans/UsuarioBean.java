package br.com.WebBroker.beans;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import br.com.WebBroker.dao.UserDAO;
import br.com.WebBroker.domain.Usuario;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBUsuario")
@ViewScoped
public class UsuarioBean {
	private Usuario usuario;
	private ArrayList<Usuario> itens;
	private ArrayList<Usuario> itensfiltrados;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {

		this.usuario = usuario;
	}

	public ArrayList<Usuario> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Usuario> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Usuario> getItensfiltrados() {
		return itensfiltrados;
	}
	
	public void setItensfiltrados(ArrayList<Usuario> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}
	@PostConstruct
	public void prepararPesquisa() {
		try {
			UserDAO dao = new UserDAO();
			itens= dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro Usuário 001 - "
					+ ex.getMessage());
		}
	}

	public void prepararNovo() {
		usuario = new Usuario();
	}

	public void novo() {

		try {
			UserDAO dao = new UserDAO();
			dao.salvar(usuario);
			itens= dao.listar();
			JSFUtil.adicionarMensagemSucesso("Usuário Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro Usuário 002 - "
					+ ex.getMessage());
		}

	}

	public void excluir() {
		
		try {
			UserDAO dao = new UserDAO();
			dao.excluir(usuario);
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Usuário Removido com Sucesso!");
		}catch(SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro Usuário 003 - " + ex.getMessage());
		}
		
	}	
	
		public void editar() {
			
			try {
				UserDAO dao = new UserDAO();
				dao.editar(usuario);
				itens = dao.listar();
				JSFUtil.adicionarMensagemSucesso("Usuário Alterado com Sucesso!");
			}catch(SQLException ex) {
				ex.printStackTrace();
				JSFUtil.adicionarMensagemErro("Erro Usuário 003 - " + ex.getMessage());
			}
		}			
}
