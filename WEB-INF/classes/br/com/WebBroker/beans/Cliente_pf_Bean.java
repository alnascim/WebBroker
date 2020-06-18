package br.com.WebBroker.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.EmpresacomboDAO;
import br.com.WebBroker.dao.EstadocivilDAO;
import br.com.WebBroker.dao.ListaDependenteDAO;
import br.com.WebBroker.dao.ParentescoDAO;
import br.com.WebBroker.dao.PCliente_pfDAO;
import br.com.WebBroker.dao.ProfissaoDAO;
import br.com.WebBroker.domain.Empresa_combo;
import br.com.WebBroker.domain.Estadocivil;
import br.com.WebBroker.domain.Parentesco;
import br.com.WebBroker.domain.Pdepend;
import br.com.WebBroker.domain.Pfisica;
import br.com.WebBroker.domain.Profissao;
import br.com.WebBroker.domain.Tipopessoafisica;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBClientePF")
@ViewScoped
public class Cliente_pf_Bean {

	private Pfisica Fisica;
	private ArrayList<Pfisica> itens;
	private ArrayList<Pfisica> itensfiltrados;
	private ArrayList<Pdepend> itensdepend;

	private Tipopessoafisica tipopessoafisica;
	private ArrayList<Tipopessoafisica> combotipos;

	private ArrayList<Parentesco> comboParentesco;
	private ArrayList<Profissao> comboProfissao;
	private ArrayList<Estadocivil> comboEstadocivils;
	private ArrayList<Empresa_combo> comboEmpresa;

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

	public ArrayList<Pfisica> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Pfisica> itens) {
		this.itens = itens;
	}

	public ArrayList<Pfisica> getItensfiltrados() {
		return itensfiltrados;
	}

	public void setItensfiltrados(ArrayList<Pfisica> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}

	public ArrayList<Empresa_combo> getComboEmpresa() {
		return comboEmpresa;
	}

	public void setComboEmpresa(ArrayList<Empresa_combo> comboEmpresa) {
		this.comboEmpresa = comboEmpresa;
	}

	public ArrayList<Parentesco> getComboParentesco() {
		return comboParentesco;
	}

	public void setComboParentesco(ArrayList<Parentesco> comboParentesco) {
		this.comboParentesco = comboParentesco;
	}

	public ArrayList<Profissao> getComboProfissao() {
		return comboProfissao;
	}

	public void setComboProfissao(ArrayList<Profissao> comboProfissao) {
		this.comboProfissao = comboProfissao;
	}

	public ArrayList<Estadocivil> getComboEstadocivils() {
		return comboEstadocivils;
	}

	public void setComboEstadocivil(ArrayList<Estadocivil> comboEstadocivils) {
		this.comboEstadocivils = comboEstadocivils;
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

	public ArrayList<Pdepend> getItensdepend() {
		return itensdepend;
	}

	public void setItensdepend(ArrayList<Pdepend> itensdepend) {
		this.itensdepend = itensdepend;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			PCliente_pfDAO dao = new PCliente_pfDAO();
			itens = dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - " + ex.getMessage());
		}
	}

	public void localizar() {

		PCliente_pfDAO dao = new PCliente_pfDAO();

		try {
			dao.localizar(Fisica);
		} catch (SQLException e) {

			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	public void verifycpf() {

		PCliente_pfDAO dao = new PCliente_pfDAO();

		try {
			dao.verifycpf(Fisica);
		} catch (SQLException e) {

			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void prepararNovo() {
		Fisica = new Pfisica();

		EmpresacomboDAO dao = new EmpresacomboDAO();
		ParentescoDAO dao1 = new ParentescoDAO();
		ProfissaoDAO dao2 = new ProfissaoDAO();
		EstadocivilDAO dao3 = new EstadocivilDAO();

		try {

			comboEmpresa = dao.listar();
			comboParentesco = dao1.listar();
			comboProfissao = dao2.listar();
			comboEstadocivils = dao3.listar();

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}

	public void prepararListar() {
		ListaDependenteDAO dao4 = new ListaDependenteDAO();
		try {
			itensdepend = dao4.buscaDepend(Fisica);
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}

	public void prepararEditar() {
		EmpresacomboDAO dao = new EmpresacomboDAO();
		ParentescoDAO dao1 = new ParentescoDAO();
		ProfissaoDAO dao2 = new ProfissaoDAO();
		EstadocivilDAO dao3 = new EstadocivilDAO();
		try {
			comboEmpresa = dao.listar();
			comboParentesco = dao1.listar();
			comboProfissao = dao2.listar();
			comboEstadocivils = dao3.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}

	public void novo() {

		try {
			PCliente_pfDAO dao = new PCliente_pfDAO();
			EmpresacomboDAO edao = new EmpresacomboDAO();
			ParentescoDAO dao1 = new ParentescoDAO();
			ProfissaoDAO dao2 = new ProfissaoDAO();
			EstadocivilDAO dao3 = new EstadocivilDAO();

			dao.salvar(Fisica);
			itens = dao.listar();
			comboEmpresa = edao.listar();
			comboParentesco = dao1.listar();
			comboProfissao = dao2.listar();
			comboEstadocivils = dao3.listar();

			JSFUtil.adicionarMensagemSucesso("Registro Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  002 - " + ex.getMessage());
		}

	}

	public void excluir() {

		try {
			PCliente_pfDAO dao = new PCliente_pfDAO();
			EmpresacomboDAO edao = new EmpresacomboDAO();

			ParentescoDAO dao1 = new ParentescoDAO();
			ProfissaoDAO dao2 = new ProfissaoDAO();
			EstadocivilDAO dao3 = new EstadocivilDAO();

			dao.excluir(Fisica);
			itens = dao.listar();
			comboEmpresa = edao.listar();
			comboParentesco = dao1.listar();
			comboProfissao = dao2.listar();
			comboEstadocivils = dao3.listar();

			JSFUtil.adicionarMensagemSucesso("Registro Removido com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
		}

	}

	public void editar() {

		try {
			EmpresacomboDAO edao = new EmpresacomboDAO();
			ParentescoDAO dao1 = new ParentescoDAO();
			ProfissaoDAO dao2 = new ProfissaoDAO();
			EstadocivilDAO dao3 = new EstadocivilDAO();

			PCliente_pfDAO dao = new PCliente_pfDAO();
			dao.editar(Fisica);
			itens = dao.listar();
			comboEmpresa = edao.listar();
			comboParentesco = dao1.listar();
			comboProfissao = dao2.listar();
			comboEstadocivils = dao3.listar();

			JSFUtil.adicionarMensagemSucesso("Registro Alterado com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
		}
	}

}
