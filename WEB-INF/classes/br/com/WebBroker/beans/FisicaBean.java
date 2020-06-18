package br.com.WebBroker.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.CongenerecomboDAO;
import br.com.WebBroker.dao.EmpresacomboDAO;
import br.com.WebBroker.dao.EstadocivilDAO;
import br.com.WebBroker.dao.ListaDependenteDAO;
import br.com.WebBroker.dao.PapoliceDAO;
import br.com.WebBroker.dao.ParentescoDAO;
import br.com.WebBroker.dao.PfisicaDAO;
import br.com.WebBroker.dao.ProfissaoDAO;
import br.com.WebBroker.domain.Beneficios;
import br.com.WebBroker.domain.Congenere_combo;
import br.com.WebBroker.domain.Empresa_combo;
import br.com.WebBroker.domain.Estadocivil;
import br.com.WebBroker.domain.Papolice;
import br.com.WebBroker.domain.Parentesco;
import br.com.WebBroker.domain.Pdepend;
import br.com.WebBroker.domain.Pfisica;
import br.com.WebBroker.domain.Profissao;
import br.com.WebBroker.domain.Segmento;
import br.com.WebBroker.domain.Tipopessoafisica;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBFisica")
@ViewScoped
public class FisicaBean {
	private Pdepend Depend;
	private Pfisica Fisica;
	private Beneficios beneficios;

	private ArrayList<Pfisica> itens;
	private ArrayList<Pfisica> itensfiltrados;
	private ArrayList<Pdepend> itensdepend;
	private ArrayList<Beneficios> itensbeneficios;
	private Tipopessoafisica tipopessoafisica;
	private ArrayList<Tipopessoafisica> combotipos;

	private ArrayList<Parentesco> comboParentesco;
	private ArrayList<Profissao> comboProfissao;
	private ArrayList<Estadocivil> comboEstadocivils;
	private ArrayList<Empresa_combo> comboEmpresa;
	private ArrayList<Segmento> comboSegmento;
	private ArrayList<Congenere_combo> comboCongenere;
	private ArrayList<Segmento> comboApolice;
	private ArrayList<Papolice> comboApolices;

	public boolean ret;

	public ArrayList<Papolice> getComboApolices() {
		return comboApolices;
	}

	public void setComboApolices(ArrayList<Papolice> comboApolices) {
		this.comboApolices = comboApolices;
	}

	public Pdepend getDepend() {
		return Depend;
	}

	public void setDepend(Pdepend depend) {
		Depend = depend;
	}

	public Beneficios getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(Beneficios beneficios) {
		this.beneficios = beneficios;
	}

	public ArrayList<Beneficios> getItensbeneficios() {
		return itensbeneficios;
	}

	public void setItensbeneficios(ArrayList<Beneficios> itensbeneficios) {
		this.itensbeneficios = itensbeneficios;
	}

	public ArrayList<Segmento> getComboApolice() {
		return comboApolice;
	}

	public void setComboApolice(ArrayList<Segmento> comboApolice) {
		this.comboApolice = comboApolice;
	}

	private boolean showNewButton = true;

	public ArrayList<Congenere_combo> getComboCongenere() {
		return comboCongenere;
	}

	public void setComboCongenere(ArrayList<Congenere_combo> comboCongenere) {
		this.comboCongenere = comboCongenere;
	}

	public ArrayList<Segmento> getComboSegmento() {
		return comboSegmento;
	}

	public void setComboSegmento(ArrayList<Segmento> comboSegmento) {
		this.comboSegmento = comboSegmento;
	}

	public boolean isRet() {
		return ret;
	}

	public void setRet(boolean ret) {
		this.ret = ret;
	}

	public boolean isShowNewButton() {
		return showNewButton;
	}

