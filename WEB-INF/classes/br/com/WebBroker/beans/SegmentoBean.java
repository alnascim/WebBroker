package br.com.WebBroker.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.CongenerecomboDAO;
import br.com.WebBroker.dao.NcociacomboDAO;
import br.com.WebBroker.dao.SegmentoDAO;
import br.com.WebBroker.domain.Congenere_combo;
import br.com.WebBroker.domain.Ncocia_combo;
import br.com.WebBroker.domain.Produto;
import br.com.WebBroker.domain.Segmento;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBSegmento")
@ViewScoped
public class SegmentoBean {

	private Segmento segmento;
	private ArrayList<Segmento> itens;
	private ArrayList<Segmento> itensfiltrados;
	private ArrayList<Congenere_combo> comboCongenere;
	private ArrayList<Ncocia_combo> comboncocia;
	private ArrayList<Produto> comboproduto;

	public ArrayList<Produto> getComboproduto() {
		return comboproduto;
	}

	public void setComboproduto(ArrayList<Produto> comboproduto) {
		this.comboproduto = comboproduto;
	}

	public Segmento getSegmento() {
		return segmento;
	}

	public void setSegmento(Segmento segmento) {

		this.segmento = segmento;
	}

	public ArrayList<Segmento> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Segmento> itens) {
		this.itens = itens;
	}

	public ArrayList<Segmento> getItensfiltrados() {
		return itensfiltrados;
	}

	public void setItensfiltrados(ArrayList<Segmento> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}

	public ArrayList<Congenere_combo> getComboCongenere() {
		return comboCongenere;
	}

	public void setComboCongenere(ArrayList<Congenere_combo> comboCongenere) {
		this.comboCongenere = comboCongenere;
	}

	public ArrayList<Ncocia_combo> getComboncocia() {
		return comboncocia;
	}

	public void setComboncocia(ArrayList<Ncocia_combo> comboncocia) {
		this.comboncocia = comboncocia;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			SegmentoDAO dao = new SegmentoDAO();
			itens = dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - " + ex.getMessage());
		}
	}

	public void prepararNovo() {
		segmento = new Segmento();
		CongenerecomboDAO dao7 = new CongenerecomboDAO();
		NcociacomboDAO dao8 = new NcociacomboDAO();
		SegmentoDAO dao = new SegmentoDAO();
		try {
			comboCongenere = dao7.listar();
			comboncocia = dao8.listar();
			comboproduto = dao.listarproduto();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}

	public void novo() {
		CongenerecomboDAO dao7 = new CongenerecomboDAO();
		NcociacomboDAO dao8 = new NcociacomboDAO();
		SegmentoDAO dao = new SegmentoDAO();
		try {
			dao.salvar(segmento);
			comboCongenere = dao7.listar();
			comboncocia = dao8.listar();
			comboproduto = dao.listarproduto();
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso(" Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  002 - " + ex.getMessage());
		}

	}

	public void excluir() {
		CongenerecomboDAO dao7 = new CongenerecomboDAO();
		NcociacomboDAO dao8 = new NcociacomboDAO();
		SegmentoDAO dao = new SegmentoDAO();
		try {
			dao.excluir(segmento);
			itens = dao.listar();
			comboCongenere = dao7.listar();
			comboncocia = dao8.listar();
			comboproduto = dao.listarproduto();

			JSFUtil.adicionarMensagemSucesso("Removido com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
		}

	}

	public void editar() {
		CongenerecomboDAO dao7 = new CongenerecomboDAO();
		NcociacomboDAO dao8 = new NcociacomboDAO();
		SegmentoDAO dao = new SegmentoDAO();
		try {

			dao.editar(segmento);
			comboCongenere = dao7.listar();
			comboncocia = dao8.listar();
			comboproduto = dao.listarproduto();
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso(" Alterado com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro Usuário 003 - "
					+ ex.getMessage());
		}
	}
}
