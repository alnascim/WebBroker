package br.com.WebBroker.beans;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.CongenerecomboDAO;
import br.com.WebBroker.dao.ProdutoDAO;
import br.com.WebBroker.domain.Congenere_combo;
import br.com.WebBroker.domain.Produto; 
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {
	private Produto produto;
	private ArrayList<Produto> itens;
	private ArrayList<Produto> itensfiltrados;
	private ArrayList<Congenere_combo> comboCongenere;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {

		this.produto = produto;
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
	public ArrayList<Congenere_combo> getComboCongenere() {
		return comboCongenere;
	}

	public void setComboCongenere(ArrayList<Congenere_combo> comboCongenere) {
		this.comboCongenere = comboCongenere;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			itens= dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - "
					+ ex.getMessage());
		}
	}

	public void prepararNovo() {
		produto = new Produto();
		CongenerecomboDAO dao7 = new CongenerecomboDAO();

		try {
			
			comboCongenere=dao7.listar();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}		
	}
	public void prepararEditar() {
		produto = new Produto();
		CongenerecomboDAO dao7 = new CongenerecomboDAO();

		try {
			
			comboCongenere=dao7.listar();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}		
	}
	public void novo() {
		 
		CongenerecomboDAO dao7 = new CongenerecomboDAO();

		try {
			ProdutoDAO dao = new ProdutoDAO();
			comboCongenere=dao7.listar();
			dao.salvar(produto);
			itens= dao.listar();
			JSFUtil.adicionarMensagemSucesso(" Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  002 - "
					+ ex.getMessage());
		}

	}

	public void excluir() {
		CongenerecomboDAO dao7 = new CongenerecomboDAO();
		try {
			ProdutoDAO dao = new ProdutoDAO();
			comboCongenere=dao7.listar();
			dao.excluir(produto);
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Removido com Sucesso!");
		}catch(SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
		}
		
	}	
	
		public void editar() {
			CongenerecomboDAO dao7 = new CongenerecomboDAO();
			try {
				comboCongenere=dao7.listar();
				ProdutoDAO dao = new ProdutoDAO();
				
				dao.editar(produto);
				itens = dao.listar();
				JSFUtil.adicionarMensagemSucesso(" Alterado com Sucesso!");
			}catch(SQLException ex) {
				ex.printStackTrace();
				JSFUtil.adicionarMensagemErro("Erro Usuário 003 - " + ex.getMessage());
			}
		}			
}