	public void setShowNewButton(boolean showNewButton) {
		this.showNewButton = showNewButton;
	}

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
		this.showNewButton = false;
		Fisica = new Pfisica();
		beneficios = new Beneficios();
		try {
			PfisicaDAO dao = new PfisicaDAO();
			itens = dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - " + ex.getMessage());
		}
	}

	public void salvarRelac() {
		PfisicaDAO dao = new PfisicaDAO();
		try {
			dao.salvarRelac(Fisica);
			JSFUtil.adicionarMensagemSucesso(" Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  002 - " + ex.getMessage());
		}

	}

	public void localizar() {

		PfisicaDAO dao = new PfisicaDAO();

		try {
			dao.localizar(Fisica);
		} catch (SQLException e) {

			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public boolean verifycpf() {
		PfisicaDAO dao = new PfisicaDAO();
		try {
			this.showNewButton = dao.verifycpf(Fisica);

		} catch (SQLException e) {

			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		return ret;
	}

	public void verifypf() {

		PfisicaDAO dao = new PfisicaDAO();
		try {
			dao.verifypf(Fisica, Depend);
		} catch (SQLException e) {

			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void hidebutton() {
		this.showNewButton = false;
	}

	public void prepararNovo() {
		Fisica = new Pfisica();
		this.showNewButton = false;

		EmpresacomboDAO dao = new EmpresacomboDAO();
		ParentescoDAO dao1 = new ParentescoDAO();
		ProfissaoDAO dao2 = new ProfissaoDAO();
		EstadocivilDAO dao3 = new EstadocivilDAO();
		PfisicaDAO dao4 = new PfisicaDAO();
		CongenerecomboDAO dao5 = new CongenerecomboDAO();

		try {
			dao4.getIdclientpf(Fisica);

			comboEmpresa = dao.listar();
			comboParentesco = dao1.listar();
			comboProfissao = dao2.listar();
			comboEstadocivils = dao3.listar();
			comboCongenere = dao5.listar();

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}

	public void prepararNovoBen() {
		Fisica = new Pfisica();

		PapoliceDAO dao6 = new PapoliceDAO();

		try {
			comboApolices = dao6.listar();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	public void getcongeneres() {
		PfisicaDAO dao = new PfisicaDAO();

		try {
			comboCongenere = dao.getcongeneres(Fisica);
		} catch (SQLException e) {

			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	public void getapolices() {

		PfisicaDAO dao = new PfisicaDAO();

		try {
			comboApolice = dao.getapolice(Fisica);
		} catch (SQLException e) {

			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void getprodfromcia() {

		PfisicaDAO dao = new PfisicaDAO();

		try {
			comboSegmento = dao.getprodfromcia(Fisica);
		} catch (SQLException e) {

			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
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

	public void prepararListarBen() {
		PfisicaDAO dao4 = new PfisicaDAO();

		try {
			itensbeneficios = dao4.getbeneficios(Fisica);
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}

	// public void prepararNovoBenef() {
	// Beneficio = new Segmento();
	//
	// CongenerecomboDAO dao5 = new CongenerecomboDAO();
	// EmpresacomboDAO dao = new EmpresacomboDAO();
	//
	// try {
	// comboEmpresa = dao.listar();
	// comboCongenere = dao5.listar();
	//
	// } catch (SQLException ex) {
	// ex.printStackTrace();
	// JSFUtil.adicionarMensagemErro(ex.getMessage());
	// }
	// }

	public void prepararEditar() {
		EmpresacomboDAO dao = new EmpresacomboDAO();
		ParentescoDAO dao1 = new ParentescoDAO();
		ProfissaoDAO dao2 = new ProfissaoDAO();
		EstadocivilDAO dao3 = new EstadocivilDAO();
		CongenerecomboDAO dao5 = new CongenerecomboDAO();
		try {
			comboEmpresa = dao.listar();
			comboParentesco = dao1.listar();
			comboProfissao = dao2.listar();
			comboEstadocivils = dao3.listar();
			comboCongenere = dao5.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}

	public void novo() {

		try {
			PfisicaDAO dao = new PfisicaDAO();
			// EmpresacomboDAO edao = new EmpresacomboDAO();
			// ParentescoDAO dao1 = new ParentescoDAO();
			// ProfissaoDAO dao2 = new ProfissaoDAO();
			// EstadocivilDAO dao3 = new EstadocivilDAO();
			// CongenerecomboDAO dao5 = new CongenerecomboDAO();
			dao.salvar(Fisica);
			this.showNewButton = false;
			itens = dao.listar();
			// comboEmpresa = edao.listar();
			// comboParentesco = dao1.listar();
			// comboProfissao = dao2.listar();
			// comboEstadocivils = dao3.listar();
			// comboCongenere = dao5.listar();
			JSFUtil.adicionarMensagemSucesso("Registro Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  002 - " + ex.getMessage());
		}

	}

	public void excluir() {

		try {
			PfisicaDAO dao = new PfisicaDAO();
			EmpresacomboDAO edao = new EmpresacomboDAO();
			CongenerecomboDAO dao5 = new CongenerecomboDAO();
			ParentescoDAO dao1 = new ParentescoDAO();
			ProfissaoDAO dao2 = new ProfissaoDAO();
			EstadocivilDAO dao3 = new EstadocivilDAO();

			dao.excluir(Fisica);
			itens = dao.listar();
			comboEmpresa = edao.listar();
			comboParentesco = dao1.listar();
			comboProfissao = dao2.listar();
			comboEstadocivils = dao3.listar();
			comboCongenere = dao5.listar();
			JSFUtil.adicionarMensagemSucesso("Registro Removido com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
		}

	}

	public void buscarOne() {

		try {
			PfisicaDAO dao = new PfisicaDAO();
			dao.buscaOneDepend(Depend);

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

			PfisicaDAO dao = new PfisicaDAO();
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
