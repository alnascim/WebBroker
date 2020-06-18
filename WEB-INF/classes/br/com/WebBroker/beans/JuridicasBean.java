package br.com.WebBroker.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.WebBroker.dao.AngariadorcomboDAO;
import br.com.WebBroker.dao.PagenciaDAO;
import br.com.WebBroker.dao.PjuridicasDAO;
import br.com.WebBroker.dao.SegmentoDAO;
import br.com.WebBroker.domain.Angariador_combo;
import br.com.WebBroker.domain.Empresa_combo;
import br.com.WebBroker.domain.EmpresasLemara_combo;
import br.com.WebBroker.domain.Pagencia;
import br.com.WebBroker.domain.Pjuridicas;
import br.com.WebBroker.domain.Segmento;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBJuridicas")
@SessionScoped 
public class JuridicasBean {

	
	private ArrayList<Pjuridicas> itens;
	private ArrayList<Pjuridicas> itensfiltrados;
	private Pjuridicas juridica;
	private ArrayList<Angariador_combo> comboAngariador;
	private ArrayList<Empresa_combo> comboEmpresa;
	private ArrayList<Segmento> comboSegmento;
	private ArrayList<Pagencia> comboAgencia;
	private ArrayList<EmpresasLemara_combo> comboEmpresaGrupo;

	public ArrayList<EmpresasLemara_combo> getComboEmpresaGrupo() {
		return comboEmpresaGrupo;
	}

	public void setComboEmpresaGrupo(
			ArrayList<EmpresasLemara_combo> comboEmpresaGrupo) {
		this.comboEmpresaGrupo = comboEmpresaGrupo;
	}
	public Pjuridicas getJuridicas() {
		return juridica;
	}

	public void setJuridicas(Pjuridicas juridica) {
		this.juridica = juridica;
	}
	       
	public Pjuridicas getPjuridica() {
		return juridica;
	}

	public void setPjuridica(Pjuridicas juridica) {

		this.juridica = juridica;
	}

	public ArrayList<Pjuridicas> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Pjuridicas> itens) {
		this.itens = itens;
	}

	public ArrayList<Pjuridicas> getItensfiltrados() {
		return itensfiltrados;
	}

	public void setItensfiltrados(ArrayList<Pjuridicas> itensfiltrados) {
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
			PjuridicasDAO dao = new PjuridicasDAO();

			itens = dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - " + ex.getMessage());
		}
	}
	public void localizar() {

		PjuridicasDAO dao = new PjuridicasDAO();
 
		try {
			dao.localizar(juridica);
		} catch (SQLException e) {

			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}	
	public void prepararNovo() {
		juridica = new Pjuridicas();
 
		AngariadorcomboDAO dao = new AngariadorcomboDAO();
		SegmentoDAO seg = new SegmentoDAO();
		PagenciaDAO age = new PagenciaDAO();
		PjuridicasDAO pj = new PjuridicasDAO();
		
		try {
			comboAngariador = dao.listar();
			comboEmpresa = dao.listard();
			comboSegmento = seg.listar();
			comboAgencia = age.listar();
			comboEmpresaGrupo=pj.EmpresasGrupo();
			
		} catch (SQLException e) {

			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void prepararEditar() {

		AngariadorcomboDAO dao = new AngariadorcomboDAO();
		SegmentoDAO seg = new SegmentoDAO();
		PagenciaDAO age = new PagenciaDAO();
		PjuridicasDAO pj = new PjuridicasDAO();
		
		try {
			comboAngariador = dao.listar();
			comboEmpresa = dao.listard();
			comboSegmento = seg.listar();
			comboAgencia = age.listar();
			comboEmpresaGrupo=pj.EmpresasGrupo();
		} catch (SQLException e) {

			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void novo() {

		try {
			PjuridicasDAO dao = new PjuridicasDAO();
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
			PjuridicasDAO dao = new PjuridicasDAO();
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
			PjuridicasDAO dao = new PjuridicasDAO();
			dao.editar(juridica);
			itens = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Registro Alterado com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
		}
	}
}
