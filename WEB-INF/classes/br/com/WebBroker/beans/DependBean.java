package br.com.WebBroker.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.PdependDAO;
import br.com.WebBroker.dao.TipopessoafisicaDAO;
import br.com.WebBroker.domain.Pdepend;
import br.com.WebBroker.domain.Pfisica;
import br.com.WebBroker.domain.Tipopessoafisica;
import br.com.WebBroker.util.JSFUtil;
import br.com.WebBroker.dao.TitularcomboDAO;
import br.com.WebBroker.domain.Titular_combo;

@ManagedBean(name = "MBDepend")
@ViewScoped
public class DependBean {

	private Pdepend Depend;
	private Pfisica Fisica;
	
	private ArrayList<Pdepend> itens;
	private ArrayList<Pdepend> itensfiltrados;

	private Tipopessoafisica tipopessoafisica;
	private ArrayList<Tipopessoafisica> combotipos;
	private ArrayList<Titular_combo> comboTitular;
	
	public Pfisica getFisica() {
		return Fisica;
	}
	public void setFisica(Pfisica Fisica) {
		this.Fisica = Fisica;
	}
	public Pfisica getPfisica() {
		return Fisica;
	}
	public void setPfisica(Pfisica Fisica) {

		this.Fisica = Fisica;
	}
	public Pdepend getDepend() {
		return Depend;
	}
	public void setDepend(Pdepend Depend) {
		this.Depend = Depend;
	}
	public Pdepend getPdepend() {
		return Depend;
	}
	public void setPdepend(Pdepend Depend) {
		this.Depend = Depend;
	}
	public ArrayList<Pdepend> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Pdepend> itens) {
		this.itens = itens;
	}
	public ArrayList<Pdepend> getItensfiltrados() {
		return itensfiltrados;
	}
	public void setItensfiltrados(ArrayList<Pdepend> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}

	public ArrayList<Titular_combo> getComboTitular() {
		return comboTitular;
	}

	public void setComboTitular(ArrayList<Titular_combo> comboTitular) {
		this.comboTitular = comboTitular;
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
		Depend = new Pdepend();
		try {
			PdependDAO dao = new PdependDAO();
			itens = dao.listar();

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - " + ex.getMessage());
		}
	}

	public void prepararNovo() {
		TipopessoafisicaDAO dao = new TipopessoafisicaDAO();
		TitularcomboDAO tdao = new TitularcomboDAO();

		try {

			Depend = new Pdepend();
				
			combotipos = dao.listar();
			comboTitular = tdao.listar();

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}

	public void novo() {
		TitularcomboDAO tdao = new TitularcomboDAO();
		PdependDAO dao = new PdependDAO();
		try {
			dao.salvar(Depend);
			itens = dao.listar();
			comboTitular = tdao.listar();
			JSFUtil.adicionarMensagemSucesso("Registro Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  002 - " + ex.getMessage());
		}

	}

	public void novo_d() {

		try {
			PdependDAO dao = new PdependDAO();
			dao.salvar_d(Depend);
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Registro Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  002 - " + ex.getMessage());
		}

	}

	public void novo_1() {

		PdependDAO daof = new PdependDAO();

		try {
			daof.salvar_1(Depend);

			JSFUtil.adicionarMensagemSucesso("Registro Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  002 - " + ex.getMessage());
		}

	}

	public void excluir() {

		try {
			PdependDAO dao = new PdependDAO();
			dao.excluir(Depend);
			itens = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Registro Removido com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
		}

	}

	public void editar() {

		try {
			PdependDAO dao = new PdependDAO();
			dao.editar(Depend);
			itens = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Registro Alterado com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
		}
	}

}
