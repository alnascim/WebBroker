package br.com.WebBroker.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.WebBroker.dao.AngariadorcomboDAO;
import br.com.WebBroker.dao.PagenciaDAO;
import br.com.WebBroker.dao.PjuridicaDAO;
import br.com.WebBroker.dao.SegmentoDAO;
import br.com.WebBroker.domain.Angariador_combo;
import br.com.WebBroker.domain.Empresa_combo;
import br.com.WebBroker.domain.Pagencia;
import br.com.WebBroker.domain.Pfisica;
import br.com.WebBroker.domain.Pjuridica;
import br.com.WebBroker.domain.Segmento;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBJuridica")
@SessionScoped 
public class JuridicaBean {

	private ArrayList<Pjuridica> itens;
	private ArrayList<Pjuridica> itensfiltrados;
	private ArrayList<Pfisica> beneficiarios;
	
	private Pjuridica juridica;

	private ArrayList<Angariador_combo> comboAngariador;
	private ArrayList<Empresa_combo> comboEmpresa;
	private ArrayList<Segmento> comboSegmento;
	private ArrayList<Pagencia> comboAgencia;

	public ArrayList<Pfisica> getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(ArrayList<Pfisica> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}
	public Pjuridica getJuridica() {
		return juridica;
	}

	public void setJuridica(Pjuridica juridica) {
		this.juridica = juridica;
	}
	       
	public Pjuridica getPjuridica() {
		return juridica;
	}

	public void setPjuridica(Pjuridica juridica) {

		this.juridica = juridica;
	}

	public ArrayList<Pjuridica> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Pjuridica> itens) {
		this.itens = itens;
	}

	public ArrayList<Pjuridica> getItensfiltrados() {
		return itensfiltrados;
	}

	public void setItensfiltrados(ArrayList<Pjuridica> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}

	public ArrayList<Empresa_combo> getComboEmpresa() {
		return comboEmpresa;
	}

	public void setComboEmpresa(ArrayList<Empresa_combo> comboEmpresa) {
		this.comboEmpresa = comboEmpresa;
	}

	public ArrayList<Segmento> getComboSegmento() {
		return comboSegmento;
	}

	public void setComboSegmento(ArrayList<Segmento> comboSegmento) {
		this.comboSegmento = comboSegmento;
	}

	public ArrayList<Pagencia> getComboAgencia() {
		return comboAgencia;
	}

	public void setComboAgencia(ArrayList<Pagencia> comboAgencia) {
		this.comboAgencia = comboAgencia;
	}
	
	public ArrayList<Angariador_combo> getComboAngariador() {
		return comboAngariador;
	}

	public void setComboAngariador(ArrayList<Angariador_combo> comboAngariador) {
		this.comboAngariador = comboAngariador;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			PjuridicaDAO dao = new PjuridicaDAO();

			itens = dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - " + ex.getMessage());
		}
	}
	public void localizar() {

		PjuridicaDAO dao = new PjuridicaDAO();
 
		try {
			dao.localizar(juridica);
		} catch (SQLException e) {

			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}	
	
	public void prepararListarPF() {
		PjuridicaDAO dao = new PjuridicaDAO();

		try {
			beneficiarios = dao.buscaBeneficiarios(juridica);
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void prepararNovo() {
		juridica = new Pjuridica();
 
		AngariadorcomboDAO dao = new AngariadorcomboDAO();
		SegmentoDAO seg = new SegmentoDAO();
		PagenciaDAO age = new PagenciaDAO();
		
		try {
			comboAngariador = dao.listar();
			comboEmpresa = dao.listard();
			comboSegmento = seg.listar();
			comboAgencia = age.listar();
			
		} catch (SQLException e) {

			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void prepararEditar() {

		AngariadorcomboDAO dao = new AngariadorcomboDAO();
		SegmentoDAO seg = new SegmentoDAO();
		PagenciaDAO age = new PagenciaDAO();
		
		try {
			comboAngariador = dao.listar();
			comboEmpresa = dao.listard();
			comboSegmento = seg.listar();
			comboAgencia = age.listar();
			
		} catch (SQLException e) {

			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	public void novo_seg() {

		try {
			PjuridicaDAO dao = new PjuridicaDAO();
			dao.salvar_seg(juridica);
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Registro Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  002 - " + ex.getMessage());
		}

	}
	public void novo() {

		try {
			PjuridicaDAO dao = new PjuridicaDAO();
			dao.salvar(juridica);
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Registro Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  002 - " + ex.getMessage());
		}

	}
	
	public void excluir() {

		try {
			PjuridicaDAO dao = new PjuridicaDAO();
			dao.excluir(juridica);
			itens = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Registro Removido com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
		}

	}
	public void editar() {

		try {
			PjuridicaDAO dao = new PjuridicaDAO();
			dao.editar(juridica);
			itens = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Registro Alterado com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
		}
	}
}
