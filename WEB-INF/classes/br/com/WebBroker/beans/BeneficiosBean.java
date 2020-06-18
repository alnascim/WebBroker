package br.com.WebBroker.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.CongenerecomboDAO;
import br.com.WebBroker.dao.EmpresacomboDAO;
import br.com.WebBroker.dao.PBeneficioDAO;
import br.com.WebBroker.domain.Beneficios;
import br.com.WebBroker.domain.Congenere_combo;
import br.com.WebBroker.domain.Empresa_combo;
import br.com.WebBroker.domain.Pfisica;
import br.com.WebBroker.domain.Segmento;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBeneficios")
@ViewScoped
public class BeneficiosBean {
		
	private Pfisica Fisica;
	private Beneficios beneficios;
	private ArrayList<Beneficios> itens;
	private ArrayList<Beneficios> itensfiltrados;
	private ArrayList<Empresa_combo> comboEmpresa;
	private ArrayList<Congenere_combo> comboCongenere;	
	private ArrayList<Segmento> comboSegmento;
	private ArrayList<Segmento> comboApolice;

	public ArrayList<Segmento> getComboSegmento() {
		return comboSegmento;
	}

	public void setComboSegmento(ArrayList<Segmento> comboSegmento) {
		this.comboSegmento = comboSegmento;
	}

	public ArrayList<Segmento> getComboApolice() {
		return comboApolice;
	}

	public void setComboApolice(ArrayList<Segmento> comboApolice) {
		this.comboApolice = comboApolice;
	}
	public ArrayList<Empresa_combo> getComboEmpresa() {
		return comboEmpresa;
	}

	public void setComboEmpresa(ArrayList<Empresa_combo> comboEmpresa) {
		this.comboEmpresa = comboEmpresa;
	}

	public ArrayList<Congenere_combo> getComboCongenere() {
		return comboCongenere;
	}

	public void setComboCongenere(ArrayList<Congenere_combo> comboCongenere) {
		this.comboCongenere = comboCongenere;
	}	
	public Beneficios getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(Beneficios beneficios) {
		this.beneficios = beneficios;
	}

	public ArrayList<Beneficios> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Beneficios> itens) {
		this.itens = itens;
	}

	public ArrayList<Beneficios> getItensfiltrados() {
		return itensfiltrados;
	}

	public void setItensfiltrados(ArrayList<Beneficios> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}
//	@PostConstruct
//	public void prepararPesquisa() {
//		beneficios = new Beneficios();
//		Fisica = new Pfisica();
//		try {
//			PBeneficioDAO dao = new PBeneficioDAO();
////			itens = dao.getbeneficios(Fisica);
//
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			JSFUtil.adicionarMensagemErro("Erro  001 - " + ex.getMessage());
//		}
//	}
	public void prepararNovo() {
		CongenerecomboDAO dao5 = new CongenerecomboDAO();
		EmpresacomboDAO dao = new EmpresacomboDAO();
		
		beneficios = new Beneficios();
		
		try {
			
			comboEmpresa = dao.listar();
			comboCongenere = dao5.listar();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	public void salvarRelac() {
		PBeneficioDAO dao = new PBeneficioDAO();
		try {
			dao.salvarRelac(beneficios);
			JSFUtil.adicionarMensagemSucesso(" Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  002 - " + ex.getMessage());
		}

	}
//	public void popularCombos() {
//		beneficios = new Beneficios();
//		Fisica = new Pfisica();
//		EmpresacomboDAO dao = new EmpresacomboDAO();
//		CongenerecomboDAO dao7 = new CongenerecomboDAO();
//		PBeneficioDAO dao1 = new PBeneficioDAO();
//		try {
//			comboCongenere = dao7.listar();
//			comboEmpresa = dao.listar();
//			itens = dao1.getbeneficios(Fisica);
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			JSFUtil.adicionarMensagemErro(ex.getMessage());
//		}
//	}
//	public void excluir() {
//		CongenerecomboDAO dao7 = new CongenerecomboDAO();
//		NcociacomboDAO dao8 = new NcociacomboDAO();
//		SegmentoDAO dao = new SegmentoDAO();
//		try {
//			dao.excluir(segmento);
//			itens = dao.listar();
//			comboCongenere = dao7.listar();
//			comboncocia = dao8.listar();
//			comboproduto = dao.listarproduto();
//
//			JSFUtil.adicionarMensagemSucesso("Removido com Sucesso!");
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
//		}
//
//	}

//	public void editar() {
//		CongenerecomboDAO dao7 = new CongenerecomboDAO();
//		NcociacomboDAO dao8 = new NcociacomboDAO();
//		SegmentoDAO dao = new SegmentoDAO();
//		try {
//
//			dao.editar(segmento);
//			comboCongenere = dao7.listar();
//			comboncocia = dao8.listar();
//			comboproduto = dao.listarproduto();
//			itens = dao.listar();
//			JSFUtil.adicionarMensagemSucesso(" Alterado com Sucesso!");
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			JSFUtil.adicionarMensagemErro("Erro Usuário 003 - "
//					+ ex.getMessage());
//		}
//	}
}
